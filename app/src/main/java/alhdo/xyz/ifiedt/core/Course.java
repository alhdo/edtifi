package alhdo.xyz.ifiedt.core;

public class Course {
    String ID;
    String name;
    int hours;
    String plan;
    int number;
    String teacherName;



    public Course(String ID, String name, int hours) {
        this.ID = ID;
        this.name = name;
        this.hours = hours;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", plan='" + plan + '\'' +
                ", number=" + number +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
