package oop.model;

// Lớp trừu tượng: khuôn chung cho người
public abstract class Person {
    private String fullName; // Đóng gói
    private int age;         // Đóng gói

    protected Person(String fullName, int age) {
        setFullName(fullName);
        setAge(age);
    }

    public String getFullName() { return fullName; }
    public final void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty())
            throw new IllegalArgumentException("Họ tên không được rỗng");
        this.fullName = fullName.trim();
    }

    public int getAge() { return age; }
    public final void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Tuổi phải > 0");
        this.age = age;
    }

    // Ví dụ trừu tượng/đa hình (không bắt buộc dùng trong menu)
    public abstract String introduce();
}