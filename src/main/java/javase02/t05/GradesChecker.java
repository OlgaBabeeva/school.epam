package javase02.t05;

import java.util.ArrayList;
import java.util.List;

public class GradesChecker {

    public static void main(String[] args) {

        //create students
        Student annStudent = new Student("Ann");
        Student billyStudent = new Student("Billy");
        Student cristineStudent = new Student("Christine");

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(annStudent);
        allStudents.add(billyStudent);
        allStudents.add(cristineStudent);

        //create groups and add students to the groups

        Group philosophyGroup = new Group(Course.PHILOSOPHY);
        philosophyGroup.addStudent(allStudents);

        Group chemistryGroup101 = new Group(Course.CHEMISTRY, "101");
        chemistryGroup101.addStudent(allStudents);

        Group historyGroup101 = new Group(Course.HISTORY, "101");
        historyGroup101.addStudent(billyStudent);
        historyGroup101.addStudent(cristineStudent);

        Group historyGroup201 = new Group(Course.HISTORY, "201");
        historyGroup201.addStudent(annStudent);

        //generate random grades
        annStudent.createStudentGrades();
        billyStudent.createStudentGrades();
        cristineStudent.createStudentGrades();

        compareGrades(annStudent);
        compareGrades(billyStudent);
        compareGrades(cristineStudent);

    }


    public static void compareGrades(Student student) {

        List<Group> studentGroups = student.getGroupList();

        System.out.println("Checking " + student.getName() + "'s grades...");

        for (Group group : studentGroups) {
            System.out.println(group.getCourse() + " " + group.getId());

            for (Student s : group.getGroupStudents()) {
                s.printCourseGrades(group.getCourse());
            }
        }

    }
}
