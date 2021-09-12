package br.com.global.springwebmvc.repository;


import br.com.global.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface JediRepository extends CrudRepository<Jedi, Long> {
    List<Jedi> findByName(@Param("name") String name);
    List<Jedi> findByLastName(@Param("lastName") String lastName);
}


