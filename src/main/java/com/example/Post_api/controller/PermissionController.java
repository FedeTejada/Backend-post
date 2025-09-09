package com.example.Post_api.controller;

import com.example.Post_api.entity.Permission;
import com.example.Post_api.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@PreAuthorize("denyAll()")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermission(){
        List<Permission> response = permissionService.getAllPermission();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id){
        Permission response = permissionService.getPermission(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseEntity> createPermission(@RequestBody Permission permission){
        permissionService.createPermission(permission);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Permission> editPermission(@PathVariable Long id,@RequestBody Permission permission){
        Permission response = permissionService.editPermission(id,permission);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Permission> deletePermission(@PathVariable Long id){
        Permission response = permissionService.deletePermission(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
