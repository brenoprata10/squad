package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Agencia;
import br.com.cabal.squardsippe.model.dto.AgenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    @Query("SELECT new br.com.cabal.squardsippe.model.dto.AgenciaDTO(cod_agencia, numero) FROM tb_agencia")
    List<AgenciaDTO> buscarTodos();
}
