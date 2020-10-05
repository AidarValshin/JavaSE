package ru.Aidar.SQL.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.Aidar.SQL.hibernate.models.User;
import ru.Aidar.SQL.hibernate.utils.HibernateSessionFactoryUtil;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements IDaoRepo<User> {

    @Override
    public List<User> getAll(String filter) {
        List<User> users=null;
        if(filter!=null) {
             users = (List<User>) HibernateSessionFactoryUtil.
                    getSessionFactory().openSession()
                    .createQuery("from User where " + filter).list();
        }
        else{
            users = (List<User>) HibernateSessionFactoryUtil.
                    getSessionFactory().openSession()
                    .createQuery("from User ").list();
        }
        return users;
    }

    @Override
    public List<User> getAllPagination(int start, int number) {
        Criteria criteria =HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createCriteria(User.class);
        criteria.setFirstResult(start);
        // Set the maximum number of records to read
        criteria.setMaxResults(number);

        List<User> users = criteria.list();

        return users;
    }

    @Override
    public User getById(int id)  {
        return (User) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void update(int id, String[] params, int id_genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(new User(id,params[0],params[1],params[2],id_genre));
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = (User)session.load(User.class,id);
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public int insert(String[] params, int id_genre) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user =new User(params[0],params[1],params[2],id_genre);
        session.save(user);
        tx1.commit();
        session.close();
        return user.getId_cont();
    }

}
