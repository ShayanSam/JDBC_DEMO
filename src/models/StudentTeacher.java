package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentTeacher {

    private int teacherId;
    private  int studentId;

    public StudentTeacher(int teacherId, int studentId) {
        this.teacherId = teacherId;
        this.studentId = studentId;
    }


    public int getTeacherId() {
        return teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public static void printStudentTeacher(ResultSet resultSet) throws SQLException {
        System.out.println("********************************************************************************************************");
        while (resultSet.next()) {
            System.out.print("ST ID: " + resultSet.getString("st_id"));
            System.out.print("\t\t\t");
            System.out.print("teacher ID: " + resultSet.getString("teacher_id"));
            System.out.print("\t\t\t");
            System.out.print("student ID: " + resultSet.getString("student_id"));
            System.out.print("\t\t\t");
            System.out.println();
        }
    }


    @Override
    public String toString() {
        return "StudentTeacher{" +
                "teacherId=" + teacherId +
                ", studentId=" + studentId +
                '}';
    }
}


