package gr.hua.dit.ds.team52.dao;


import gr.hua.dit.ds.team52.entity.Internship;
import gr.hua.dit.ds.team52.entity.Petition;
import gr.hua.dit.ds.team52.entity.Service;
import gr.hua.dit.ds.team52.entity.Staff;

import java.util.List;

public interface StaffDAO {
    public List<Petition> getPetitions();
    public Service searchService(String title);
    public List<Staff> getStaff();
    public List<Internship> getInternships();
}
