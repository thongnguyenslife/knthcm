package oop.service;

import oop.model.Student;
import oop.repository.StudentRepository;
import java.util.*;

// Lop nghiep vu (khong nhap/xuat, chi xu ly)
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

    // Ba cach sap xep pho bien (de de nho va goi tu menu)
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

    // Cap nhat linh hoat: truyen null de giu nguyen
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
        add("Nguyen Minh Anh", 20, 8.4, 'A', true);
        add("Tran Thao Vy", 19, 7.2, 'B', false);
        add("Le Quoc Huy", 21, 9.1, 'A', true);
        add("Pham Nhat Minh", 18, 6.5, 'C', false);
        add("Do Thanh Huyen", 22, 5.8, 'D', false);
        add("Hoang Duc Anh", 20, 8.9, 'A', true);
        add("Bui Lan Chi", 23, 7.7, 'B', true);
        add("Vu Minh Quan", 19, 9.5, 'A', true);
        add("Phan Ngoc Mai", 18, 6.0, 'C', false);
        add("Truong Gia Khanh", 21, 7.9, 'B', true);
        add("Ngo Hai Yen", 20, 8.1, 'A', true);
        add("Ta Minh Khoa", 22, 5.5, 'D', false);
        add("Nguyen Hoang Long", 19, 7.4, 'B', false);
        add("Ly Thu Hang", 20, 8.3, 'A', true);
        add("Huynh Nhat Tan", 21, 6.8, 'C', false);
        add("Dinh Thanh Tu", 18, 9.0, 'A', true);
        add("Mai Anh Thu", 22, 7.6, 'B', true);
        add("Tran Bao Ngoc", 19, 5.9, 'D', false);
        add("Nguyen Khanh Linh", 20, 8.7, 'A', true);
        add("Pham Thanh Phong", 21, 6.3, 'C', false);
        add("Doan Quynh Chi", 18, 9.2, 'A', true);
        add("Vo Nhat Nam", 22, 7.0, 'B', true);
        add("Nguyen Thanh Hoa", 19, 5.7, 'D', false);
        add("Le Bao Tram", 20, 8.0, 'A', true);
        add("Tran Tuan Kiet", 21, 7.5, 'B', true);
        add("Ngo Phuong Thao", 18, 6.6, 'C', false);
        add("Bui Gia Hung", 22, 8.8, 'A', true);
        add("Phan Thu Ha", 19, 6.2, 'C', false);
        add("Hoang Anh Dung", 20, 9.4, 'A', true);
        add("Do Minh Chau", 21, 7.1, 'B', false);
    }
}
