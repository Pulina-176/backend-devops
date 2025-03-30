package com.xpensify.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;

    @Column
    private String username;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
