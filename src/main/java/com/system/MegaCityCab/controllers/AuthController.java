package com.system.MegaCityCab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.system.MegaCityCab.model.Admin;
import com.system.MegaCityCab.service.AdminService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "*")

public class AuthController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/Admins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/Admin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable String adminId) {
        Admin admin = adminService.getAdminById(adminId);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/CreateAdmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/Admin/{id}")
    public ResponseEntity<Admin> updateAdminEntity
            (@PathVariable String adminId, @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(adminId, admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    } 
}
