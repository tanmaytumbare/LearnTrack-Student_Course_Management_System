package com.practice.learntrack.entity;


import com.practice.learntrack.util.IdGenerator;

public class Student extends Person {

    private String batch;
    private boolean active;

    public Student(String firstName, String lastName, String email, String batch, boolean active) {
        super(IdGenerator.getNextStudentId(), firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void getDisplayName() {
        System.out.println("Name of student: " +super.getFirstName() + " " + super.getLastName());
    }

    public String getBatch() {
        return batch;
    }
}
