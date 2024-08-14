package com.api.api_user.domain.repository;

import com.api.api_user.domain.entity.Request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

public interface RequestRepository extends JpaRepository<Request,Long>{

    @Query("SELECT r FROM Request r WHERE r.numeroRequisicao = :numeroRequisicao")
    Request findRequestById(Long numeroRequisicao);

}