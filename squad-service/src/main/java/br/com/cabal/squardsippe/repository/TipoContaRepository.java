package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.TipoConta;
import br.com.cabal.squardsippe.model.dto.TipoContaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {

    @Query("SELECT new br.com.cabal.squardsippe.model.dto.TipoContaDTO(tc.id, tc.descricao) FROM TipoConta tc ")
    List<TipoContaDTO> buscarTodos();
}
