package org.example.practical.libraryManagementSystem;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String nic;

    public User(String username, String nic) {
        this.username = username;
        this.nic=nic;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
