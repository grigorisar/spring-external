package gr.hua.dit.ds.team52.controller;

import gr.hua.dit.ds.team52.dao.StudentDAO;
import gr.hua.dit.ds.team52.dao.UserDAO;
import gr.hua.dit.ds.team52.entity.Petition;
import gr.hua.dit.ds.team52.entity.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    //Inject DAO its the same for all objects
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private StudentDAO studentDAO;


    @RequestMapping("/")
    public String showOptions(Model model){
        return "student/startpage-student";
    }

    @RequestMapping("/new_petition")
    public String createPetitionJSP(Model model){
        return "student/create-petition";
    }

    @ResponseBody
    @PostMapping(value = "/create_petition_process")
    public String createPetition(WebRequest request) {
        Petition petition = new Petition();
        String currentUserName = "current username not found";


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

        petition.setTitle(request.getParameter("title"));
        petition.setDescription(request.getParameter("description"));

        Student student = userDAO.getStudentByUsername(currentUserName);
        if (student.canSubmit()){
            student.add(petition);
            userDAO.saveStudent(student);
        }else {
            return "No rights to create petition";
        }
        return "Petition successfully added";
    }



}
