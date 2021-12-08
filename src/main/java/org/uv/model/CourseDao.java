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
public class CourseDao implements IDaoGeneral<Course>{
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    @Override
    public void create(Course pojo) {
        entity.getTransaction().begin();
        entity.persist(pojo);
        entity.getTransaction().commit();
    }

    @Override
    public void detele(Course pojo) {
        entity.getTransaction().begin();
        entity.remove(pojo);
        entity.getTransaction().commit();
    }

    @Override
    public Course readOne(Course pojo) {
        return entity.find(Course.class, pojo.getId());
    }

    @Override
    public List<Course> readAll() {
        Query query = (Query) entity.createQuery("FROM course");
        return (List<Course>) query.list();
    }

    @Override
    public void update(Course pojo) {
        entity.getTransaction().begin();
        entity.merge(pojo);
        entity.getTransaction().commit();
    }
    
}
