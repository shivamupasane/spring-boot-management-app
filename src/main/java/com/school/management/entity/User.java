package com.school.management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@RequiredArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NonNull
    @NotBlank(message = "username can not be blank")
    @Column(name="user_name")
    private String username;

    @NonNull
    @NotBlank(message="password can not be blank")
    @Column(name="password")
    private String password;


}
