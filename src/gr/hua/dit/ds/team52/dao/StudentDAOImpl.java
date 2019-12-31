package gr.hua.dit.ds.team52.dao;

import gr.hua.dit.ds.team52.entity.Petition;
import gr.hua.dit.ds.team52.entity.Student;
import gr.hua.dit.ds.team52.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Student> getStudents(){
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Student> query = currentSession.createQuery("from Student", Student.class);

        // execute the query and get the results list
        List<Student> students = query.getResultList();
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


        //if user doesnt exist
        if ( currentsession.createQuery("from User u WHERE u.username = '"+student.getUsername()+"'", User.class).getSingleResult().equals(null)){
            return false;
        }

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
    public List<Petition> getPetitions(){
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Petition> query = currentSession.createQuery("from Petition", Petition.class);

        // execute the query and get the results list
        List<Petition> Petitions = query.getResultList();
        return Petitions;
    }

    @Override
    @Transactional
    public Boolean savePetition(Petition petition,String studentID) {
        /**
         * This function is an INSERT tool ONLY.
         */
        try {
            Session currentsession=sessionFactory.getCurrentSession();
            Student student = currentsession.get(Student.class,studentID);
            petition.setStudent(student);

            currentsession.save(petition);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

        return true;
    }
}
