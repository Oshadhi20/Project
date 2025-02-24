/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.controller;

import edu.ijse.crs.service.StudentService;
import java.util.List;

/**
 *
 * @author Asus
 */
public class StudentController {
    private StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    public List<String> getAllStudents() {
        return studentService.getAllStudents();
    }

    public boolean addStudent(String name, String dob, String program, int year) {
        return studentService.addStudent(name, dob, program, year);
    }
}
