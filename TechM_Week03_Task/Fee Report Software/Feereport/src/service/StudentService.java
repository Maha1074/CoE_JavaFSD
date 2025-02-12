package service;

import dao.StudentDao;
import model.Student;

public class StudentService {
    public static boolean registerStudent(Student student) {
        return StudentDao.addStudent(student);
    }

    public static Student fetchStudentById(int id) {
        return StudentDao.getStudentById(id);
    }
}
