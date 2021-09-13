package br.com.global.springwebmvc.rest;


import br.com.global.springwebmvc.model.Jedi;
import br.com.global.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public Iterable<Jedi> getAllJedi(){
        return repository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> findById(@PathVariable("id")  Long id){
        final Optional<Jedi> jedi = repository.findById(id);

        if(jedi.isPresent()){
            return ResponseEntity.ok(jedi.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/api/jedi/name/{name}")
    public List<Jedi> findByName(@PathVariable("name")  String name){
        return repository.findByName(name);
    }

    @GetMapping("/api/jedi/lastname/{lastname}")
    public List<Jedi> findByLastName(@PathVariable("lastname")  String lastname){
        return repository.findByLastName(lastname);
    }

    @PostMapping("/api/jedi")
    public ResponseEntity<Jedi>  Create(@Valid @RequestBody Jedi jedi) throws URISyntaxException {
        final Jedi jediSaved = repository.save(jedi);
        URI uri = new URI(String.format("http://localhost:8080/api/jedi/%d",jediSaved.getId()));

        return ResponseEntity.created(uri).body(jediSaved);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi jedi ){

        final Optional<Jedi> jediOptional = repository.findById(id);

        if(jediOptional.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        final Jedi jediUpdated = jediOptional.get();

        jediUpdated.setName(jedi.getName());
        jediUpdated.setLastName(jedi.getLastName());

        return ResponseEntity.ok(repository.save(jediUpdated));
    }


}
