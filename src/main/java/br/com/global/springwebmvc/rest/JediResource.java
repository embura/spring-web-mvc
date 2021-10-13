package br.com.global.springwebmvc.rest;

import br.com.global.springwebmvc.exception.JediNotFoundException;
import br.com.global.springwebmvc.model.Jedi;
import br.com.global.springwebmvc.services.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping("/api/jedi")
    public Iterable<Jedi> getAllJedi(){
        return service.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> findById(@PathVariable("id")  Long id) throws JediNotFoundException {
        final Jedi jedi = service.findById(id);
        return ResponseEntity.ok(jedi);
    }

    @GetMapping("/api/jedi/name/{name}")
    public List<Jedi> findByName(@PathVariable("name")  String name){
        return service.findByName(name);
    }

    @GetMapping("/api/jedi/lastname/{lastname}")
    public List<Jedi> findByLastName(@PathVariable("lastname")  String lastname){
        return service.findByLastName(lastname);
    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Jedi>  create(@Valid @RequestBody Jedi jedi) throws URISyntaxException {
        final Jedi jediSaved = service.save(jedi);
        final URI uri = new URI(String.format("http://localhost:8080/api/jedi/%d",jediSaved.getId()));

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi jedi ) throws JediNotFoundException {
        final Jedi jediUpdated = service.update(id, jedi);
        return ResponseEntity.ok(jediUpdated);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJedi(@PathVariable("id") Long id) throws JediNotFoundException {
        service.delete(id);
    }


}
