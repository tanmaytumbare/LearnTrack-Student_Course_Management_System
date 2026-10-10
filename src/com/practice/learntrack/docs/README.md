# LearnTrack

LearnTrack is a console-based student, course, and enrollment management system written in Core Java.

## Features

The console menus currently support:

- Adding, listing, searching, and deactivating students
- Adding, listing, and deactivating courses
- Creating enrollments and viewing enrollments for a student
- Marking an enrollment as completed

All data is stored in memory. Students, courses, enrollments, and generated IDs are lost when the application exits.

## Project structure

- `src/com/practice/learntrack/entity`: domain models such as `Student`, `Course`, `Enrollment`, `Person`, and `Trainer`
- `src/com/practice/learntrack/service`: in-memory services for students, courses, and enrollments
- `src/com/practice/learntrack/ui/Main.java`: console entry point and menu flow
- `src/com/practice/learntrack/util/IdGenerator.java`: shared in-memory ID counters
- `src/com/practice/learntrack/exception`: application-specific exceptions

## How to compile and run
Use compatible JDK and compile from the project root (com.practice.learntrack.ui.Main.java).

## Class diagram

```mermaid
classDiagram
    class Person {
        -int id
        -String firstName
        -String lastName
        -String email
    }

    class Student {
        -String batch
        -boolean active
    }

    class Trainer {
        -String batch
        -int experience
    }

    class Course {
        -int id
        -String courseName
        -String description
        -int durationInWeeks
        -boolean active
    }

    class Enrollment {
        -int id
        -int studentId
        -int courseId
        -EnrollmentStatus status
    }

    class EnrollmentStatus {
        ACTIVE
        COMPLETED
        DROPPED
    }

    class StudentService {
        Manages students
    }

    class CourseService {
        Manages courses
    }

    class EnrollmentService {
        Manages enrollments
    }

    Person <|-- Student
    Person <|-- Trainer
    Student "1" --> "0..*" Enrollment : has
    Course "1" --> "0..*" Enrollment : includes
    Enrollment --> EnrollmentStatus : has status
    StudentService --> Student : manages
    CourseService --> Course : manages
    EnrollmentService --> Enrollment : manages
```

The diagram shows the main classes and how students, courses, and enrollments
work together.