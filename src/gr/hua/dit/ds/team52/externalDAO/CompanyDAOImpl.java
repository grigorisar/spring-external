package gr.hua.dit.ds.team52.externalDAO;

import gr.hua.dit.ds.team52.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveCompany(Company company) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(company);
    }

    @Override
    @Transactional
    public void deleteCompany(Company company) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(company);
    }

    @Override
    @Transactional
    public List<Company> getCompanies() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Company",Company.class).getResultList();
    }
}
