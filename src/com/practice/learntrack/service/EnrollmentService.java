package com.practice.learntrack.service;

import com.practice.learntrack.entity.Enrollment;

import java.util.HashMap;
import java.util.Map;

public class EnrollmentService {

    Map<Integer, Enrollment> enrollments = new HashMap<>();

    public void enrolStudent(Enrollment enrollment) {
        enrollments.put(enrollment.getId(), enrollment);
    }

    public void displayEnrollment(Enrollment enrollment){
        System.out.println("Enrollment ID: " + enrollment.getId()
                + " \nStudent ID: " + enrollment.getStudentId()
                + " \nCourse ID: " + enrollment.getCourseId()
                + " \nEnrollment Date: " + enrollment.getEnrollmentDate()
                + " \nStatus: " + enrollment.getStatus()
                + " \n----------------------------");
    }

    public void viewEnrollmentsForStudent(int studentId) {
        for (Enrollment enrollment : enrollments.values()) {
            if (enrollment.getStudentId() == studentId) {
                displayEnrollment(enrollment);
            }
        }
    }
    public void markEnrollment(int id) {
        try {
            Enrollment enrollment = enrollments.get(id);
            if (enrollment == null) {
                throw new Exception("Enrollment not found with ID: " + id);
            }
            enrollment.setStatus(Enrollment.EnrollmentStatus.COMPLETED);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
