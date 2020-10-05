package ru.Aidar.SQL.JDBC.dao;

import ru.Aidar.SQL.JDBC.connection.ConnectionToBd;
import ru.Aidar.SQL.JDBC.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserJDBCDaoRepo implements IDaoRepo<User> {
    private static final Connection connection = ConnectionToBd.getDBConnection();
    private static PreparedStatement getAllStatement = null;
    private static PreparedStatement getAllPagination = null;
    private static PreparedStatement getByIdStatement = null;
    private static PreparedStatement updateStatement = null;
    private static PreparedStatement insertStatement = null;
    private static PreparedStatement deleteStatement = null;

    static {
        try {
                         /* String createUpdate="drop function if exists part2.get_result_update  (int,varchar,varchar,varchar,int);\n" +
                        "create or replace function part2.get_result_update  (in pId int,in pFirst_name varchar," +
                        " in pMiddle_name varchar, in pLast_name varchar, in pId_gender int," +
                        " out p2 int) as\n" +
                        "$BODY$\n" +
                        "begin \n" +
                        "update part2.user\n" +
                        "set first_name= pFirst_name,\n" +
                        "middle_name = pMiddle_name ,\n" +
                        "last_name = pLast_name ,\n" +
                        "id_gender =  pId_gender \n" +
                        "where id_cont =pId \n" +
                        "returning id_cont  into p2;\n" +
                        "return;\n" +
                        "end;\n" +
                        "$BODY$\n" +
                        "language plpgsql;";
                connection.prepareStatement(createUpdate).execute();
                           */
            getByIdStatement = connection.prepareStatement("Select * from part2.user WHERE id_cont=?");
            getAllStatement = connection.prepareStatement("Select * from part2.user ",
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            updateStatement = connection.prepareStatement("Select * from get_result_update(?,?,?,?,?)");
            insertStatement = connection.prepareStatement("insert into part2.user values( DEFAULT,?,?,?,?) returning  id_cont");
            deleteStatement = connection.prepareStatement(" delete from part2.user  where id_cont=?  returning id_cont");
            getAllPagination = connection.prepareStatement("Select * from part2.user order by id_cont offset ? limit ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll(String filter) {
        List<User> list = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rS = null;
            if (filter != null) {
                rS = statement.executeQuery("Select * from part2.user " + filter);
            } else {
                rS = getAllStatement.executeQuery();
            }
            list = new ArrayList<>();
            while (rS.next()) {
                list.add(new User(rS.getInt("id_cont"), rS.getString("first_name"),
                        rS.getString("middle_name"), rS.getString("last_name"),
                        rS.getInt("id_gender")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    @Override
    public List<User> getAllPagination(int start, int number) {
        List<User> list = null;
        try {
            getAllPagination.setInt(1, start);
            getAllPagination.setInt(2, number);
            ResultSet rS = getAllPagination.executeQuery();
            list = new ArrayList<>();
            while (rS.next()) {
                list.add(new User(rS.getInt("id_cont"), rS.getString("first_name"),
                        rS.getString("middle_name"), rS.getString("last_name"),
                        rS.getInt("id_gender")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }


    @Override
    public User getById(int id) {
        try {
            getByIdStatement.setInt(1, id);
            ResultSet rS = getByIdStatement.executeQuery();
            if (rS.next()) {
                return (new User(rS.getInt("id_cont"), rS.getString("first_name"),
                        rS.getString("middle_name"), rS.getString("last_name"),
                        rS.getInt("id_gender")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int id, String[] params, int id_genre) {
        try {
            updateStatement.setInt(1, id);
            updateStatement.setString(2, params[0]);
            updateStatement.setString(3, params[1]);
            updateStatement.setString(4, params[2]);
            updateStatement.setInt(5, id_genre);
            ResultSet rS = updateStatement.executeQuery();
            if (rS.next()) {
                return rS.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) throws SQLException {
        deleteStatement.setInt(1, id);
        ResultSet rS = deleteStatement.executeQuery();
        if (rS.next()) {
            return rS.getInt(1);
        }
        return -1;
    }

    @Override
    public int insert(String[] params, int id_genre) {
        ResultSet rS = null;
        try {
            insertStatement.setString(1, params[0]);
            insertStatement.setString(2, params[1]);
            insertStatement.setString(3, params[2]);
            insertStatement.setInt(4, id_genre);
            rS = insertStatement.executeQuery();
            rS.next();

            return rS.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void closePrepareStatement() {

        try {
            connection.close();
            if (getAllStatement != null) {
                getAllStatement.close();
            }
            if (getByIdStatement != null) {
                getByIdStatement.close();
            }
            if (updateStatement != null) {
                updateStatement.close();
            }
            if (insertStatement != null) {
                insertStatement.close();
            }
            if (deleteStatement != null) {
                deleteStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
