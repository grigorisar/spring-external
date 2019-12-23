package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "first_name", nullable = true, length = 45)
    private String firstName;
    @Column(name = "last_name", nullable = true, length = 45)
    private String lastName;
    @Column(name= "username", nullable = false, length = 50)
    private String username;
    @Column(name = "password", nullable = false, length = 100)
    private String password; //TODO delete this column due to mapping with 'user' table
    @Column(name = "dept", nullable = true, length = 45)
    private String dept;
    @Column(name = "year", nullable = true, length = 5)
    private String year;
    @Column(name = "failed", nullable = true)
    private Integer failed;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
