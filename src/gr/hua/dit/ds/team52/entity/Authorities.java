package gr.hua.dit.ds.team52.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "authority", nullable = false, length = 50)
    private String authority;


    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
}
