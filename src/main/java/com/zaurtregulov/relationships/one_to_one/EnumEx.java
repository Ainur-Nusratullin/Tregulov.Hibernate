package com.zaurtregulov.relationships.one_to_one;

import com.zaurtregulov.relationships.one_to_one.entity.EyeColor;
import com.zaurtregulov.relationships.one_to_one.entity.Passport;
import com.zaurtregulov.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EnumEx {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

//            Student student = new Student("Eric", "Scott", 7.4);
//            Passport passport = new Passport("eric.scott@yandex.ru", 173, EyeColor.GREEN);
//            student.setPassport(passport);
//
//            entityManager.persist(student);
            Student student = entityManager.find(Student.class, 1);
            System.out.println(student.getPassport());

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

    }
}
