package com.api.api_user.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    Long numeroRequisicao;
    String nomeSolicitante;
    String nomeSistema;
    Date data;
    String descricaoRequisicao;
    Integer statusRequisicao;
    String anexo;
    Date dataFechamento;
}
