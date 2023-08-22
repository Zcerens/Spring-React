package com.example.workspace1.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String username;


    private String displayName;


    private String password;

    @Column(name = "creation_time")
    private LocalDateTime kayitZamani;

    @PrePersist
    protected void onCreate() {
        kayitZamani = LocalDateTime.now();
    }

    private Boolean deleted;


    @Column(columnDefinition = "TEXT")
    private String icerik;





}
