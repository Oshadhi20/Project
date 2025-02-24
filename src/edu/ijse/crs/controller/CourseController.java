/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.controller;

import edu.ijse.crs.service.CourseService;
import java.util.List;


/**
 *
 * @author Asus
 */

public class CourseController {
    private CourseService courseService;

    public CourseController() {
        this.courseService = new CourseService();
    }

    public List<String> getAllCourses() {
        return courseService.getAllCourses();
    }

    public int getCourseIdByName(String name) {
        return courseService.getCourseIdByName(name);
    }
}     

