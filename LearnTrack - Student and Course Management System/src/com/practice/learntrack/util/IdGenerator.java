package com.practice.learntrack.util;

public class IdGenerator {

    private static int studentIdCounter;
    private static int courseIdCounter;
    private static int enrollmentIdCounter;

    public static int getNextStudentId() {
        return ++studentIdCounter;
    }

    public static int getNextCourseId() {
        return ++courseIdCounter;
    }

    public static int getNextEnrollmentId() {
        return ++enrollmentIdCounter;
    }
}
