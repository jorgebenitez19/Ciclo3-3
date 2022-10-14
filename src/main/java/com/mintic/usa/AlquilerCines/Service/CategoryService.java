package com.mintic.usa.AlquilerCines.Service;

import com.mintic.usa.AlquilerCines.Repository.CategoryRepository;
import com.mintic.usa.AlquilerCines.modelo.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private static CategoryRepository categoryRepository;

    public List<category> getAll(){
        return CategoryRepository.getAll();
    }
    public Optional<category>getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public static category save(category category){
        if(category.getId() == null){
            return categoryRepository.save(category);
        }else{
            Optional<category> aux = categoryRepository.getCategory(category.getId());
            if(aux.isPresent()){
                return category;
            }else{
                return categoryRepository.save(category);
            }
        }
    }

    public category update(category category){
        if(category.getId() != null) {
            Optional<category> c = categoryRepository.getCategory(category.getId());
            if (c.isPresent()){
                if(category.getName() != null){
                    c.get().setName(category.getName());
                }
                if(category.getDescription() != null){
                    c.get().setDescription(category.getDescription());
                }
                if(category.getCinemas() != null){
                    c.get().setCinemas(category.getCinemas());
                }
                categoryRepository.save(c.get());
                return c.get();

            } else {
                return category;
            }
        }else {
            return category;

        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<category> c = categoryRepository.getCategory(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
        }
        return flag;

    }
}
