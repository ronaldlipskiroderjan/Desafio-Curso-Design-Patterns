package br.com.Ronald.DesingPatternsProject.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaEntity {

    @Id
    private String cnpj;

    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    @Column(nullable = false)
    private String municipio;

    @Column(nullable = false)
    private String uf;

    @Column(name = "situacao_cadastral", nullable = false)
    private String situacaoCadastral;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_relacionamento", nullable = false)
    private TipoRelacionamento tipoRelacionamento;
}
