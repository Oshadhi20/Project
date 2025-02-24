/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.view;

import edu.ijse.crs.service.CourseService;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author Asus
 */
public class CourseView extends JFrame {
    private JList<String> courseList;
    private JButton refreshButton;
    private CourseService courseService;

    public CourseView() {
        courseService = new CourseService();
        setTitle("Course Management");
        setSize(400, 300);
        setLayout(new BorderLayout());
        
        courseList = new JList<>();
        refreshButton = new JButton("Refresh Courses");
        
        refreshButton.addActionListener(e -> {
            List<String> courses = courseService.getAllCourses();
            courseList.setListData(courses.toArray(new String[0]));
        });
        
        add(new JScrollPane(courseList), BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);
    }
}

