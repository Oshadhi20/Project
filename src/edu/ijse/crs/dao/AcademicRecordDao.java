/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.dao;

import edu.ijse.crs.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class AcademicRecordDao {
     public boolean hasCompletedCourse(int studentId, int courseId) {
        String sql = "SELECT COUNT(*) FROM AcademicRecords WHERE student_id = ? AND course_id = ? AND grade IS NOT NULL";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // Returns true if a record is found
            }
        } catch (SQLException e) {
            System.err.println("Error checking completed courses: " + e.getMessage());
        }
        return false;
    }
}

