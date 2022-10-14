package com.mintic.usa.AlquilerCines.Repository;

import com.mintic.usa.AlquilerCines.Repository.Crud.AdminCrudRepository;
import com.mintic.usa.AlquilerCines.modelo.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<admin> getAll(){
        return(List<admin>) adminCrudRepository.findAll();
    }

    public Optional<admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public admin save(admin admin){
        return adminCrudRepository.save(admin);
    }

    public void delete(admin admin){
        adminCrudRepository.delete(admin);
    }
}
