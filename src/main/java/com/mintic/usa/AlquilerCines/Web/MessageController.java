package com.mintic.usa.AlquilerCines.Web;

import com.mintic.usa.AlquilerCines.Service.MessageService;
import com.mintic.usa.AlquilerCines.modelo.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<message> getmessages(){
        return messageService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<message>getmessage(@PathVariable("id")int id){
        return messageService.getMessage(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public message save(@RequestBody message message){
        return messageService.save(message);
    }
    @PutMapping("/update")
    public message update(@RequestBody message message){
        return messageService.update(message);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return messageService.delete(id);
    }

}
