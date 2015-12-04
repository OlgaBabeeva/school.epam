package javase02.t05;

import java.util.*;

public class Student {

    //for generating grades
    private static Random random = new Random();

    //for unique student id
    private static int count = 0;

    private static final int NUMBER_OF_GRADES_PER_COURSE = 5;

    private String name;
    private int id;
    private Map<Course, List<Number>> courseList = new HashMap<>();
    private List<Group> groupList = new ArrayList<>();

    public Student(String name) {
        this.name = name;
        this.id = ++count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getName() {
        return name;
    }

    public Map<Course, List<Number>> getCourseList() {
        return courseList;
    }

    public void printCourseGrades(Course course) {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(" ").append(name).append(":");
        for (Number grade : courseList.get(course)) {
            sb.append(" ");
            sb.append(grade);
        }
        System.out.println(sb);
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void addGroup(Group group) {
        groupList.add(group);
        courseList.put(group.getCourse(), new ArrayList<>());
    }

    public void createStudentGrades() {
        for (Course course : courseList.keySet()) {
            this.courseList.put(course, generatePassingGrades(course));
        }
    }

    public static List<Number> generatePassingGrades(Course course) {
        List<Number> numberList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_GRADES_PER_COURSE; i++) {
            numberList.add(randomGrade(course));
        }
        return numberList;
    }

    public static Number randomGrade(Course course) {
        return course.isGradeInteger() ? Student.randomIntegerGrade() : randomDoubleGrade();
    }

    public static Number randomGrade(Course course, int min, int max) {
        return course.isGradeInteger() ? Student.randomIntegerGrade(min, max) : randomDoubleGrade(min, max);
    }

    public static int randomIntegerGrade(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int randomIntegerGrade() {
        return randomIntegerGrade(60, 100);
    }

    public static double randomDoubleGrade(int min, int max) {
        //ugly realization for good looking double grade
        return (randomIntegerGrade(min * 100, max * 100) / 10.0);
    }

    public static double randomDoubleGrade() {
        return randomDoubleGrade(60, 100);
    }


}
