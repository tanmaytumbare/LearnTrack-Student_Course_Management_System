package com.practice.learntrack.entity;

import com.practice.learntrack.util.IdGenerator;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private String enrollmentDate;
    private EnrollmentStatus status;

    public static enum EnrollmentStatus { ACTIVE, COMPLETED, DROPPED }

    public Enrollment(int studentId, int courseId, EnrollmentStatus status) {
        this.id = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = "today"; // Placeholder for actual date logic
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
}
