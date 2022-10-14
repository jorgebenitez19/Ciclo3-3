package com.mintic.usa.AlquilerCines.Service;

import com.mintic.usa.AlquilerCines.Repository.MessageRepository;
import com.mintic.usa.AlquilerCines.modelo.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public message save(message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        }else{
            Optional<message> aux = messageRepository.getMessage(message.getIdMessage());
            if(aux.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }

    public message update(message message){
        if(message.getIdMessage() != null) {
            Optional<message> c = messageRepository.getMessage(message.getIdMessage());
            if (c.isPresent()){
                if(message.getMessageText() != null){
                    c.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(c.get());
                return c.get();

            } else {
                return message;
            }
        }else {
            return message;

        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<message> c = messageRepository.getMessage(id);
        if(c.isPresent()){
            messageRepository.delete(c.get());
        }
        return flag;

    }
}
