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
    public List<Staff> getStaff(){
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        Query<Staff> query = currentSession.createQuery("from Staff", Staff.class);
        // execute the query and get the results list
        List<Staff> staff = query.getResultList();
        return staff;
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
    public List<Service> getServices(){
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query<Service> query = currentSession.createQuery("from Service", Service.class);

        System.out.println(query.getFirstResult());
        // execute the query and get the results list
        List<Service> services = query.getResultList();
        return services;
    }

    @Override
    public Service searchService(String title) {
        Session currentSession = sessionFactory.getCurrentSession();
        // create a query
        Service service = currentSession.createQuery("from Service S WHERE s.title LIKE '"+title+"'" , Service.class).getSingleResult();
        return service;
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
}
