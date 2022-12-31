package com.rayyanhunerkar.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "theatre")
public class Theatre {

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
            name = "name",
            nullable = false)
    private String name;

    @Column(
            name = "location",
            nullable = false
    )
    private String location;

//    @ManyToMany(mappedBy = "theatres")
//    private Set<Customer> customers;

    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return Objects.equals(id, theatre.id) && Objects.equals(name, theatre.name) && Objects.equals(location, theatre.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }

//    public Set<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Set<Customer> customers) {
//        this.customers = customers;
//    }

    public Theatre(UUID id, String name, String location) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.location = location;
    }

    public Theatre() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

