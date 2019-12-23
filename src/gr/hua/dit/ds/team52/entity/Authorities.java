package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authorities {
    @Basic
    @Column(name = "authority", nullable = false, length = 50)
    private String authority;



    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authorities that = (Authorities) o;

        if (authority != null ? !authority.equals(that.authority) : that.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return authority != null ? authority.hashCode() : 0;
    }

    private String username;

    @GeneratedValue
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
