package ru.Aidar.SQL.JDBC.dao;

import java.sql.SQLException;
import java.util.List;


public interface IDaoRepo<E> {

    public abstract List<E> getAll(String filter);

    public abstract List<E> getAllPagination(int start, int number);


    public abstract E getById(int id) throws SQLException;

    public abstract int update(int id, String[] params, int id_genre);

    public abstract int delete(int id) throws SQLException;

    public abstract int insert(String[] params, int id_genre);

    public abstract void closePrepareStatement();

}
