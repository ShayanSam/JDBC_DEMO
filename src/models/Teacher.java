package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Teacher {

    private String teacherFirstName;
    private String teacherLastName;
    private int teacherId;

    public Teacher(String teacherFirstName, String teacherLastName) {
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;

    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public static void printTeachers(ResultSet resultSet) throws SQLException {
        System.out.println("********************************************************************************************************");
        while (resultSet.next()) {
            System.out.print("teacher ID: " + resultSet.getString("id"));
            System.out.print("\t\t\t");
            System.out.print("teacher first name: " + resultSet.getString("teacher_first_name"));
            System.out.print("\t\t\t");
            System.out.print("teacher last name: " + resultSet.getString("teacher_last_name"));
            System.out.print("\t\t\t");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }


}
