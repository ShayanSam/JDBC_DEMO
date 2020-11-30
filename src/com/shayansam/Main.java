package com.shayansam;

import models.Student;
import models.Teacher;
import services.University;

public class Main {

    public static void main(String[] args) {
        University university = new University();

        university.showStudents();
        university.showTeachers();
        university.showStudentTeacher();
        university.showStudentsForSpecificTeacher(55);






    }
}
