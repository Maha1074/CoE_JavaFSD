package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;

public class StudentDao {
    public static boolean addStudent(Student student) {
        boolean status = false;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO student(name, email, course, fee, paid, due, address, phone) VALUES(?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setDouble(4, student.getFee());
            ps.setDouble(5, student.getPaid());
            ps.setDouble(6, student.getDue());
            ps.setString(7, student.getAddress());
            ps.setString(8, student.getPhone());
            status = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Student getStudentById(int id) {
        Student student = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getDouble("fee"),
                        rs.getDouble("paid"),
                        rs.getDouble("due"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
