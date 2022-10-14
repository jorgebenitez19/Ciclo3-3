package com.mintic.usa.AlquilerCines.Web;

import com.mintic.usa.AlquilerCines.Service.ReservationService;
import com.mintic.usa.AlquilerCines.modelo.reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<reservation> getreservations(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<reservation>getreservation(@PathVariable("id")int id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public reservation save(@RequestBody reservation reservation){
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    public reservation update(@RequestBody reservation reservation){
        return reservationService.update(reservation);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

}
