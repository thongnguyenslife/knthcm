package oop.repository;

import oop.model.Student;
import java.util.*;

// Interface (trừu tượng): hợp đồng thao tác dữ liệu
public interface StudentRepository {
    Student save(Student s);                 // tạo mới / cập nhật
    Optional<Student> findById(int id);
    List<Student> findAll();
    boolean deleteById(int id);
    List<Student> findByNameContains(String key);
    void clear();
}