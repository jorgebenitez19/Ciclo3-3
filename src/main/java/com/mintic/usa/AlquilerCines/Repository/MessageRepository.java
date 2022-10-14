package com.mintic.usa.AlquilerCines.Repository;

import com.mintic.usa.AlquilerCines.Repository.Crud.MessageCrudRepository;
import com.mintic.usa.AlquilerCines.modelo.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<message> getAll(){
        return(List<message>) messageCrudRepository.findAll();
    }

    public Optional<message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public message save(message message){
        return messageCrudRepository.save(message);
    }

    public void delete(message message){
        messageCrudRepository.delete(message);
    }
}
