package com.mintic.usa.AlquilerCines.Service;

import com.mintic.usa.AlquilerCines.Repository.ClientRepository;
import com.mintic.usa.AlquilerCines.modelo.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<client>getClient(int id){
        return clientRepository.getClient(id);
    }

    public client save(client client){
        if(client.getIdClient() == null){
            return clientRepository.save(client);
        }else{
            Optional<client> aux = clientRepository.getClient(client.getIdClient());
            if(aux.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }

    public client update(client client){
        if(client.getIdClient() != null) {
            Optional<client> c = clientRepository.getClient(client.getIdClient());
            if (c.isPresent()){
                if(client.getName() != null){
                    c.get().setName(client.getName());
                }
                if(client.getEmail() != null){
                    c.get().setEmail(client.getEmail());
                }
                if(client.getAge() != null){
                    c.get().setAge(client.getAge());
                }
                clientRepository.save(c.get());
                return c.get();

            } else {
                return client;
            }
        }else {
            return client;

        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<client> c = clientRepository.getClient(id);
        if(c.isPresent()){
            clientRepository.delete(c.get());
        }
        return flag;

    }
}

