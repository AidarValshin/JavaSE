package ru.Aidar.SQL.JDBC;

import ru.Aidar.SQL.JDBC.dao.UserJDBCDaoRepo;

import java.sql.SQLException;

public class UserApplication {
    private static UserJDBCDaoRepo userDao;

    public static void main(String[] args) throws SQLException {
        //getAll
        userDao = new UserJDBCDaoRepo();
        userDao.getAll(null).forEach(user -> System.out.println(user));
        System.out.println("filtred get all: id+gender=1");
        userDao.getAll(" where id_gender =1").forEach(user -> System.out.println(user));
        //getById
        System.out.println("getById = 1");
        System.out.println(userDao.getById(1));
        //update
        System.out.println("update");
        System.out.println(userDao.update(1, new String[]{"АААААААААа", "ББ", "СС"}, 2));
        userDao.getAll(null).forEach(user -> System.out.println(user));
        //insert
        System.out.println("insert ");
        System.out.println(userDao.insert(new String[]{"Привет", "Это", "Вставка"}, 1));
        userDao.getAll(null).forEach(user -> System.out.println(user));
        //delete
        System.out.println("delete id =2");
        System.out.println(userDao.delete(2));
        //pagination
        System.out.println("pagination");
        userDao.getAllPagination(0, 2).forEach(user -> System.out.println(user));
        System.out.println();
        userDao.getAllPagination(2, 2).forEach(user -> System.out.println(user));
        System.out.println();
        userDao.getAllPagination(4, 4).forEach(user -> System.out.println(user));

        userDao.closePrepareStatement();
        System.out.println();
    }
}