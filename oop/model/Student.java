package oop.model;

import java.util.Objects;

public class Student extends Person {  // Kế thừa
    private final int id;     // Đóng gói
    private double gpa;       // [0..10]
    private char grade;       // A/B/C/...
    private boolean graduated;

    public Student(int id, String fullName, int age, double gpa, char grade, boolean graduated) {
        super(fullName, age);
        if (id <= 0) throw new IllegalArgumentException("ID phải > 0");
        this.id = id;
        setGpa(gpa);
        setGrade(grade);
        setGraduated(graduated);
    }

    public int getId() { return id; }
    public double getGpa() { return gpa; }
    public final void setGpa(double gpa) {
        if (gpa < 0 || gpa > 10) throw new IllegalArgumentException("GPA phải trong [0..10]");
        this.gpa = gpa;
    }
    public char getGrade() { return grade; }
    public final void setGrade(char grade) {
        if (!Character.isLetter(grade)) throw new IllegalArgumentException("Grade phải là chữ cái");
        this.grade = Character.toUpperCase(grade);
    }
    public boolean isGraduated() { return graduated; }
    public final void setGraduated(boolean graduated) { this.graduated = graduated; }

    public String graduatedText() { return graduated ? "Đã tốt nghiệp" : "Chưa tốt nghiệp"; }

    @Override
    public String introduce() { // Đa hình: mỗi lớp con giới thiệu khác nhau
        return "Tôi là sinh viên " + getFullName() + ", " + getAge() + " tuổi, GPA " + gpa;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }
    @Override public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("%-4d | %-24s | %3d | %5.2f | %c | %-13s",
                id, getFullName(), getAge(), gpa, grade, graduatedText());
    }
}