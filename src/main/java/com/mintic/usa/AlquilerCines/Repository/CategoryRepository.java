package com.mintic.usa.AlquilerCines.Repository;

import com.mintic.usa.AlquilerCines.Repository.Crud.CategoryCrudRepository;
import com.mintic.usa.AlquilerCines.modelo.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private static CategoryCrudRepository categoryCrudRepository;

    public static List<category> getAll(){
        return (List<category>) categoryCrudRepository.findAll();
    }

    public Optional<category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public category save(category category){
        return categoryCrudRepository.save(category);
    }

    public void delete(category category){
        categoryCrudRepository.delete(category);
    }
}
