package br.com.Ronald.DesingPatternsProject.dtos.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmpresaBrasilApiResponseDTO(

        String cnpj,

        @JsonProperty("razao_social")
        String razaoSocial,

        @JsonProperty("nome_fantasia")
        String nomeFantasia,

        @JsonProperty("descricao_situacao_cadastral")
        String situacaoCadastral,

        String cep,

        @JsonProperty("descricao_tipo_logradouro")
        String tipoLogradouro,

        String logradouro,

        String numero,

        String complemento,

        String bairro,

        String municipio,

        String uf,

        @JsonProperty("ddd_telefone_1")
        String telefone,

        String email

) {
}
