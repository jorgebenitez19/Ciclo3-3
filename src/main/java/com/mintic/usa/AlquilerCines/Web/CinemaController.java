package com.mintic.usa.AlquilerCines.Web;

import com.mintic.usa.AlquilerCines.Service.CinemaService;
import com.mintic.usa.AlquilerCines.modelo.cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cinema")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public List<cinema> getCinemas(){
        return cinemaService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<cinema>getCinema(@PathVariable("id")int id){
        return cinemaService.getCinemas(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public cinema save(@RequestBody cinema cinema){
        return cinemaService.save(cinema);
    }
    @PutMapping("/update")
    public cinema update(@RequestBody cinema cinema){
        return cinemaService.update(cinema);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return cinemaService.delete(id);
    }

}
