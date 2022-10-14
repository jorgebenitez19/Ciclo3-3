package com.mintic.usa.AlquilerCines.Web;

import com.mintic.usa.AlquilerCines.Service.ScoreService;
import com.mintic.usa.AlquilerCines.modelo.score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<score> getscore(){
        return scoreService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<score>getscore(@PathVariable("id")int id){
        return scoreService.getScore(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public score save(@RequestBody score score){
        return scoreService.save(score);
    }
    @PutMapping("/update")
    public score update(@RequestBody score score){
        return scoreService.update(score);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return scoreService.delete(id);
    }

}
