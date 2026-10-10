package com.practice.learntrack.ui;

import com.practice.learntrack.entity.Course;
import com.practice.learntrack.entity.Enrollment;
import com.practice.learntrack.entity.Student;
import com.practice.learntrack.exception.CourseNotFoundException;
import com.practice.learntrack.exception.StudentNotFoundException;
import com.practice.learntrack.service.CourseService;
import com.practice.learntrack.service.EnrollmentService;
import com.practice.learntrack.service.StudentService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void displayMainMenu() {
        System.out.println(
                "1) Student Management\n" +
                "2) Course Management\n" +
                "3) Enrollment Management\n" +
                        "4) Exit\n" +
                "Please provide your choice (1-4): ");
    }

    private static void displayStudentMenu() {
        System.out.println(
                "1) Add new student\n" +
                        "2) View all students\n" +
                        "3) Search student by ID\n" +
                        "4) Deactivate a student\n " +
                        "Please enter your choice (1-4): ");
    }

    private static void callStudentServices(int innerChoice, StudentService studentService, Scanner sc)
            throws StudentNotFoundException {
        switch (innerChoice) {
            case 1:
                System.out.println("Enter student first name: ");
                String firstName = sc.next();
                System.out.println("Enter student last name: ");
                String lastName = sc.next();
                System.out.println("Enter student email: ");
                String email = sc.next();
                System.out.println("Enter student batch: ");
                String batch = sc.next();
                boolean active = true; // Assuming new students are active by default
                studentService.addStudent(new Student(firstName, lastName, email, batch, active));
                System.out.println("Student added successfully.\n");
                break;
            case 2:
                System.out.println("\nAll students:\n");
                studentService.viewAllStudents();
                break;
            case 3:
                System.out.println("Enter student ID to search: ");
                int searchId = sc.nextInt();
                try{
                    Student student = studentService.getStudentById(searchId);
                    if(student == null) {
                        throw new StudentNotFoundException("" + searchId);
                    }
                    studentService.displayStudent(student);
                } catch (StudentNotFoundException e) {
                    System.out.println("Student not found: " + e.getMessage());
                }
                break;
            case 4:
                System.out.println("Enter student ID to deactivate: ");
                int deactivateId = sc.nextInt();
                    studentService.deactivateStudent(deactivateId);
                    System.out.println("Student deactivated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    private static void displayCourseMenu() {
        System.out.println(
                "1) Add new course\n" +
                        "2) View all courses\n" +
                        "3) Activate/Deactivate a course\n" +
                        "Please enter your choice (1-3): ");
    }
    private static void callCourseServices(int innerChoice, CourseService courseService, Scanner sc)
            throws CourseNotFoundException {
        switch (innerChoice) {
            case 1:
                System.out.println("Enter course name: ");
                String courseName = sc.next();
                System.out.println("Enter course description: ");
                String description = sc.next();
                System.out.println("Enter course duration in weeks: ");
                int durationInWeeks = sc.nextInt();
                boolean active = true; // Assuming new courses are active by default
                courseService.addCourse(new Course(courseName, description, durationInWeeks, active));
                System.out.println("Course added successfully.\n");
                break;
            case 2:
                System.out.println("\nAll courses:\n");
                courseService.listCourses();
                break;
            case 3:
                System.out.println("Enter course ID to activate/deactivate: ");
                int courseId = sc.nextInt();
                courseService.deactivateCourse(courseId);
                System.out.println("Course deactivated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    private static void displayEnrollmentMenu() {
        System.out.println(
                "1) Enroll a student in a course\n" +
                        "2) View enrollments for a student\n" +
                        "3) Mark enrollment as completed/cancelled\n" +
                        "Please enter your choice (1-3): ");
    }

    private static void callEnrollmentServices(int innerChoice, EnrollmentService enrollmentService, Scanner sc) {
        switch (innerChoice) {
            case 1:
                System.out.println("Enter student ID to enroll: ");
                int studentId = sc.nextInt();
                System.out.println("Enter course ID to enroll in: ");
                int courseId = sc.nextInt();
                enrollmentService.enrolStudent(new Enrollment(studentId, courseId, Enrollment.EnrollmentStatus.ACTIVE));
                System.out.println("Student enrolled successfully.\n");
                break;
            case 2:
                System.out.println("Enter student ID to view enrollments: ");
                int viewStudentId = sc.nextInt();
                enrollmentService.viewEnrollmentsForStudent(viewStudentId);
                break;
            case 3:
                System.out.println("Enter enrollment ID to mark as completed/cancelled: ");
                int enrollmentId = sc.nextInt();
                enrollmentService.markEnrollment(enrollmentId);
                System.out.println("Enrollment status updated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

    }

    public static void main(String[] args) throws StudentNotFoundException {
        System.out.println("\n---*** Welcome to LearnTrack ***---");

        Scanner sc = new Scanner(System.in);
        int choice = 0, innerChoice = 0;
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        do {
            displayMainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayStudentMenu();
                    innerChoice = sc.nextInt();
                    callStudentServices(innerChoice, studentService, sc);
                    break;
                case 2:
                    displayCourseMenu();
                    innerChoice = sc.nextInt();
                    callCourseServices(innerChoice, courseService, sc);
                    break;
                case 3:
                    displayEnrollmentMenu();
                    innerChoice = sc.nextInt();
                    callEnrollmentServices(innerChoice, enrollmentService, sc);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);
    }
}