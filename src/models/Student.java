package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

    private  String studentFirstName;
    private  String studentLastName;
    private  int studentId;

    public Student(String studentFirstName, String studentLastName) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;

    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public static void printStudents(ResultSet resultSet) throws SQLException {
        System.out.println("********************************************************************************************************");
        while (resultSet.next()) {
            System.out.print("student ID: " + resultSet.getString("id"));
            System.out.print("\t\t\t");
            System.out.print("student first name: " + resultSet.getString("student_first_name"));
            System.out.print("\t\t\t");
            System.out.print("student last name: " + resultSet.getString("student_last_name"));
            System.out.print("\t\t\t");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
