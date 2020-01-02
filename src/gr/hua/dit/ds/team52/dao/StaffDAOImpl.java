package gr.hua.dit.ds.team52.dao;

import gr.hua.dit.ds.team52.entity.Internship;
import gr.hua.dit.ds.team52.entity.Petition;
import gr.hua.dit.ds.team52.entity.Service;
import gr.hua.dit.ds.team52.entity.Staff;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StaffDAOImpl implements StaffDAO {
        // inject the session factory

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Internship> getInternshipsPending(){
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Internship> query = currentSession.createQuery("from Internship I where I.status = 'pending' ", Internship.class);

        // execute the query and get the results list
        List<Internship> internships = query.getResultList();
        return internships;
    }

    @Override
    @Transactional
    public List<Internship> getInternshipsAccepted(){
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Internship> query = currentSession.createQuery("from Internship I where I.status = 'accepted' ", Internship.class);

        // execute the query and get the results list
        List<Internship> internships = query.getResultList();
        return internships;
    }

    @Override
    @Transactional
    public boolean acceptInternship(String title) {

        Session currentSession = sessionFactory.getCurrentSession();

//        UserEntity e = new UserEntity();
//        StudentEntity s =new StudentEntity();

        try {

            int q = currentSession.createSQLQuery("UPDATE `internship` SET `status` = 'accepted'  WHERE `internship`.`title` = '" + title + "';").executeUpdate();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public List<Petition> getPetitions(){
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Petition> query = currentSession.createQuery("from Petition", Petition.class);

        // execute the query and get the results list
        List<Petition> petitions = query.getResultList();
        return petitions;
    }


    @Override
    @Transactional
    public List<Internship> getInternships(){
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Internship> query = currentSession.createQuery("from Internship", Internship.class);

        // execute the query and get the results list
        List<Internship> internships = query.getResultList();
        return internships;
    }


//    @Override
//    @Transactional
//    public boolean updateStaff(String old_username, String username, String firstname, String lastname, String position) {
//
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        try {
//
//            if (old_username.equals(username)) {                //change the username if it's different from the old one with a query to the user table
//            }   else {
//                currentSession.createSQLQuery("UPDATE `user` SET `username` = '" + username + "'  WHERE `user`.`username` = '" + old_username + "';").executeUpdate();
//            }
//
//            currentSession.createSQLQuery("UPDATE `staff` SET  `first_name` = '" + firstname + "', `last_name` = '" + lastname + "'," +
//                    " `position` = '" + position + "' WHERE `staff`.`username` = '" + username + "'; ").executeUpdate();
//
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    @Transactional
//    public boolean addStaff(String username, String password, String firstname, String lastname, String role, String position) {
//        // get current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
////        UserEntity e = new UserEntity();
////        StudentEntity s =new StudentEntity();
//        try {
//            int q = currentSession.createSQLQuery("INSERT INTO `user` (`username`, `password`, `enabled`) VALUES ( '" + username + "' , '" + password + "' ,  '1')").executeUpdate();
//            q = currentSession.createSQLQuery("INSERT INTO `staff` (`id`, `first_name`, `last_name`, `username`, `position`) VALUES ( NULL, '" + firstname + "', '" +
//                    lastname + "', '" + username + "', '" + position + "');").executeUpdate();
//            q = currentSession.createSQLQuery("INSERT INTO authorities (username, authority) VALUES ('" + username +"', '" + role + "') ").executeUpdate();
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }

}
