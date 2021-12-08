/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.model;

import java.util.List;

/**
 *
 * @author asunawesker
 */
public interface IDaoGeneral <T> {
    public void create(T pojo);
    
    public void detele(T pojo);
    
    public T readOne(T pojo);
    
    public List<T> readAll();
    
    public void update(T pojo);
}
