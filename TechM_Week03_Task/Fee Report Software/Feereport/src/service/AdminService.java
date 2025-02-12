package service;

import dao.AdminDao;
import java.util.ArrayList;
import model.Accountant;
import model.Admin;

public class AdminService {
    
    // Validate Admin login credentials
    public static Admin validateAdmin(String username, String password) {
        return AdminDao.getAdmin(username, password);
    }

    // Add an accountant
    public static boolean addAccountant(String name, String email, String phone, String password) {
        return AdminDao.addAccountant(name, email, phone, password);
    }

    // Retrieve all accountants
    public static ArrayList<Accountant> viewAccountants() {
        return AdminDao.getAllAccountants();
    }

    // Update an accountant's details
    public static boolean updateAccountant(int id, String name, String email, String phone, String password) {
        return AdminDao.updateAccountant(id, name, email, phone, password);
    }

    // Delete an accountant
    public static boolean deleteAccountant(int id) {
        return AdminDao.deleteAccountant(id);
    }
}
