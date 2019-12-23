package gr.hua.dit.ds.team52.entity;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "wM4YgjeZJi", catalog = "")
public class User {
    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "enabled", nullable = false)
    private byte enabled;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }
}
