/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.model;

/**
 *
 * @author asunawesker
 */
public class FactoryDao {
    
    public enum TypeDAO {STUDENT, PROFESSOR, COURSE};
    
    public static IDaoGeneral create(TypeDAO type){
        
        IDaoGeneral dao = null;
        
        switch(type){
            case COURSE:
                dao = new CourseDao();
                break;
            case STUDENT:
                dao = new StudentDao();
                break;
            case PROFESSOR:
                dao = new ProfessorDao();
                break;
        }
        return dao;
    } 
    
}
