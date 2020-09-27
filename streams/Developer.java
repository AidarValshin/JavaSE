package ru.Aidar.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Developer {

    private String name;
    private List<String> languages;

    public Developer(String name, List<String> languages) {
        this.name = name;
        this.languages = languages;
    }
    //плюс геттеры и сеттеры


    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<>();
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);


        map = developerStream.flatMap(p -> p.getLanguages().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> finalMap = map;
        Predicate<? super ru.Aidar.streams.Developer> predicate = new java.util.function.Predicate<>() {
            @Override
            public boolean test(Developer developer) {
                List<String> languages = developer.getLanguages();
                for (String language : languages) {
                    if (finalMap.get(language) == 1) {
                        return true;
                    }
                }
                return false;
            }
        };

        Set<String> set = Stream.of(dev1, dev2, dev3)
                .filter(predicate)
                .map(p -> p.getName())
                .collect(Collectors.toSet());

        for (Map.Entry<String, Long> item : map.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
        System.out.println(set);

// другой варик
        List<Developer> developersWithUniqueLanguages = developerStream
                .flatMap(developer -> developer.getLanguages().stream()
                        .map(language -> new AbstractMap.SimpleEntry<>(language, developer))
                )
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue, (a, b) -> null))
                .values().stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
