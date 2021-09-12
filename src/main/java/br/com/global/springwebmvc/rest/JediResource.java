package br.com.global.springwebmvc.rest;


import br.com.global.springwebmvc.model.Jedi;
import br.com.global.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JediResource {

    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public Iterable<Jedi> getAllJedi(){
        return repository.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public Jedi findById(@PathVariable("id")  Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/api/jedi/name/{name}")
    public List<Jedi> findByName(@PathVariable("name")  String name){
        return repository.findByName(name);
    }

    @GetMapping("/api/jedi/lastname/{lastname}")
    public List<Jedi> findByLastName(@PathVariable("lastname")  String lastname){
        return repository.findByLastName(lastname);
    }


}
