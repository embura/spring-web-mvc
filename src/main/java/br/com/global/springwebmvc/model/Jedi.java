package br.com.global.springwebmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;


@Entity
public class Jedi {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "[A-Za-z]{2,}", message="name is string with more than 2 characters ")
    private String name;

    @Pattern(regexp = "[A-Za-z ]{2,}", message="lastName is string with more than 2 characters ")
    private String lastName;

    public Jedi() {

    }

    public Long getId() {
        return id;
    }

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String toString(){
        return String.format("Jedi(name=%s, lastName=%s)", this.name, this.lastName);
    }
}
