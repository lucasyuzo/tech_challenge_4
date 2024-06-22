package com.tech_challenge_4.user_application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CPF
    private String cpf;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public User() {
        super();
    }

    public User(UUID id, String cpf, String firstName, String lastName, String email, Address address) {
        this.id = id;
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public @CPF String getCpf() {
        return cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public @Email String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}

