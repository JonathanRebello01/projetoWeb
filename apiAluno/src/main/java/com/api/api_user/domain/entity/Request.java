package com.api.api_user.domain.entity;

import java.sql.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_requisicao")
    Long numeroRequisicao;
    @Column(name="nome_solicitante")
    @NotBlank(message = "Nome é obrigatório")
    @Length(message="Nome com no máximo 100 caracteres",max=100)
    String nomeSolicitante;
    @Column(name="nome_sistema")
    @NotBlank(message = "Nome do sistema é obrigatório")
    @Length(message="Login com no máximo 100 caracteres",max=100)
    String nomeSistema;
    @Column(name = "data")
    @NotNull(message = "Data é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Manaus")
    Date data;
    @Column(name = "descricao_requisicao")
    @NotBlank(message = "Descreva sua requisição")
    @Length(message = "Limite 500 caracteres", max = 500)
    String descricaoRequisicao;
    @Column(name = "status_requisicao")
    @NotNull(message = "Status é obrigatório")
    Integer statusRequisicao;
    @Column(name = "anexo")
    @Length(max = 200)
    String anexo;
    @Column(name = "data_fechamento")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Manaus")
    Date dataFechamento;
}
