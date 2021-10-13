package br.com.global.springwebmvc.services;

import br.com.global.springwebmvc.exception.JediNotFoundException;
import br.com.global.springwebmvc.model.Jedi;
import br.com.global.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    private JediRepository repository;

    public Iterable<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) throws JediNotFoundException {
        final Optional<Jedi> jedi = repository.findById(id);

        if(jedi.isEmpty()){
            throw new JediNotFoundException();
        }

        return jedi.get();

    }

    public Jedi save(final Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(Long id, Jedi jedi) throws JediNotFoundException {
        final Optional<Jedi> jediOptional = repository.findById(id);

        if(jediOptional.isEmpty()){
            throw new JediNotFoundException();
        }

        Jedi jediUpdated = jediOptional.get();

        jediUpdated.setName(jedi.getName());
        jediUpdated.setLastName(jedi.getLastName());

        return repository.save(jedi);

    }

    public void delete(Long id) throws JediNotFoundException {
        final Jedi jedi = this.findById(id);
        repository.delete(jedi);
    }

    public List<Jedi> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Jedi> findByLastName(String lastname) {
        return repository.findByLastName(lastname);
    }
}
