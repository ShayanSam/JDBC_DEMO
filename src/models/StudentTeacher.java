package models;

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

    @Override
    public String toString() {
        return "StudentTeacher{" +
                "teacherId=" + teacherId +
                ", studentId=" + studentId +
                '}';
    }
}


