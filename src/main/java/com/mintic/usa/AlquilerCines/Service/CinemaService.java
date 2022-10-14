package com.mintic.usa.AlquilerCines.Service;

import com.mintic.usa.AlquilerCines.Repository.CinemaRepository;
import com.mintic.usa.AlquilerCines.modelo.cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<cinema> getAll(){
        return cinemaRepository.getAll();
    }
    public Optional<cinema>getCinemas(int id){
        return cinemaRepository.getCinema(id);
    }

    public cinema save(cinema cinema){
        if(cinema.getId() == null){
            return cinemaRepository.save(cinema);
        }else{
            Optional<cinema> aux = cinemaRepository.getCinema(cinema.getId());
            if(aux.isPresent()){
                return cinema;
            }else{
                return cinemaRepository.save(cinema);
            }
        }
    }

    public cinema update(cinema cinema){
        if(cinema.getId() != null) {
            Optional<cinema> c = cinemaRepository.getCinema(cinema.getId());
            if (c.isPresent()){
                if(cinema.getName() != null){
                    c.get().setName(cinema.getName());
                }
                if(cinema.getOwner() != null){
                    c.get().setOwner(cinema.getOwner());
                }
                if(cinema.getCapacity() != null){
                    c.get().setCapacity(cinema.getCapacity());
                }
                if(cinema.getCategory_id() != null){
                    c.get().setCategory_id(cinema.getCategory_id());
                }
                cinemaRepository.save(c.get());
                return c.get();

            } else {
                return cinema;
            }
        }else {
            return cinema;

        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<cinema> c = cinemaRepository.getCinema(id);
        if(c.isPresent()){
            cinemaRepository.delete(c.get());
        }
        return flag;

    }
}
