package gr.hua.dit.ds.team52.dao;

import gr.hua.dit.ds.team52.entity.Petition;
import gr.hua.dit.ds.team52.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> getStudents();
    public Boolean saveStudent(Student student);
    public List<Petition> getPetitions();
    public Boolean savePetition(Petition petition,String studentUsername);

}
