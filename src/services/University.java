package services;

import models.Student;
import models.StudentTeacher;
import models.Teacher;
import sun.security.mscapi.CPublicKey;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class University {


    public void addNewStudent(Student student){
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO student(student_first_name, student_last_name ) VALUES (?, ?)");){
            preparedStatement.setString(1,student.getStudentFirstName());
            preparedStatement.setString(2,student.getStudentLastName());
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public void addTeacherStudent(Teacher teacher){
        try(Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO teacher(teacher_first_name, teacher_last_name) VALUES (?, ?)");){
            preparedStatement.setString(1,teacher.getTeacherFirstName());
            preparedStatement.setString(2,teacher.getTeacherLastName());
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }


}
