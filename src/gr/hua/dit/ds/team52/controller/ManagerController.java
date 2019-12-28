package gr.hua.dit.ds.team52.controller;


import gr.hua.dit.ds.team52.dao.ServiceDAO;
import gr.hua.dit.ds.team52.dao.StaffDAO;
import gr.hua.dit.ds.team52.dao.UserDAO;
import gr.hua.dit.ds.team52.entity.Role;
import gr.hua.dit.ds.team52.entity.Service;
import gr.hua.dit.ds.team52.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
        // inject the customer dao
        @Autowired
        private StaffDAO staffDAO;

        @Autowired
        private UserDAO userDAO;

        @Autowired
        private ServiceDAO serviceDAO;

        @RequestMapping("/")
        public String showMenu(Model model) {
            return "manager/startpage-manager";
        }

        @RequestMapping("/user")
        public String userManager(Model model) {
            // get users from dao
            List<User> users = userDAO.getUserList();

            // add the users to the model
            model.addAttribute("users", users);

            return "manager/list-user"; //TODO user manager JSP
        }


        @RequestMapping("/user/create")
        public String createUser(HttpServletRequest request,Model model){
            User user = new User();

            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setEnabled(1);

            //Call userDAO and insert student
            userDAO.addUser(user);

            return "student/create-petition";
        }


        @RequestMapping("/role")
        public String roleManager(Model model) {
            // get roles from dao
//            List<Customer> customers = customerDAO.getCustomers();

            // add the roles to the model
            model.addAttribute("roles", null);
            return "redirect:/manager/";
        }


        @RequestMapping("/service")
        public String serviceManager(Model model) {
            // get services from dao
            List<Service> services = serviceDAO.getServices();

            // add the services to the model
            model.addAttribute("services", services);

            return "manager/list-services";
        }

        @RequestMapping("/service/index")
        public String serviceManagerIndex(WebRequest request,Model model) {
            // get services from dao
            String title = request.getParameter("selectedService");
            Service service = staffDAO.searchService(title);
            model.addAttribute("service", service);
            return "manager/service-details";
        }


}

