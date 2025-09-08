package com.example.Post_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String permissionName;

    public Permission(){}

    public Long getId() {
        return id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
