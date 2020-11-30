package com.shayansam;

import models.Student;
import models.Teacher;
import services.University;

public class Main {

    public static void main(String[] args) {
        University university = new University();
        Student student = new Student("Tom","Petty");


//        university.addNewStudent(student);
        university.alterStudent(3,student);
        university.showStudents();
    }
}
