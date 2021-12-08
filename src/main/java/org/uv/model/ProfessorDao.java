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
public class ProfessorDao implements IDaoGeneral<Professor>{
    
    EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    @Override
    public void create(Professor pojo) {
        entity.getTransaction().begin();
        entity.persist(pojo);
        entity.getTransaction().commit();
    }

    @Override
    public void detele(Professor pojo) {
        entity.getTransaction().begin();
        entity.remove(pojo);
        entity.getTransaction().commit();
    }

    @Override
    public Professor readOne(Professor pojo) {
        return entity.find(Professor.class, pojo.getIdcard());
    }

    @Override
    public List<Professor> readAll() {
        Query query = (Query) entity.createQuery("FROM professor");
        return (List<Professor>) query.list();
    }

    @Override
    public void update(Professor pojo) {
        entity.getTransaction().begin();
        entity.merge(pojo);
        entity.getTransaction().commit();
    }
}
