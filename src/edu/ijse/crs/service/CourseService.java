/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.service;

import edu.ijse.crs.dao.CourseDao;
import java.util.List;

/**
 *
 * @author Asus
 */
public class CourseService {
    private CourseDao courseDao;

    public CourseService() {
        this.courseDao = new CourseDao();
    }

    public List<String> getAllCourses() {
        return courseDao.getAllCourses();
        
    }
     public int getCourseIdByName(String name) {
        return courseDao.getCourseIdByName(name);
    }
}
