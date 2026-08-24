package br.com.Ronald.DesingPatternsProject.dtos.Request;

import br.com.Ronald.DesingPatternsProject.database.model.TipoRelacionamento;

public record EmpresaRequestDTO(
        String cnpj,
        TipoRelacionamento tipoRelacionamento
) {
}
