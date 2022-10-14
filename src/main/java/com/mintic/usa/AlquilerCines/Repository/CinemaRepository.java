package com.mintic.usa.AlquilerCines.Repository;

import com.mintic.usa.AlquilerCines.Repository.Crud.CinemaCrudRepository;
import com.mintic.usa.AlquilerCines.modelo.cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {

    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;

    public List<cinema> getAll(){
        return (List<cinema>) cinemaCrudRepository.findAll();
    }

    public Optional<cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }
    public cinema save(cinema cinema){
        return cinemaCrudRepository.save(cinema);
    }
    public void delete(cinema cinema){
        cinemaCrudRepository.delete(cinema);
    }
}
