package com.example.Post_api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true,nullable = false)
    private String nameRole;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permmision_id"))
    Set<Permission> permissions = new HashSet<>();

    public Role(){};

    public Long getId() {
        return id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

}
