package services;

import models.Student;
import models.StudentTeacher;
import models.Teacher;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class University {

    public void addNewStudent(Student student) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO student(student_first_name, student_last_name ) VALUES (?,?)");) {
            preparedStatement.setString(1, student.getStudentFirstName());
            preparedStatement.setString(2, student.getStudentLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void addNewTeacher(Teacher teacher) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO teacher(teacher_first_name, teacher_last_name) VALUES (?,?)")) {
            preparedStatement.setString(1, teacher.getTeacherFirstName());
            preparedStatement.setString(2, teacher.getTeacherLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void addToStudentTeacher(StudentTeacher studentTeacher) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("INSERT INTO student_teacher(teacher_id, student_id) VALUES (?,?)")) {
            preparedStatement.setInt(1,studentTeacher.getTeacherId());
            preparedStatement.setInt(2, studentTeacher.getStudentId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void alterStudent(int id, Student student) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("UPDATE student SET student_first_name = ? , student_last_name = ? WHERE id = ?")) {
            preparedStatement.setString(1,student.getStudentFirstName());
            preparedStatement.setString(2,student.getStudentLastName());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void alterTeacher(int id, Teacher teacher) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("UPDATE teacher SET teacher_first_name = ? , teacher_last_name = ? WHERE id = ?")) {
            preparedStatement.setString(1,teacher.getTeacherLastName());
            preparedStatement.setString(2,teacher.getTeacherLastName());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void showStudents() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from student");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.print("student ID: " + resultSet.getString("id"));
                System.out.print("\t\t\t");
                System.out.print("student first name: " + resultSet.getString("student_first_name"));
                System.out.print("\t\t\t");
                System.out.print("student last name: " + resultSet.getString("student_last_name"));
                System.out.print("\t\t\t");
                System.out.println();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void showTeachers() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("select * from teacher");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.print("teacher ID: " + resultSet.getString("id"));
                System.out.print("\t\t\t");
                System.out.print("teacher first name: " + resultSet.getString("teacher_first_name"));
                System.out.print("\t\t\t");
                System.out.print("teacher last name: " + resultSet.getString("teacher_last_name"));
                System.out.print("\t\t\t");
                System.out.println();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }





}



