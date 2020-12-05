package com.shayansam;

import models.Student;
import models.StudentTeacher;
import services.University;

public class Main {

    public static void main(String[] args) {
        University university = new University();

        university.deleteTeacher(55);
        university.showStudentTeacher();
        university.showTeachers();
        university.showStudents();






    }
}
