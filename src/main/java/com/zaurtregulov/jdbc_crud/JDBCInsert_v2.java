package com.zaurtregulov.jdbc_crud;

import com.zaurtregulov.entity.Student;

import java.sql.*;

public class JDBCInsert_v2 {

    static final String DB_URl = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {

        Student student = new Student("Leo", "Farrel", 8.4);

        try (Connection connection = DriverManager.getConnection(DB_URl, USER, PWD)){

            Statement statement = connection.createStatement();
//            String sqlQuery = "INSERT INTO students(name, surname, avg_grade) VALUES" +
//                    "('" +
//                    student.getName() +
//                    "', '" +
//                    student.getSurname() +
//                    " '," +
//                    student.getAvgGrade() +
//                    ")";
            String sqlQuery = "INSERT INTO students(name, surname, avg_grade)" +
                    "VALUES ('Julia', 'Dean', 8.7)";

            statement.executeUpdate(sqlQuery);
            statement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
