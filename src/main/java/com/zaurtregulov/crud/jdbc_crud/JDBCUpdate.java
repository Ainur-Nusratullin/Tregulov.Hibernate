package com.zaurtregulov.crud.jdbc_crud;

import com.zaurtregulov.crud.entity.Student;

import java.sql.*;
import java.util.Scanner;

public class JDBCUpdate {

    static final String DB_URl = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {

        Student student = new Student("Leo", "Farrel", 8.4);

        try (Connection connection = DriverManager.getConnection(DB_URl, USER, PWD)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name:");
            String enteredName = scanner.nextLine();

//            Statement statement = connection.createStatement();
//            String sqlQuery = "UPDATE students SET avg_grade = 7.5" +
//                    "WHERE name = '" + enteredName + "'";
//            statement.executeUpdate(sqlQuery);
//
//            statement.close();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET avg_grade = 7.5 WHERE name = ?");
            statement.setString(1, enteredName);
            statement.executeUpdate();

            statement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
