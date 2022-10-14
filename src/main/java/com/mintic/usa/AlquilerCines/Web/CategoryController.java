package com.mintic.usa.AlquilerCines.Web;

import com.mintic.usa.AlquilerCines.Service.CategoryService;
import com.mintic.usa.AlquilerCines.modelo.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<category> getCategories(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public category save(@RequestBody category category){
        return CategoryService.save(category);
    }
    @PutMapping("/update")
    public category update(@RequestBody category category){
        return categoryService.update(category);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return categoryService.delete(id);
    }
}
