package dao;
import java.sql.*;
import java.util.ArrayList;
import model.Accountant;
import model.Admin;

public class AdminDao {
    public static Admin getAdmin(String username, String password) {
        Admin admin = null;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM admin WHERE username=? AND password=?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
    public static boolean addAccountant(String name, String email, String phone, String password) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO accountant (name, email, phone, password) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, password);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Return true if insertion is successful
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Accountant> getAllAccountants() {
        ArrayList<Accountant> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM accountant");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Accountant acc = new Accountant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("password")
                );
                list.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Method to update an Accountant's details
    public static boolean updateAccountant(int id, String name, String email, String phone, String password) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE accountant SET name=?, email=?, phone=?, password=? WHERE id=?")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, password);
            ps.setInt(5, id);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // Return true if update is successful
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to delete an Accountant
    public static boolean deleteAccountant(int id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM accountant WHERE id=?")) {

            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0; // Return true if deletion is successful
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
