package com.example.schoolmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolmanager.model.Student;
import com.example.schoolmanager.respository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // ADD
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // DELETE
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    // SEARCH
    public List<Student> findByName(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    // GET ALL
    public List<Student> getAll(){
        return repository.findAll();
    }

    // GET BY ID
    public Student getStudentById(int id){
        return repository.findById(id).orElse(null);
    }

    // UPDATE
    public Student updateStudent(int id, Student student) {
        Student existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            return repository.save(existing);
        }

        return null;
    }
}
