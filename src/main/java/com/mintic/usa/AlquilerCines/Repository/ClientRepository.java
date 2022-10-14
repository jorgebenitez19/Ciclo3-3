package com.mintic.usa.AlquilerCines.Repository;

import com.mintic.usa.AlquilerCines.Repository.Crud.ClientCrudRepository;
import com.mintic.usa.AlquilerCines.modelo.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<client> getAll(){
        return(List<client>) clientCrudRepository.findAll();
    }

    public Optional<client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public client save(client client){
        return clientCrudRepository.save(client);
    }

    public void delete(client client){
        clientCrudRepository.delete(client);
    }
}
