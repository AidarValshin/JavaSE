package ru.Aidar.SQL.hibernate;

import ru.Aidar.SQL.hibernate.services.UserServiceCriteria;
import ru.Aidar.SQL.hibernate.utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;

public class MainCriteria {
    public static void main(String[] args) throws SQLException {
        UserServiceCriteria userServiceCriteria = new UserServiceCriteria();
        System.out.println("insert");
        System.out.println
                (userServiceCriteria.saveUser(new String[]{"Masha", "Petrovna", "Ivanova"}, 2));
        userServiceCriteria.findAllUsersFiltred(null).forEach(u -> System.out.println(u));
        System.out.println("filtred get all: id+gender=1");
        userServiceCriteria.findAllUsersFiltred("  id_gender =1")
                .forEach(u -> System.out.println(u));
        //pagination
        System.out.println("pagination");
        userServiceCriteria.findAllUsersPagination(0, 2).forEach(u -> System.out.println(u));
        System.out.println();
        userServiceCriteria.findAllUsersPagination(2, 2).forEach(u -> System.out.println(u));
        System.out.println();
        userServiceCriteria.findAllUsersPagination(4, 30).forEach(u -> System.out.println(u));

        //findUser
        System.out.println("findUser = 1");
        System.out.println(userServiceCriteria.findUser(1));
        //update
        System.out.println("update");
        userServiceCriteria.updateUser(33, new String[]{"АААААААААа", "ББ", "СС"}, 1);

        //delete
        System.out.println("delete id =4");
        userServiceCriteria.deleteUser(4);
        userServiceCriteria.findAllUsersFiltred(null).forEach(u -> System.out.println(u));

        HibernateSessionFactoryUtil.
                getSessionFactory().close();
        return;
    }
}

