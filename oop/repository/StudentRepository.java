package oop.repository;

import oop.model.Student;
import java.util.*;

// Interface (truu tuong): hop dong thao tac du lieu
public interface StudentRepository {
    Student save(Student s); // tao moi / cap nhat

    Optional<Student> findById(int id);

    List<Student> findAll();

    boolean deleteById(int id);

    List<Student> findByNameContains(String key);

    void clear();
}