package gr.hua.dit.ds.team52.dao;

import gr.hua.dit.ds.team52.entity.Student;

import java.util.List;

public interface UserDAO {

    public List<Student> getStudentList();

    public void addStudent(String username, String password, String firstname, String lastname, String role, int failed, String dept, String year);

}
