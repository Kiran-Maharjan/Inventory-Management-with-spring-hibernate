/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.ims.dao.impl;

import com.kingkong.ims.dao.GenericDAO;
import com.kingkong.ims.entity.Category;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author kiran
 * @param <T>
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction trans;
    private Class<T> persistentClass;
    public GenericDAOImpl(){
        this.persistentClass=(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Override
    public void insert(T t) {
        session = sessionFactory.openSession();
        trans = session.getTransaction();
        trans.begin();
        session.save(t);
        trans.commit();
        session.close();
    }

    @Override
    public void update(T t) {
        session = sessionFactory.openSession();
        trans = session.getTransaction();
        trans.begin();
        session.update(t);
        trans.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session = sessionFactory.openSession();
        trans = session.getTransaction();
        trans.begin();
        session.delete(session.get(persistentClass, id));
        trans.commit();
        session.close();
    }

    @Override
    public T getById(int id) {
        session = sessionFactory.openSession();
        T t = (T) session.get(Category.class, id);
        session.close();
        return  t;
    }

    @Override
    public List<T> getAll() {
        List<T> tList = null;
        session = sessionFactory.openSession();
        tList = session.getNamedQuery("SELECT c FROM t c").list();
        session.close();
        return  tList;
    }

}
