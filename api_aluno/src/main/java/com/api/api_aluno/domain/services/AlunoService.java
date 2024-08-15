package com.api.api_aluno.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.api_aluno.Entity.Aluno;
import com.api.api_aluno.Repository.AlunoRepository;
import com.api.api_aluno.domain.dto.AlunoDto;
import com.api.api_aluno.domain.dto.ResponseDto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Service
@AllArgsConstructor
public class AlunoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    @Autowired 
    private AlunoRepository alunoRepository;
   
    @SuppressWarnings("null")
    public Aluno saveAluno(@Valid @RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

    @SuppressWarnings("null")
    public List<AlunoDto> getAllAluno() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                     .map(aluno -> modelMapper.map(aluno, AlunoDto.class))
                     .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    public Aluno getAlunoByMatricula(@PathVariable Long matricula) {
        return alunoRepository.findById(matricula).orElse(null);
    }

    @SuppressWarnings("null")
    public Aluno updateAluno(Long matricula, Aluno newAluno) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(matricula);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNome(newAluno.getNome());
            aluno.setEmail(newAluno.getEmail());
            aluno.setIdade(newAluno.getIdade());
            return alunoRepository.save(aluno);
        } else {
            throw new RuntimeException("Aluno não encontrado com o ID: " + matricula);
        }
    }

    @SuppressWarnings("null")
    public ResponseDto deleteAluno(@PathVariable Long matricula) {
        if (matricula >= 0) {
            alunoRepository.deleteById(matricula);
        }

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Aluno deletado com sucesso");

        return responseDto;
    }
}
