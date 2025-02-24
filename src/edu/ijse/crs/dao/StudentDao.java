/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.crs.dao;

import edu.ijse.crs.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class StudentDao {
    public void addStudent(String name, String dob, String program, int year) {
        String sql = "INSERT INTO Students (name, date_of_birth, program, year) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, dob);
            stmt.setString(3, program);
            stmt.setInt(4, year);
            stmt.executeUpdate();
            System.out.println("Student added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
