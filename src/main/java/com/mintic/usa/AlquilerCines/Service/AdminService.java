package com.mintic.usa.AlquilerCines.Service;

import com.mintic.usa.AlquilerCines.Repository.AdminRepository;
import com.mintic.usa.AlquilerCines.modelo.admin;
import com.mintic.usa.AlquilerCines.modelo.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<admin> getAll(){
        return adminRepository.getAll();
    }
    public Optional<admin>getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public admin save(admin admin){
        if(admin.getIdAdmin() == null){
            return adminRepository.save(admin);
        }else{
            Optional<admin> aux = adminRepository.getAdmin(admin.getIdAdmin());
            if(aux.isPresent()){
                return admin;
            }else{
                return adminRepository.save(admin);
            }
        }
    }

    public admin update(admin admin){
        if(admin.getIdAdmin() != null) {
            Optional<admin> c = adminRepository.getAdmin(admin.getId());
            if (c.isPresent()){
                if(admin.getName() != null){
                    c.get().setName(admin.getName());
                }
                if(admin.getIdAdmin() != null){
                    c.get().setIdAdmin(admin.getIdAdmin());
                }
                adminRepository.save(c.get());
                return c.get();

            } else {
                return admin;
            }
        }else {
            return admin;

        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<admin> c = adminRepository.getAdmin(id);
        if(c.isPresent()){
            adminRepository.delete(c.get());
        }
        return flag;

    }
}