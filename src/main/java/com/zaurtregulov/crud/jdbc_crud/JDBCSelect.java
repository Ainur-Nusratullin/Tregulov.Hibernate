package com.zaurtregulov.crud.jdbc_crud;

import com.zaurtregulov.crud.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCSelect {

    static final String DB_URl = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {


        try (Connection connection = DriverManager.getConnection(DB_URl, USER, PWD)) {

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM students WHERE avg_grade > ?"
            );
            statement.setDouble(1, 9.0);
            ResultSet resultSet = statement.executeQuery();

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAvgGrade(resultSet.getDouble("avg_grade"));
                students.add(student);
            }

            System.out.println(students);
            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
