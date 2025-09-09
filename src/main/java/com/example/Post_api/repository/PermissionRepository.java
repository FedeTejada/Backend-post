package com.example.Post_api.repository;

import com.example.Post_api.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    boolean existPermissionByName(String permissionName);
}
