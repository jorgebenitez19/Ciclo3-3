package com.mintic.usa.AlquilerCines.Web;

import com.mintic.usa.AlquilerCines.Service.AdminService;
import com.mintic.usa.AlquilerCines.modelo.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class AdminController {
    @Autowired
    private AdminService  adminService;

    @GetMapping("/all")
    public List<admin> getAdmins(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<admin>getAdmin(@PathVariable("id")int id){
        return adminService.getAdmin(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public admin save(@RequestBody admin admin){
        return adminService.save(admin);
    }
    @PutMapping("/update")
    public admin update(@RequestBody admin admin){
        return adminService.update(admin);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return adminService.delete(id);
    }

}
