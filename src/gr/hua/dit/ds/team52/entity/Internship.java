package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;

@Entity
@Table(name = "internship")
public class Internship {
    @Id
    @Column(name = "title", nullable = false, length = 30)
    private String title;
    @Basic
    @Column(name = "description", nullable = false, length = 45)
    private String description;
    @Basic
    @Column(name = "salary", nullable = false)
    private int salary;
    @Basic
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @Basic
    @Column(name = "approved", nullable = false)
    private byte approved;


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


    public byte getApproved() {
        return approved;
    }

    public void setApproved(byte approved) {
        this.approved = approved;
    }
}
