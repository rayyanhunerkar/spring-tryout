package com.rayyanhunerkar.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id",
            insertable = false,
            updatable = false,
            nullable = false,
            unique = true
    )
    private UUID id;

    @Column(
            name = "name"
    )
    private String name;
    @Column(
            name = "email"
    )
    private String email;

    @Column(
            name = "age"
    )
    private Integer age;

    @ManyToMany
    @Column(
            name = "age"
    )
    @JoinTable(
            name = "theatres_used",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "theatre_id")
    )
    private Set<Theatre> theatres;

    public Customer(UUID id, String name, String email, Integer age, Set<Theatre> theatres) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.theatres = theatres;
    }

    public Customer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(age, customer.age) && Objects.equals(theatres, customer.theatres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age, theatres);
    }

    public Set<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(Set<Theatre> theatres) {
        this.theatres = theatres;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", theatres=" + theatres +
                '}';
    }
}

