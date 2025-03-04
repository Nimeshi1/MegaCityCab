package com.system.MegaCityCab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.MegaCityCab.model.Admin;
import com.system.MegaCityCab.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{


    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin createAdmin(Admin admin) {
       
            return adminRepository.save(admin);
    }

    

    @Override
    public List<Admin> getAllAdmins() {
        
            return adminRepository.findAll();
    
}

    @Override
    public Admin updateAdmin(String adminId, Admin admin) {
        
            if (adminRepository.existsById(adminId)) {
                admin.setAdminId(adminId);
                return adminRepository.save(admin);
            } else {
                throw new RuntimeException("User not found for id: " + adminId);
            }
        }



    @Override
    public Admin getAdminById(String adminId) {
        return adminRepository.findById(adminId)
        .orElseThrow(() -> new RuntimeException("Customer not found with ID:"+adminId));
    }
    
    
}
