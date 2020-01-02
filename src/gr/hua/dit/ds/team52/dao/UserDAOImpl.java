package gr.hua.dit.ds.team52.dao;

import gr.hua.dit.ds.team52.entity.Authorities;
import gr.hua.dit.ds.team52.entity.Staff;
import gr.hua.dit.ds.team52.entity.Student;
import gr.hua.dit.ds.team52.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//import org.hibernate.query.NativeQuery;

@Repository
public class UserDAOImpl implements UserDAO {

    // inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<User> getUserList() {
        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<User> query = currentSession.createQuery("from User", User.class);

        // execute the query and get the results list
        List<User> users = query.getResultList();

        // return the results
        return users;
    }
    @Override
    @Transactional
    public Boolean saveUser(User user) {

        try {
            Session currentsession=sessionFactory.getCurrentSession();
            currentsession.saveOrUpdate(user);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteUser(String username) {
        try {
            Session currentsession=sessionFactory.getCurrentSession();
            User user = currentsession.createQuery("from User U WHERE U.username ='"+username+"'",User.class).getSingleResult();
            currentsession.delete(user);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean saveAuthority(String username, String role) {
        Authorities authority = new Authorities();
        authority.setUsername(username);
        authority.setRole(role);
        try {
            Session currentsession=sessionFactory.getCurrentSession();
            currentsession.saveOrUpdate(authority);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }
    @Override
    @Transactional
    public Student getStudentByUsername(String username) {
        Session currentsession=sessionFactory.getCurrentSession();
        return currentsession.createQuery("from Student S where S.username ='"+username+"'", Student.class).getSingleResult();
    }

    @Override
    @Transactional
    public Staff getStaffByUsername(String username) {
        Session currentsession=sessionFactory.getCurrentSession();
        return currentsession.createQuery("from Staff S where S.username ='"+username+"'", Staff.class).getSingleResult();
    }
    @Override
    @Transactional
    public List<Student> getStudents(){
        Session currentSession = sessionFactory.getCurrentSession();
        List<Student> students = currentSession.createQuery("from Student", Student.class).getResultList();
        return students;
    }

    @Override
    @Transactional
    public Boolean saveStudent(Student student) {
        /**
         * This function is both an UPDATE and INSERT tool.
         * TODO CHECK BACK FOR BUGS
         */
        Session currentsession=sessionFactory.getCurrentSession();

        try {
            if (student.getId()!=0) {
                currentsession.update(student);
            }else {
                currentsession.save(student);
            }
            return true;
        }catch (Exception e ){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    @Transactional
    public List<Staff> getStaff(){
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        List<Staff> staff = currentSession.createQuery("from Staff", Staff.class).getResultList();
        // execute the query and get the results list
        return staff;
    }

    @Override
    @Transactional
    public Boolean saveStaff(Staff staff) {
        /**
         * This function is both an UPDATE and INSERT tool.
         */
        Session currentsession=sessionFactory.getCurrentSession();

        if (staff.getId()!=0) {
            currentsession.update(staff);
        }else {
            currentsession.save(staff);
        }
        return true;
    }

}

