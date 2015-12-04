package javase02.t05;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private Course course;
    private String id;
    private List<Student> groupStudents = new ArrayList<>();

    public Group(Course course, String id) {
        this.course = course;
        this.id = id;
    }

    public Group(Course course) {
        this(course, "000");
    }

    public Course getCourse() {
        return course;
    }

    public String getId() {
        return id;
    }

    public List<Student> getGroupStudents() {
        return groupStudents;
    }

    public void addStudent(Student student) {
        groupStudents.add(student);
        student.addGroup(this);
    }

    public void addStudent(List<Student> studentList) {
        for (Student student : studentList) {
            this.addStudent(student);
        }
    }

}
