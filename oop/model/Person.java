package oop.model;

// Lop truu tuong: khuon chung cho nguoi
public abstract class Person {
    private String fullName; // Dong goi
    private int age; // Dong goi

    protected Person(String fullName, int age) {
        setFullName(fullName);
        setAge(age);
    }

    public String getFullName() {
        return fullName;
    }

    public final void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty())
            throw new IllegalArgumentException("Ho ten khong duoc rong");
        this.fullName = fullName.trim();
    }

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        if (age <= 0)
            throw new IllegalArgumentException("Tuoi phai > 0");
        this.age = age;
    }

    // Vi du truu tuong/da hinh (khong bat buoc dung trong menu)
    public abstract String introduce();
}
