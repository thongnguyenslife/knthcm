package oop.service;

import oop.model.Student;
import oop.repository.StudentRepository;
import java.util.*;

// Lớp nghiệp vụ (không nhập/xuất, chỉ xử lý)
public class StudentService {
    private final StudentRepository repo;
    private int nextId = 1;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student add(String name, int age, double gpa, char grade, boolean graduated) {
        Student s = new Student(nextId++, name, age, gpa, grade, graduated);
        repo.save(s);
        return s;
    }

    public List<Student> listAll() {
        return repo.findAll();
    }

    public Optional<Student> findById(int id) {
        return repo.findById(id);
    }

    public boolean delete(int id) {
        return repo.deleteById(id);
    }

    public List<Student> searchByName(String key) {
        return repo.findByNameContains(key);
    }

    // Ba cách sắp xếp phổ biến (để dễ nhớ và gọi từ menu)
    public List<Student> sortByGpaDescThenName() {
        List<Student> list = repo.findAll();
        list.sort(Comparator.comparingDouble(Student::getGpa).reversed()
                .thenComparing(s -> s.getFullName().toLowerCase()));
        return list;
    }

    public List<Student> sortByNameAsc() {
        List<Student> list = repo.findAll();
        list.sort(Comparator.comparing(s -> s.getFullName().toLowerCase()));
        return list;
    }

    public List<Student> sortByAgeAscThenName() {
        List<Student> list = repo.findAll();
        list.sort(Comparator.comparingInt(Student::getAge)
                .thenComparing(s -> s.getFullName().toLowerCase()));
        return list;
    }

    // Cập nhật linh hoạt: truyền null để giữ nguyên
    public boolean update(int id, String name, Integer age, Double gpa, Character grade, Boolean graduated) {
        Optional<Student> opt = repo.findById(id);
        if (opt.isEmpty())
            return false;
        Student s = opt.get();
        if (name != null && !name.trim().isEmpty())
            s.setFullName(name);
        if (age != null)
            s.setAge(age);
        if (gpa != null)
            s.setGpa(gpa);
        if (grade != null)
            s.setGrade(grade);
        if (graduated != null)
            s.setGraduated(graduated);
        repo.save(s);
        return true;
    }

    public void seedDemo() {
        repo.clear();
        nextId = 1;
        add("Nguyễn Minh Anh", 20, 8.4, 'A', true);
        add("Trần Thảo Vy", 19, 7.2, 'B', false);
        add("Lê Quốc Huy", 21, 9.1, 'A', true);
        add("Phạm Nhật Minh", 18, 6.5, 'C', false);
        add("Đỗ Thanh Huyền", 22, 5.8, 'D', false);
        add("Hoàng Đức Anh", 20, 8.9, 'A', true);
        add("Bùi Lan Chi", 23, 7.7, 'B', true);
        add("Vũ Minh Quân", 19, 9.5, 'A', true);
        add("Phan Ngọc Mai", 18, 6.0, 'C', false);
        add("Trương Gia Khánh", 21, 7.9, 'B', true);
        add("Ngô Hải Yến", 20, 8.1, 'A', true);
        add("Tạ Minh Khoa", 22, 5.5, 'D', false);
        add("Nguyễn Hoàng Long", 19, 7.4, 'B', false);
        add("Lý Thu Hằng", 20, 8.3, 'A', true);
        add("Huỳnh Nhật Tân", 21, 6.8, 'C', false);
        add("Đinh Thanh Tú", 18, 9.0, 'A', true);
        add("Mai Anh Thư", 22, 7.6, 'B', true);
        add("Trần Bảo Ngọc", 19, 5.9, 'D', false);
        add("Nguyễn Khánh Linh", 20, 8.7, 'A', true);
        add("Phạm Thanh Phong", 21, 6.3, 'C', false);
        add("Đoàn Quỳnh Chi", 18, 9.2, 'A', true);
        add("Võ Nhật Nam", 22, 7.0, 'B', true);
        add("Nguyễn Thanh Hòa", 19, 5.7, 'D', false);
        add("Lê Bảo Trâm", 20, 8.0, 'A', true);
        add("Trần Tuấn Kiệt", 21, 7.5, 'B', true);
        add("Ngô Phương Thảo", 18, 6.6, 'C', false);
        add("Bùi Gia Hưng", 22, 8.8, 'A', true);
        add("Phan Thu Hà", 19, 6.2, 'C', false);
        add("Hoàng Anh Dũng", 20, 9.4, 'A', true);
        add("Đỗ Minh Châu", 21, 7.1, 'B', false);
    }
}