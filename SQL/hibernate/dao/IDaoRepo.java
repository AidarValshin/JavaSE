package ru.Aidar.SQL.hibernate.dao;

import java.sql.SQLException;
import java.util.List;


public interface IDaoRepo<E> {

    public abstract List<E> getAll(String filter);

    public abstract List<E> getAllPagination(int start, int number);


    public abstract E getById(int id) throws SQLException;

    public abstract void update(int id, String[] params, int id_genre);

    public abstract void delete(int id) throws SQLException;

    public abstract int insert(String[] params, int id_genre);



}
