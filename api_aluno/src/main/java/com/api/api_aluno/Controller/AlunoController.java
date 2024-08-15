package com.api.api_aluno.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.api_aluno.Entity.Aluno;
import com.api.api_aluno.Repository.AlunoRepository;
import com.api.api_aluno.domain.dto.AlunoDto;
import com.api.api_aluno.domain.dto.ResponseDto;
import com.api.api_aluno.domain.services.AlunoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;
    @Autowired
    AlunoService alunoService;


    @PostMapping(value = "inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno saveAluno(@Valid @RequestBody Aluno aluno) {
        return alunoService.saveAluno(aluno);
    }

    @GetMapping(value = "listar")
    public List<AlunoDto> getAllAluno() {
        return alunoService.getAllAluno();
    }

    @GetMapping("/obter/{matricula}")
    public Aluno getAlunoByMatricula(@PathVariable Long matricula) {
        return alunoService.getAlunoByMatricula(matricula);
    }

    @PutMapping(value = "alterar")
    public Aluno updateAluno(@RequestParam Long matricula, @RequestBody Aluno newAluno) {
        return alunoService.updateAluno(matricula, newAluno);
    }

    @DeleteMapping("/deletar/{matricula}")
    public ResponseDto deleteAluno(@PathVariable Long matricula) {
        return alunoService.deleteAluno(matricula);
    }
}