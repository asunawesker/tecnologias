/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.uv.util.JPAUtil;

/**
 *
 * @author asunawesker
 */
public class StudentDao implements IDaoGeneral<Student>{
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    @Override
    public void create(Student pojo) {
        entity.getTransaction().begin();
        entity.persist(pojo);
        entity.getTransaction().commit();
    }

    @Override
    public void detele(Student pojo) {
        entity.getTransaction().begin();
        entity.remove(pojo);
        entity.getTransaction().commit();
    }

    @Override
    public Student readOne(Student pojo) {
        return entity.find(Student.class, pojo.getIdcard());
    }

    @Override
    public List<Student> readAll() {
        Query query = (Query) entity.createQuery("FROM student");
        return (List<Student>) query.list();
    }

    @Override
    public void update(Student pojo) {
        entity.getTransaction().begin();
        entity.merge(pojo);
        entity.getTransaction().commit();
    }
}
