package com.practice.learntrack.entity;


public class Trainer extends Person {

    private String batch;
    private int experience;

    public Trainer(int id, String firstName, String lastName, String email, String batch, int experience) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.experience = experience;
    }

    @Override
    public void getDisplayName() {
        System.out.println("Name of trainer: " +super.getFirstName() + " " + super.getLastName());
    }
}
