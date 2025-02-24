/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.service;

import edu.ijse.crs.dao.CourseDao;
import edu.ijse.crs.dao.EnrollmentDao;
import edu.ijse.crs.dao.AcademicRecordDao;

/**
 *
 * @author Asus
 */
public class EnrollmentService {
    private EnrollmentDao enrollmentDao;
    private CourseDao courseDao;
    private AcademicRecordDao academicRecordDao;

    public EnrollmentService() {
        this.enrollmentDao = new EnrollmentDao();
        this.courseDao = new CourseDao();
        this.academicRecordDao = new AcademicRecordDao();
    }

    public boolean hasCompletedPrerequisites(int studentId, int courseId) {
        String prerequisites = courseDao.getPrerequisites(courseId);
        if (prerequisites == null || prerequisites.isEmpty()) {
            return true;
        }
        
        String[] prerequisiteCourses = prerequisites.split(",");
        for (String prerequisite : prerequisiteCourses) {
            if (!academicRecordDao.hasCompletedCourse(studentId, Integer.parseInt(prerequisite.trim()))) {
                return false;
            }
        }
        return true;
    }

    public boolean enrollStudent(int studentId, int courseId) {
        if (hasCompletedPrerequisites(studentId, courseId)) {
            enrollmentDao.enrollStudent(studentId, courseId);
            return true;
        } else {
            System.out.println("Enrollment failed: Prerequisites not met.");
            return false;
        }
    }
}

