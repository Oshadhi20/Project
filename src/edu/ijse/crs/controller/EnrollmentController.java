/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.controller;

import edu.ijse.crs.service.EnrollmentService;

/**
 *
 * @author Asus
 */
public class EnrollmentController {
    private EnrollmentService enrollmentService;

    public EnrollmentController() {
        this.enrollmentService = new EnrollmentService();
    }

    public boolean enrollStudent(int studentId, int courseId) {
        return enrollmentService.enrollStudent(studentId, courseId);
    }
}
