package com.mintic.usa.AlquilerCines.Service;

import com.mintic.usa.AlquilerCines.Repository.ReservationRepository;
import com.mintic.usa.AlquilerCines.modelo.reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public reservation save(reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<reservation> aux = reservationRepository.getReservation(reservation.getIdReservation());
            if(aux.isPresent()){
                return reservation;
            }else{
                return reservationRepository.save(reservation);
            }
        }
    }

    public reservation update(reservation reservation){
        if(reservation.getIdReservation() != null) {
            Optional<reservation> c = reservationRepository.getReservation(reservation.getIdReservation());
            if (c.isPresent()){
                if(reservation.getStartDate() != null){
                    c.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate() != null){
                    c.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus() != null){
                    c.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(c.get());
                return c.get();

            } else {
                return reservation;
            }
        }else {
            return reservation;

        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<reservation> c = reservationRepository.getReservation(id);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
        }
        return flag;

    }
}

