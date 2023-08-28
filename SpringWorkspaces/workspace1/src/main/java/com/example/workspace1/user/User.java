package com.example.workspace1.user;

import com.example.workspace1.shared.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 4, max = 20)
    @Column(unique = true)
    @JsonView(Views.Base.class)
    private String username;

    @NotNull
    @Size(min = 4, max = 20)
    @JsonView(Views.Base.class)
    private String displayName;

    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$" )
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
    @JsonView(Views.Base.class)
    private String image;

}
