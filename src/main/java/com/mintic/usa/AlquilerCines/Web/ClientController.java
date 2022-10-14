package com.mintic.usa.AlquilerCines.Web;

import com.mintic.usa.AlquilerCines.Service.ClientService;
import com.mintic.usa.AlquilerCines.modelo.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<client> getClients(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<client>getClient(@PathVariable("id")int id){
        return clientService.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public client save(@RequestBody client client){
        return clientService.save(client);
    }
    @PutMapping("/update")
    public client update(@RequestBody client client){
        return clientService.update(client);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return clientService.delete(id);
    }

}
