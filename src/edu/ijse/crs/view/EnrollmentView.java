/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.view;

import edu.ijse.crs.service.EnrollmentService;
import edu.ijse.crs.service.StudentService;
import edu.ijse.crs.service.CourseService;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;
/**
 *
 * @author Asus
 */

public class EnrollmentView extends JFrame {
    private JComboBox<String> studentDropdown, courseDropdown;
    private JButton enrollButton;
    private EnrollmentService enrollmentService;
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentView() {
        enrollmentService = new EnrollmentService();
        studentService = new StudentService();
        courseService = new CourseService();

        setTitle("Enrollment Management");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensures window closes properly

        add(new JLabel("Select Student:"));
        studentDropdown = new JComboBox<>(getStudentList());
        add(studentDropdown);

        add(new JLabel("Select Course:"));
        courseDropdown = new JComboBox<>(getCourseList());
        add(courseDropdown);

        enrollButton = new JButton("Enroll Student");
        enrollButton.addActionListener(e -> enrollStudent());
        add(enrollButton);

        setVisible(true); // Show the window
    }

    /**
     * Fetches students from the database and populates dropdown.
     */
    private String[] getStudentList() {
        List<String> students = studentService.getAllStudents(); // Assuming this method returns student names
        return students.toArray(new String[0]);
    }

    /**
     * Fetches courses from the database and populates dropdown.
     */
    private String[] getCourseList() {
        List<String> courses = courseService.getAllCourses(); // Assuming this method returns course names
        return courses.toArray(new String[0]);
    }

    /**
     * Handles student enrollment process.
     */
    private void enrollStudent() {
        if (studentDropdown.getSelectedIndex() == -1 || courseDropdown.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student and a course.");
            return;
        }

        String selectedStudent = (String) studentDropdown.getSelectedItem();
        String selectedCourse = (String) courseDropdown.getSelectedItem();

        int studentId = studentService.getStudentIdByName(selectedStudent);
        int courseId = courseService.getCourseIdByName(selectedCourse);

        if (enrollmentService.enrollStudent(studentId, courseId)) {
            JOptionPane.showMessageDialog(this, "Enrollment Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Enrollment Failed: Prerequisites not met.");
        }
    }
}

