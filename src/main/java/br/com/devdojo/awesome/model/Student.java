package br.com.devdojo.awesome.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

@Entity
public class Student extends AbstractyEntity{

    @NotEmpty(message = "O campo nome do Estudante é Obrigatório") //Hibernate Validator para criar regras
    private String name;

    @NotEmpty
    @Email(message = "Informe um e-mail válido")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() { 
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
