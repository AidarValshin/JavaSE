package ru.Aidar.SQL.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.Aidar.SQL.hibernate.models.User;
import ru.Aidar.SQL.hibernate.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserDaoImplHQL implements IDaoRepo<User> {
    @Override
    public List<User> getAll(String filter) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Query query = null;
        if (filter == null) {
            query = session.createQuery("FROM User");
        } else {
            query = session.createQuery("FROM User U WHERE U." + filter);
        }
        List<User> users = query.list();
        session.close();
        return users;
    }

    @Override
    public List<User> getAllPagination(int start, int number) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Query query = session.createQuery("FROM User");
        query.setFirstResult(start);
        query.setMaxResults(number);
        List<User> users = query.list();
        session.close();
        return users;
    }

    @Override
    public User getById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Query query = session.createQuery("FROM User U WHERE U.id_cont =" + id);
        List<User> users = query.list();
        session.close();
        return users.get(0);
    }

    @Override
    public void update(int id, String[] params, int id_genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery
                ("UPDATE User SET " +
                        "first_name =:first_nameParam," +
                        "middle_name =:middle_nameParam," +
                        "last_name = :last_nameParam," +
                        "id_gender = :id_genderParam" +
                        " WHERE id_cont =:idParam");
        query.setParameter("first_nameParam", params[0]);
        query.setParameter("middle_nameParam", params[1]);
        query.setParameter("last_nameParam", params[2]);
        query.setParameter("id_genderParam", id_genre);
        query.setParameter("idParam", id);
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Query query = session.createQuery("DELETE FROM User WHERE id_cont =:idParam");
        query.setParameter("idParam", id);
        query.executeUpdate();
        session.close();
    }

    @Override
    public int insert(String[] params, int id_genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = new User(params[0], params[1], params[2], id_genre);
        session.save(user);
        tx1.commit();
        session.close();
        return user.getId_cont();
    }
}
