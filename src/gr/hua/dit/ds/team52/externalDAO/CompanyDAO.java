package gr.hua.dit.ds.team52.externalDAO;

import gr.hua.dit.ds.team52.entity.Company;

import java.util.List;

public interface CompanyDAO {

    public void saveCompany(Company company);
    public void deleteCompany(Company company);
    public List<Company> getCompanies();


}
