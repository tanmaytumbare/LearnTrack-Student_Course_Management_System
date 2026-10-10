package com.practice.learntrack.service;

import com.practice.learntrack.entity.Course;
import com.practice.learntrack.exception.CourseNotFoundException;
import com.practice.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseService {
    private Map<Integer, Course> courses = new HashMap<>();

    public void addCourse(Course course) {
        courses.put(IdGenerator.getNextCourseId(), course);
    }

    public void removeCourse(int id) {
        courses.remove(id);
    }

    public void updateCourse(int id, Course course) {
        courses.put(id, course);
    }

    public void getCourseById(int id) {
        try {
            Course course = courses.get(id);
            if (course == null) {
                throw new CourseNotFoundException("Course not found with ID: " + id);
            }
            displayCourse(course);
        } catch (CourseNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public void displayCourse(Course course) {
        System.out.println("ID: " + course.getId()
                + " \nName: " + course.getCourseName()
                + " \nDescription: " + course.getDescription()
                + " \nDuration: " + course.getDurationInWeeks() + " weeks"
                + " \nActive: " + course.isActive()
                + " \n----------------------------");
    }

    public void listCourses() {
        for(Course course : courses.values()) {;
            displayCourse(course);
        }
    }

    public void deactivateCourse(int id) {
        try {
            Course course = courses.get(id);
            if (course == null) {
                throw new Exception("Course not found with ID: " + id);
            }
            course.setActive(false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
