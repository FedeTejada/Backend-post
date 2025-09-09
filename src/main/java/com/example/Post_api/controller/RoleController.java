package com.example.Post_api.controller;

import com.example.Post_api.entity.Role;
import com.example.Post_api.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    public IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> response = roleService.getAllRole();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        Role response = roleService.getRole(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        Role response = roleService.createRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Role> editRole(@PathVariable Long id, @RequestBody Role role){
        Role response = roleService.editRole(id,role);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable Long id){
        Role response = roleService.deleteRole(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
