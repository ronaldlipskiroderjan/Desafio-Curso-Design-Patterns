package br.com.Ronald.DesingPatternsProject.service;


import br.com.Ronald.DesingPatternsProject.database.model.SituacaoCadastral;
import br.com.Ronald.DesingPatternsProject.dtos.Request.EmpresaRequestDTO;
import br.com.Ronald.DesingPatternsProject.dtos.Response.EmpresaResponseDTO;

import java.util.List;

public interface EmpresaService {

    List<EmpresaResponseDTO> findAll();

    EmpresaResponseDTO findByCnpj(String cnpj) throws Exception;

    void inserir(EmpresaRequestDTO dto) throws Exception;

    void updateTipoRelacionamento(EmpresaRequestDTO dto) throws Exception;

    void delete(String cnpj) throws Exception;
}
