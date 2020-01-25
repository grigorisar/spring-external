package gr.hua.dit.ds.team52.controllerEXT;

import gr.hua.dit.ds.team52.externalDAO.InternshipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/internship")
public class InternshipController {

    @Autowired
    private InternshipDAO internshipDAO;

    @RequestMapping("/")
    public String showfirstpage() {
        return "internship/internship";
    }

}

