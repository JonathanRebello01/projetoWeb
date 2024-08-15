package com.api.api_aluno.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {
    private Long matricula;
    private String  nome;
    private int idade;
    private String email;
}
