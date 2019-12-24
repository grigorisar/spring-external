package gr.hua.dit.ds.team52.service;

import gr.hua.dit.ds.team52.dao.StudentDAO;
import gr.hua.dit.ds.team52.dao.UserDAO;
import gr.hua.dit.ds.team52.entity.Petition;
import gr.hua.dit.ds.team52.entity.Student;
import gr.hua.dit.ds.team52.entity.User;
import gr.hua.dit.ds.team52.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //service layer fro security
    @Autowired
    private StudentDAO studentDAO;
    private UserDAO userDAO;

//    @Override
//    @Transactional
//    public List<Student> getStudents() {
//        return studentDAO.getStudents();
//    }
//
//    @Override
//    @Transactional
//    public Boolean saveStudent(Student student) {
//        return studentDAO.saveStudent(student);
//    }
//
//    @Override
//    @Transactional
//    public List<User> getUserList() {
//        return userDAO.getUserList();
//    }
//
//    @Override
//    @Transactional
//    public Boolean addUser(User user) {
//        return userDAO.addUser(user);
//    }
//
//    @Override
//    @Transactional
//    public List<Petition> getPetitions() {
//        return studentDAO.getPetitions();
//    }
//
//    @Override
//    @Transactional
//    public Boolean savePetition(Petition petition, String studentUsername) {
//        return studentDAO.savePetition(petition,studentUsername);
//    }
}
