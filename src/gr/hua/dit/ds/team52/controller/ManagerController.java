package gr.hua.dit.ds.team52.controller;


import gr.hua.dit.ds.team52.dao.ServiceDAO;
import gr.hua.dit.ds.team52.dao.StaffDAO;
import gr.hua.dit.ds.team52.dao.StudentDAO;
import gr.hua.dit.ds.team52.dao.UserDAO;
import gr.hua.dit.ds.team52.entity.Role;
import gr.hua.dit.ds.team52.entity.Service;
import gr.hua.dit.ds.team52.entity.Student;
import gr.hua.dit.ds.team52.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        @Autowired
        private StudentDAO studentDAO;

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
            List<Role> roles = serviceDAO.getRoles();
            // add the roles to the model
            model.addAttribute("roles", roles);
            return "manager/role-manager";
        }
        @ResponseBody
        @RequestMapping (value ="/create_role" , method = RequestMethod.POST)
        public String createRole(WebRequest request ) {
            Role role = new Role();
            //set title id will auto generate
            role.setTitle(request.getParameter("title"));

            serviceDAO.saveRole(role);
            return "Role Added.";
        }

        @ResponseBody
        @RequestMapping (value ="/update_role" , method = RequestMethod.POST)
        public String updateRole(WebRequest request ) {
            //search
            Role role = serviceDAO.getRoleByName(request.getParameter("old_title"));
            role.setTitle(request.getParameter("title"));
            serviceDAO.saveRole(role);
            return "Role Updated.";
        }

        @ResponseBody
        @RequestMapping (value ="/delete_role" , method = RequestMethod.POST)
        public String deleteRole(WebRequest request ) {
            //search
            Role role = serviceDAO.getRoleByName(request.getParameter("title"));
            serviceDAO.deleteRole(role);
            return "Role Deleted.";
        }

        @RequestMapping("/student")
        public String studentManager(Model model) {
            List<Student> students = studentDAO.getStudents();
            model.addAttribute("students", students);
            return "manager/student-manager";
        }

        @RequestMapping("/service")
        public String serviceManager(Model model) {
            // get services from dao
            List<Service> services = serviceDAO.getServices();
            List<Role> roles = serviceDAO.getRoles();

            // add the services to the model
            model.addAttribute("services", services);
            model.addAttribute("roles", roles);

            return "manager/service-manager";
        }

        @ResponseBody
        @RequestMapping (value ="/create_service" , method = RequestMethod.POST)
        public String createService(WebRequest request ) {

            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String[] roles = request.getParameterValues("role[]");


            Service service= new Service();
            service.setDescription(description);
            service.setTitle(title);

            for (String temp:roles) {
                service.add(serviceDAO.getRoleByName(temp));
            }
            serviceDAO.saveService(service);
            return "Service Added.";
        }

        @ResponseBody
        @RequestMapping (value ="/update_service" , method = RequestMethod.POST)
        public String updateService (WebRequest request ) {

            String old_title = request.getParameter("old_title");
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String[] roles = request.getParameterValues("role[]");

            Service service = serviceDAO.getServiceByName(old_title);

            //clear list
            service.setRoles(null);
            service.setDescription(description);
            service.setTitle(title);

            //fill list with new roles
            for (String temp:roles) {
                service.add(serviceDAO.getRoleByName(temp));
            }
            serviceDAO.saveService(service);
            return "Service Updated.";
        }

        @ResponseBody
        @RequestMapping (value ="/delete_service" , method = RequestMethod.POST)
        public String deleteService (WebRequest request ) {
            Service service = serviceDAO.getServiceByName(request.getParameter("title"));
            serviceDAO.deleteService(service);
            return "Service Deleted.";
        }


    }

