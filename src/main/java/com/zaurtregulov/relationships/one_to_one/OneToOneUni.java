package com.zaurtregulov.relationships.one_to_one;
import com.zaurtregulov.relationships.one_to_one.entity.Passport;
import com.zaurtregulov.relationships.one_to_one.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneToOneUni {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            //PERSIST
//            Student student1 = new Student("Isaac", "Sharp", 9.8);
//            Passport passport1 = new Passport("isaac.sharp@yandex.ru", 162
//                    , "brown");
//            student1.setPassport(passport1);
//
////            entityManager.persist(passport1);
//            entityManager.persist(student1);
            //FIND
//            Student student = entityManager.find(Student.class, 19);
//            System.out.println(student);
//            System.out.println(student.getPassport());
            //REMOVE
            Student student = entityManager.find(Student.class, 3);
            entityManager.remove(student);

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

