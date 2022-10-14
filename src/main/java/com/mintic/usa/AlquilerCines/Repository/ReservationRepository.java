package com.mintic.usa.AlquilerCines.Repository;

import com.mintic.usa.AlquilerCines.Repository.Crud.ReservationCrudRepository;
import com.mintic.usa.AlquilerCines.modelo.reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<reservation> getAll(){
        return(List<reservation>) reservationCrudRepository.findAll();
    }

    public Optional<reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public reservation save(reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
}
