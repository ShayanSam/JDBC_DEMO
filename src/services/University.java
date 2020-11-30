package services;

import models.Student;
import models.StudentTeacher;
import models.Teacher;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static models.Student.printStudents;
import static models.StudentTeacher.printStudentTeacher;
import static models.Teacher.printTeachers;


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

    public void deleteStudent(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("DELETE FROM student_teacher WHERE student_id = ?")) {
            PreparedStatement preparedStatement1 = connection.prepareStatement
                    ("DELETE FROM student WHERE id = ?");
           preparedStatement.setInt(1,id);
           preparedStatement.executeUpdate();
           preparedStatement1.setInt(1,id);
           preparedStatement1.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void deleteTeacher(int id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("DELETE FROM student_teacher WHERE teacher_id = ?")) {
            PreparedStatement preparedStatement1 = connection.prepareStatement
                    ("DELETE FROM teacher WHERE id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement1.setInt(1,id);
            preparedStatement1.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void showStudentsForSpecificTeacher(int id){
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT *\n" +
                             "FROM student WHERE id IN(\n" +
                             "SELECT student_id \n" +
                             "FROM student_teacher WHERE teacher_id = ?)")) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            printStudents(resultSet);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }


    }

    public void showStudents() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT * FROM student");
             ResultSet resultSet = preparedStatement.executeQuery()) {
             printStudents(resultSet);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void showTeachers() {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT * FROM teacher");
             ResultSet resultSet = preparedStatement.executeQuery()) {
             printTeachers(resultSet);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void showStudentTeacher(){
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     ("SELECT * FROM student_teacher");
             ResultSet resultSet = preparedStatement.executeQuery()) {
             printStudentTeacher(resultSet);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }


    }






}



