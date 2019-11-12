package com.spacex.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spacex_user")
public class User {
    @Id
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
