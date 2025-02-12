package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Accountant;

public class AccountantDao {

    // Method to get an accountant based on email and password
    public static Accountant getAccountant(String email, String password) {
        Accountant accountant = null;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accountants WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                accountant = new Accountant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountant;
    }

    // Method to add an accountant to the database
    public static boolean addAccountant(Accountant accountant) {
        boolean success = false;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO accountants (name, email, phone, password) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountant.getName());
            stmt.setString(2, accountant.getEmail());
            stmt.setString(3, accountant.getPhone());
            stmt.setString(4, accountant.getPassword());

            int rowsAffected = stmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Method to get all accountants from the database
    public static List<Accountant> getAllAccountants() {
        List<Accountant> accountants = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accountants";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Accountant accountant = new Accountant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("password")
                );
                accountants.add(accountant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountants;
    }

    // Method to delete an accountant from the database by ID
    public static boolean deleteAccountant(int id) {
        boolean success = false;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM accountants WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
