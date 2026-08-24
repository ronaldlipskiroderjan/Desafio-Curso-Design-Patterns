package br.com.Ronald.DesingPatternsProject.service.impl;

import br.com.Ronald.DesingPatternsProject.Exception.AlreadyExistsException;
import br.com.Ronald.DesingPatternsProject.Exception.NotFoundException;
import br.com.Ronald.DesingPatternsProject.database.model.EmpresaEntity;
import br.com.Ronald.DesingPatternsProject.database.model.SituacaoCadastral;
import br.com.Ronald.DesingPatternsProject.database.repository.EmpresaRepository;
import br.com.Ronald.DesingPatternsProject.dtos.Request.EmpresaRequestDTO;
import br.com.Ronald.DesingPatternsProject.dtos.Response.EmpresaBrasilApiResponseDTO;
import br.com.Ronald.DesingPatternsProject.dtos.Response.EmpresaResponseDTO;
import br.com.Ronald.DesingPatternsProject.service.BrasilApiCliente;
import br.com.Ronald.DesingPatternsProject.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final BrasilApiCliente brasilApiCliente;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, BrasilApiCliente brasilApiCliente) {
        this.empresaRepository = empresaRepository;
        this.brasilApiCliente = brasilApiCliente;
    }

    @Override
    public List<EmpresaResponseDTO> findAll( ) {
        return empresaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public EmpresaResponseDTO findByCnpj(String cnpj) throws Exception {
        return empresaRepository.findByCnpj(cnpj).map(this::toDTO)
                .orElseThrow(() -> new NotFoundException("Empresa não encontrada!"));
    }

    @Override
    public void inserir(EmpresaRequestDTO dto) throws Exception {
        if (empresaRepository.existsByCnpj(dto.cnpj())) {
           throw new AlreadyExistsException("Empresa já cadastrada no sistema...");
        }
        EmpresaBrasilApiResponseDTO empresaDTO = brasilApiCliente.buscarEmpresaPorCnpj(dto.cnpj().replaceAll("[^0-9A-Za-z]", ""));
        empresaRepository.save(EmpresaEntity.builder()
                    .cnpj(empresaDTO.cnpj())
                    .razaoSocial(empresaDTO.razaoSocial())
                    .nomeFantasia(empresaDTO.nomeFantasia())
                    .municipio(empresaDTO.municipio())
                    .uf(empresaDTO.uf())
                    .situacaoCadastral(empresaDTO.situacaoCadastral())
                    .tipoRelacionamento(dto.tipoRelacionamento())
                .build()
        );
    }

    @Override
    public void updateTipoRelacionamento(EmpresaRequestDTO dto) throws Exception {
        EmpresaEntity empresa = empresaRepository.findByCnpj(dto.cnpj())
                .orElseThrow(() -> new NotFoundException("Empresa não cadastrada no sistema..."));
        empresa.setTipoRelacionamento(dto.tipoRelacionamento());
        empresaRepository.save(empresa);
    }

    @Override
    public void delete(String cnpj) throws Exception {
       EmpresaEntity empresa = empresaRepository.findByCnpj(cnpj)
               .orElseThrow(() -> new NotFoundException("Empresa não cadastrada no sistema..."));
       empresaRepository.delete(empresa);
    }

    private EmpresaResponseDTO toDTO(EmpresaEntity e) {
        return new EmpresaResponseDTO(
                e.getCnpj(),
                e.getRazaoSocial(),
                e.getNomeFantasia(),
                e.getMunicipio(),
                e.getUf(),
                e.getSituacaoCadastral(),
                e.getTipoRelacionamento()
        );
    }
}
