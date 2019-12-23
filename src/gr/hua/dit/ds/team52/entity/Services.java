package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;

@Entity
@Table(name = "supported_services")
public class Services {

    @Id
    @GeneratedValue
    private String id;
    @Basic
    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Basic
    @Column(name = "description", nullable = false, length = 45)
    private String description;


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
}
