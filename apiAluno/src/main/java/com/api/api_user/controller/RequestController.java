package com.api.api_user.controller;

// import java.time.LocalDate;
// import java.time.ZoneId;
// import java.util.Date;
import java.util.List;

import com.api.api_user.domain.dto.RequestDto;
import com.api.api_user.domain.dto.ResponseDto;
import com.api.api_user.domain.entity.Request;
import com.api.api_user.domain.service.RequestService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class RequestController {

  @Autowired
  private RequestService requestService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseDto saveRequest(@Valid @RequestBody Request request) {
    return requestService.saveRequest(request);
  }

  @GetMapping(value = "/list")
  public List<RequestDto> getAllRequest() {
    return requestService.getAllRequest();
  }

  @GetMapping("/id")
  public RequestDto getRequestById(@RequestParam Long numeroRequisicao) {
    return requestService.getRequestById(numeroRequisicao); 
  }

}