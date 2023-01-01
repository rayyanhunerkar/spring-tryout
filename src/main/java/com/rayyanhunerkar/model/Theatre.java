package com.rayyanhunerkar.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
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

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date created_at;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updated_at;

    public Theatre(UUID id, String name, String location, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.created_at = createdAt;
        this.updated_at = updatedAt;
    }

    public Theatre() {
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + created_at +
                ", updatedAt=" + updated_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theatre theatre = (Theatre) o;
        return Objects.equals(id, theatre.id) && Objects.equals(name, theatre.name) && Objects.equals(location, theatre.location) && Objects.equals(created_at, theatre.created_at) && Objects.equals(updated_at, theatre.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, created_at, updated_at);
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
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

