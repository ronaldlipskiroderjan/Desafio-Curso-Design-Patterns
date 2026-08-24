package br.com.Ronald.DesingPatternsProject.controller;

import br.com.Ronald.DesingPatternsProject.database.model.SituacaoCadastral;
import br.com.Ronald.DesingPatternsProject.dtos.Request.EmpresaRequestDTO;
import br.com.Ronald.DesingPatternsProject.dtos.Response.EmpresaResponseDTO;
import br.com.Ronald.DesingPatternsProject.service.impl.EmpresaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaServiceImpl empresaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmpresaResponseDTO> findAll() {
        return empresaService.findAll();
    }

    @GetMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.OK)
    public EmpresaResponseDTO findByCnpj(@PathVariable String cnpj) throws Exception {
        return empresaService.findByCnpj(cnpj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody EmpresaRequestDTO dto) throws Exception {
        empresaService.inserir(dto);
    }

    @PatchMapping("/tipoRelacionamento")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody EmpresaRequestDTO dto) throws Exception {
        empresaService.updateTipoRelacionamento(dto);
    }

    @DeleteMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterStatus(@PathVariable String cnpj) throws Exception {
        empresaService.delete(cnpj);
    }
}
