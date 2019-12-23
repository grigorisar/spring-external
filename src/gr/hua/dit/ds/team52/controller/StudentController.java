package gr.hua.dit.ds.team52.controller;

import gr.hua.dit.ds.team52.dao.StudentDAO;
import gr.hua.dit.ds.team52.dao.UserDAO;
import gr.hua.dit.ds.team52.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    //Inject DAO its the same for all objects
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping("/list")
    public String listStudents(Model model){

        // get customers from dao
        List<Student> students = studentDAO.getStudents();

        // add the customers to the model
        model.addAttribute("students", students);

        return "list-students";
    }



}
