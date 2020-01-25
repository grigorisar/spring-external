package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;

@Entity
@Table(name = "petition")
public class Petition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", nullable = true, length = 45)
    private String title;
    @Column(name = "student_username")
    private String student_username;
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name="internship_id")
    private Internship internship;
    //    private Student student;
//    @JoinColumn(name="student_id")
//    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @Column(name = "company", nullable = true)
//    private String company;


    public Petition() {

    }
    public Petition(String title,String description,String status){
        this.title = title;
        this.description = description;
//        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

}
