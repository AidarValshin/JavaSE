package ru.Aidar.SQL.hibernate.services;

import ru.Aidar.SQL.hibernate.dao.IDaoRepo;
import ru.Aidar.SQL.hibernate.dao.UserDaoImplCriteria;
import ru.Aidar.SQL.hibernate.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceCriteria {
    private IDaoRepo usersDao = new UserDaoImplCriteria();

    public UserServiceCriteria() {
    }

    public User findUser(int id) throws SQLException {
        return (User) usersDao.getById(id);
    }

    public int saveUser(String[] params, int id_genre) {
       return  usersDao.insert(params, id_genre);
    }

    public void deleteUser(int id) throws SQLException {
        usersDao.delete(id);
    }

    public void updateUser(int id, String[] params, int id_genre) {
        usersDao.update(id, params, id_genre);
    }

    public List<User> findAllUsersFiltred(String filter) {
        return usersDao.getAll(filter);
    }

    public List<User> findAllUsersPagination(int start, int number) {
        return usersDao.getAllPagination(start, number);
    }
}

