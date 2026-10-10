package com.practice.learntrack.service;

import com.practice.learntrack.entity.Student;
import com.practice.learntrack.exception.StudentNotFoundException;
import com.practice.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    private Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(int id) {
        students.remove(id);
    }

    public void updateStudent(int id, Student student) {
        students.put(id, student);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void viewAllStudents() {
        List<Student> studentList = new ArrayList<>(students.values());
        for (Student student : studentList) {
            displayStudent(student);
        }

    }

    public void displayStudent(Student student) {
        System.out.println("ID: " + student.getId()
                + "\nName: " + student.getFirstName() + " " + student.getLastName()
                + "\nBatch: " + student.getBatch()
                + "\nActive: " + student.isActive()
                + "\n-----------------------------");
    }

    public void deactivateStudent(int id){
        try {
                Student student = students.get(id);
                if (student == null) {
                    throw new StudentNotFoundException("Student not found with ID: " + id);
                }
            student.setActive(false);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
