package org.example.spring_exercice3.service;

import lombok.Getter;
import org.example.spring_exercice3.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class StudentService {
    private int idCounter;
    private List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        students.add(Student.builder().id(1).firstName("toto").lastName("dupuis").age(25).email("totodupuis@gmail.com").build());
        students.add(Student.builder().id(2).firstName("tata").lastName("dupuis").age(34).email("tatadupuis@gmail.com").build());
        idCounter = students.size();
    }

    public void addStudent(Student student) {
        student.setId(++idCounter);
        students.add(student);
    }

    public List<Student> getStudentsByName(String name) {
        return students.stream().filter(s -> s.getLastName().equalsIgnoreCase(name) || s.getFirstName().equalsIgnoreCase(name)).toList();
    }

    public Student getStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public void updateStudent(Student student) {
        Student studentToUpdate = getStudentById(student.getId());
        int index = students.indexOf(studentToUpdate);
        students.set(index, student);
    }

    public void deleteStudentById(int id) {
        Student studentToDelete = getStudentById(id);
        students.remove(studentToDelete);
    }
}
