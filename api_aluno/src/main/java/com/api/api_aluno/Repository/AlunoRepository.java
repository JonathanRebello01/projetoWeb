package com.api.api_aluno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.api_aluno.Entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
