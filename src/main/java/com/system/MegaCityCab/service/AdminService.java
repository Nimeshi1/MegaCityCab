package com.system.MegaCityCab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.MegaCityCab.model.Admin;

@Service

public interface AdminService {
    List<Admin>getAllAdmins();
    Admin createAdmin(Admin admin);
    Admin updateAdmin(String adminId, Admin admin);
    Admin getAdminById(String adminId);


    
} 
