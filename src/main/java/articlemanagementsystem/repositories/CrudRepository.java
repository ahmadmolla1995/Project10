package articlemanagementsystem.repositories;

import articlemanagementsystem.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;


public abstract class CrudRepository<T extends Object, S extends Serializable> {
    private Session session = HibernateUtil.getSession();

    protected abstract Class<T> getEntityClass();

    public T save(T entity) {
        try {
            session.beginTransaction();
            session.save(entity);
        } finally {
            session.getTransaction().commit();
        }

        return entity;
    }

    public T update(T entity) {
        try {
            session.beginTransaction();
            session.update(entity);
        } finally {
            session.getTransaction().commit();
        }

        return entity;
    }

    public void delete(T entity) {
        try {
            session.beginTransaction();
            session.delete(entity);
        } finally {
            session.getTransaction().commit();
        }
    }

    public List<T> findAll () {
        session.beginTransaction();
        List<T> itemsList = session.createQuery("from " + getEntityClass().getName()).list();
        session.getTransaction().commit();

        return itemsList;
    }

    public List<T> findAll(String attribute, String value) {
        session.beginTransaction();
        List<T> entities = session.createQuery("from " + getEntityClass().getName() + " where " + attribute + "=" + value).list();
        session.getTransaction().commit();

        return entities;
    }

    public T find (String attribute, String value) {
        T entity;

        try {
            session.beginTransaction();
            entity = (T) session.createQuery("from " + getEntityClass().getName() + " where " + attribute + "=" + value).getSingleResult();
        } finally {
            session.getTransaction().commit();
        }

        return entity;
    }
}


