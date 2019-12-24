package gr.hua.dit.ds.team52.dao;

import gr.hua.dit.ds.team52.entity.Student;
import gr.hua.dit.ds.team52.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUserList();
    public Boolean addUser(User user);


}
