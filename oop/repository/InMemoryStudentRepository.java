package oop.repository;

import oop.model.Student;
import java.util.*;
import java.util.stream.Collectors;

// Hien thuc luu tru bang bo nho Map
public class InMemoryStudentRepository implements StudentRepository {
    private final Map<Integer, Student> data = new LinkedHashMap<>();

    @Override
    public Student save(Student s) {
        data.put(s.getId(), s);
        return s;
    }

    @Override
    public Optional<Student> findById(int id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public boolean deleteById(int id) {
        return data.remove(id) != null;
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public List<Student> findByNameContains(String key) {
        String k = key == null ? "" : key.trim().toLowerCase();
        if (k.isEmpty())
            return Collections.emptyList();
        return data.values().stream()
                .filter(s -> s.getFullName().toLowerCase().contains(k))
                .collect(Collectors.toList());
    }
}