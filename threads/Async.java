package ru.Aidar.threads;

public class Async {
    public static void asyncMethod() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
            }
            System.out.println("Асинхронный привет!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println("Асинхронный пока !");
        }
    }

    public static void main(String[] args) {
        new Thread(Async::asyncMethod).start();
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            System.out.println("Работает основная программа");
        }
    }
}
