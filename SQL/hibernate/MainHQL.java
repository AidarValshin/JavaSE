package ru.Aidar.SQL.hibernate;

import ru.Aidar.SQL.hibernate.services.UserServiceCriteria;
import ru.Aidar.SQL.hibernate.services.UserServiceHQL;
import ru.Aidar.SQL.hibernate.utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;

public class MainHQL {
    public static void main(String[] args) throws SQLException {
        UserServiceHQL userServiceHQL = new UserServiceHQL();
        System.out.println("insert");
        System.out.println
                (userServiceHQL.saveUser(new String[]{"Masha", "Petrovna", "Ivanova"}, 2));
        userServiceHQL.findAllUsersFiltred(null).forEach(u -> System.out.println(u));
        System.out.println("filtred get all: id+gender=1");
        userServiceHQL.findAllUsersFiltred("  id_gender =1")
                .forEach(u -> System.out.println(u));
        //pagination
        System.out.println("pagination");
        userServiceHQL.findAllUsersPagination(0, 2).forEach(u -> System.out.println(u));
        System.out.println();
        userServiceHQL.findAllUsersPagination(2, 2).forEach(u -> System.out.println(u));
        System.out.println();
        userServiceHQL.findAllUsersPagination(4, 30).forEach(u -> System.out.println(u));

        //findUser
        System.out.println("findUser = 33");
        System.out.println(userServiceHQL.findUser(33));
        //update
        System.out.println("update");
        userServiceHQL.updateUser(33, new String[]{"АААААААААа", "ББ", "ССССССССССССССС"}, 1);

        //delete
        System.out.println("delete id =4");
        userServiceHQL.deleteUser(4);
        userServiceHQL.findAllUsersFiltred(null).forEach(u -> System.out.println(u));

        HibernateSessionFactoryUtil.
                getSessionFactory().close();
        return;
    }
}
