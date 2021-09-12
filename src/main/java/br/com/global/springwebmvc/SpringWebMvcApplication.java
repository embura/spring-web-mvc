package br.com.global.springwebmvc;

import br.com.global.springwebmvc.repository.JediRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebMvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringWebMvcApplication.class, args);
	}

}
