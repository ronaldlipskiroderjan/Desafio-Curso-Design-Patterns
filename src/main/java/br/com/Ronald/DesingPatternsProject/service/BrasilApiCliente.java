package br.com.Ronald.DesingPatternsProject.service;

import br.com.Ronald.DesingPatternsProject.dtos.Response.EmpresaBrasilApiResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "brasiApi",
        url = "https://brasilapi.com.br/api"
)
public interface BrasilApiCliente {

    @GetMapping("/cnpj/v1/{cnpj}")
    EmpresaBrasilApiResponseDTO buscarEmpresaPorCnpj(@PathVariable("cnpj") String cnpj);
}
