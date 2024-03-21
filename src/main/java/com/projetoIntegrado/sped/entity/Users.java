package com.projetoIntegrado.sped.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private int cpf;
    private String pass;
    private int roleId;

    @ManyToOne
    @JoinColumn
    private UserRoles userRole;


}
