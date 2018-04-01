package ge.edu.ibsu.mobile.berdia.labwork6.models;

/**
 * Created by rogel on 4/1/2018.
 */

public class Course {

    private String name;
    private int grade;

    public Course() {

    }

    public Course(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
