/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.proxy.HibernateProxy;
import services.GrilleService;

/**
 *
 * @author Anis
 */
public class Dao implements Serializable {

    Transaction transaction = null;

    public <T> void save(final T o) {
        transaction = HibernateUtil.currentSession().beginTransaction();
        System.out.println("Insertion bd : " + ((T) o).toString());
        HibernateUtil.currentSession().save(o);
        transaction.commit();
    }

    public void delete(final Object object) {
        HibernateUtil.currentSession().delete(object);
    }

    /**
     *
     */
    public <T> T get(final Class<T> type, final Long id) {
        return (T) HibernateUtil.currentSession().get(type, id);
    }
    
    

    /**
     *
     */
    public <T> T merge(final T o) {
        return (T) HibernateUtil.currentSession().merge(o);
    }

    /**
     *
     */
    public <T> void saveOrUpdate(final T o) {
        HibernateUtil.currentSession().saveOrUpdate(o);
    }

    public <T> List<T> getAll(final Class<T> type) {
        final Session session = HibernateUtil.currentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
        
    }

    public static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }

}
