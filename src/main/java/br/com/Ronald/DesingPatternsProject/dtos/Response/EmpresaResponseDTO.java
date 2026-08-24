package br.com.Ronald.DesingPatternsProject.dtos.Response;

import br.com.Ronald.DesingPatternsProject.database.model.TipoRelacionamento;

public record EmpresaResponseDTO(
        String cnpj,
        String razaoSocial,
        String nomeFantasia,
        String municipio,
        String uf,
        String situacaoCadastral,
        TipoRelacionamento tipoRelacionamento
) {
}
