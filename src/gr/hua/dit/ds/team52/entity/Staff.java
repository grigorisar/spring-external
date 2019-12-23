package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {
    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 45)
    private String lastName;
    @Basic
    @Column(name = "position", nullable = true, length = 30)
    private String position;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
