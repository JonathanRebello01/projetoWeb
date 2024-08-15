package com.api.api_aluno.Entity;

import org.hibernate.validator.constraints.Length;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor


@Getter
@Setter
public class Aluno {

    @Column(name="matricula")
    @Id
    Long matricula;
   
    @Column(name="nome")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message="Nome com no máximo 50 caracteres",max=50)
    String nome;

    @Column(name="idade")
    int idade;

    @Column(name="email")
    @NotBlank(message = "E-mail é obrigatório")
    @Length(message="E-mail com no máximo 50 caracteres",max=50)
    String email;

    
}
