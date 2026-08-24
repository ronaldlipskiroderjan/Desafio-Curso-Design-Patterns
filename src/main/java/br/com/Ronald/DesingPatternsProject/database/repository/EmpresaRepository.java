package br.com.Ronald.DesingPatternsProject.database.repository;

import br.com.Ronald.DesingPatternsProject.database.model.EmpresaEntity;
import br.com.Ronald.DesingPatternsProject.database.model.SituacaoCadastral;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {
    List<EmpresaEntity> findBySituacaoCadastral(SituacaoCadastral situacaoCadastral);
    Optional<EmpresaEntity> findByCnpj(String cnpj);
    boolean existsByCnpj(String cnpj);
}
