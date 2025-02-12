package service;

import dao.AccountantDao;
import model.Accountant;

public class AccountantService {
    public static boolean addNewAccountant(Accountant accountant) {
        return AccountantDao.addAccountant(accountant); // Ensure this method exists in AccountantDao
    }

    public static Accountant getAccountant(String email, String password) {
        return AccountantDao.getAccountant(email, password); // FIX: Call correct method
    }
}
