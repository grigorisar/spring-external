package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "internship")
public class Internship {
    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "salary")
    private int salary;

    @Column(name = "status")
    private String status;

    //Company of internships
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
    private Rep rep;

    //Petitions for the position
    @OneToMany(mappedBy = "petition",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Petition> petitions;

    public Internship() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Rep getRep() {
        return rep;
    }

    public void setRep(Rep rep) {
        this.rep = rep;
    }

    public List<Petition> getPetitions() {
        return petitions;
    }

    public void addPetition(Petition petition) {
        if (petitions == null){
            petitions = new ArrayList<>();
        }
        this.petitions.add(petition);
    }

    //    public boolean getApproved() {
//        return approved;
//    }
//
//    public void setApproved(boolean approved) {
//        this.approved = approved;
//    }
}
