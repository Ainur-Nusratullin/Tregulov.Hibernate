package com.zaurtregulov.relationships.one_to_one;

import com.zaurtregulov.relationships.one_to_one.entity.Passport;
import com.zaurtregulov.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
//            PERSIST
//            Student student = new Student("Farnkie", "Perry", 5.8);
//            Passport passport = new Passport("frankie.perry@yandex.ru", 185
//                    , "blue");
//
//            passport.setStudent(student);
//            student.setPassport(passport);
//            entityManager.persist(passport);
            //FIND
//            Passport passport = entityManager.find(Passport.class, 2);
//            System.out.println(passport);
//            System.out.println(passport.getStudent());
            //REMOVE
//            Passport passport = entityManager.find(Passport.class, 2);
//            entityManager.remove(passport);
            Passport passport = entityManager.find(Passport.class, 3);
            passport.getStudent().setPassport(null);

            entityManager.remove(passport);




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
