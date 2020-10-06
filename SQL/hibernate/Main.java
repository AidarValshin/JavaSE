package ru.Aidar.SQL.hibernate;

import ru.Aidar.SQL.hibernate.services.UserService;
import ru.Aidar.SQL.hibernate.utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        System.out.println("insert");
        System.out.println
                (userService.saveUser(new String[]{"Masha", "Petrovna", "Ivanova"}, 2));
        userService.findAllUsersFiltred(null).forEach(u -> System.out.println(u));
        System.out.println("filtred get all: id+gender=1");
        userService.findAllUsersFiltred("  id_gender =1")
                .forEach(u -> System.out.println(u));
        //pagination
        System.out.println("pagination");
        userService.findAllUsersPagination(0, 2).forEach(u -> System.out.println(u));
        System.out.println();
        userService.findAllUsersPagination(2, 2).forEach(u -> System.out.println(u));
        System.out.println();
        userService.findAllUsersPagination(4, 30).forEach(u -> System.out.println(u));

        //findUser
        System.out.println("findUser = 1");
        System.out.println(userService.findUser(1));
        //update
        System.out.println("update");
        userService.updateUser(33, new String[]{"АААААААААа", "ББ", "СС"}, 1);


        //delete
        System.out.println("delete id =4");
        userService.deleteUser(4);
        userService.findAllUsersFiltred(null).forEach(u -> System.out.println(u));
      /*  Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);

       */
        HibernateSessionFactoryUtil.
                getSessionFactory().close();
        return;
    }
}

