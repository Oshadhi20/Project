/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.dto;

/**
 *
 * @author Asus
 */
public class CourseDto {
    private int courseId;
    private String title;
    private int creditHours;
    private String department;
    private String prerequisite;
    private int maxEnrollment;

    public CourseDto() {}

    public CourseDto(int courseId, String title, int creditHours, String department, String prerequisite, int maxEnrollment) {
        this.courseId = courseId;
        this.title = title;
        this.creditHours = creditHours;
        this.department = department;
        this.prerequisite = prerequisite;
        this.maxEnrollment = maxEnrollment;
    }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCreditHours() { return creditHours; }
    public void setCreditHours(int creditHours) { this.creditHours = creditHours; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getPrerequisite() { return prerequisite; }
    public void setPrerequisite(String prerequisite) { this.prerequisite = prerequisite; }

    public int getMaxEnrollment() { return maxEnrollment; }
    public void setMaxEnrollment(int maxEnrollment) { this.maxEnrollment = maxEnrollment; }
}