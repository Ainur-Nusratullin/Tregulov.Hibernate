package com.zaurtregulov.jpa_crud;

import com.zaurtregulov.entity.Student;
import jakarta.persistence.*;

import java.sql.SQLException;

public class Persist_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Student student = null;
        try{
            transaction.begin();
            student = new Student("Julia", "Dean", 8.7);
            entityManager.persist(student);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
                factory.close();
            }
        }
        System.out.println(student);
    }
}
