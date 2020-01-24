package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rep")
public class Rep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "first_name", nullable = true, length = 45)
    private String firstName;
    @Column(name = "last_name", nullable = true, length = 45)
    private String lastName;
    @Column(name = "position", nullable = true, length = 30)
    private String position;

    //LIST OF INTERNSHIPS
    @OneToMany(mappedBy = "rep",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Internship> internships;

    public Rep(String username,String firstName ,String lastName) {
        this.username= username;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void addInternship(Internship foo){
        if (this.internships == null){
            this.internships = new ArrayList<>();
        }
        this.internships.add(foo);
    }
}
