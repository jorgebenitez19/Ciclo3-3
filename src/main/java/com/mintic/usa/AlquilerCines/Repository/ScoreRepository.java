package com.mintic.usa.AlquilerCines.Repository;

import com.mintic.usa.AlquilerCines.Repository.Crud.ScoreCrudRepository;
import com.mintic.usa.AlquilerCines.modelo.score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<score> getAll(){
        return(List<score>) scoreCrudRepository.findAll();
    }

    public Optional<score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public score save(score score){
        return scoreCrudRepository.save(score);
    }

    public void delete(score score){
        scoreCrudRepository.delete(score);
    }
}
