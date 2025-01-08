package com.zaurtregulov.relationships.one_to_many;

import com.zaurtregulov.relationships.one_to_many.entity.Student;
import com.zaurtregulov.relationships.one_to_many.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;

public class OneToManyBi {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-course");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            //PERIST
//            University university = new University("MIT", Date.valueOf("1861-04-10"));
//
//            Student student1 = new Student("Isaac", "Sharp", 9.8);
//            Student student2 = new Student("Sirena", "Nielsen", 7.2);
//
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);

//            entityManager.persist(university);

//            Student student3 = new Student("Roy", "Harper", 7.9);
//            Student student4 = new Student("Eric", "Scott", 7.4);
//            University university = new University("Oxford", Date.valueOf("1200-09-01"));
//
//            university.addStudentToUniversity(student3);
//            university.addStudentToUniversity(student4);
//
//            entityManager.persist(student3);
            //FIND
//            University university = entityManager.find(University.class, 2);
//            System.out.println(university);
//            System.out.println(university.getStudents());

//            Student student = entityManager.find(Student.class, 2);
//            System.out.println(student);
//            System.out.println(student.getUniversity());
//            System.out.println(student.getUniversity().getStudents());
            Student student = entityManager.find(Student.class, 4);
            entityManager.remove(student);

            //REMOVE


            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }

    }
}
