package com.mintic.usa.AlquilerCines.Service;

import com.mintic.usa.AlquilerCines.Repository.ScoreRepository;
import com.mintic.usa.AlquilerCines.modelo.score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public score save(score score){
        if(score.getIdScore() == null){
            return scoreRepository.save(score);
        }else{
            Optional<score> aux = scoreRepository.getScore(score.getIdScore());
            if(aux.isPresent()){
                return score;
            }else{
                return scoreRepository.save(score);
            }
        }
    }

    public score update(score score){
        if(score.getIdScore() != null) {
            Optional<score> c = scoreRepository.getScore(score.getIdScore());
            if (c.isPresent()){
                if(score.getMessageText() != null){
                    c.get().setMessageText(score.getMessageText());
                }
                if(score.getStarts() != null){
                    c.get().setStarts(score.getStarts());
                }
                scoreRepository.save(c.get());
                return c.get();

            } else {
                return score;
            }
        }else {
            return score;

        }
    }
    public boolean delete(int id){
        boolean flag = false;
        Optional<score> c = scoreRepository.getScore(id);
        if(c.isPresent()){
            scoreRepository.delete(c.get());
        }
        return flag;

    }
}

