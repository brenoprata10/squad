package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Banco;
import br.com.cabal.squardsippe.model.dto.BancoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
    @Query("SELECT new br.com.cabal.squardsippe.model.dto.BancoDTO(cod_banco, nome) FROM tb_banco")
    List<BancoDTO> buscarTodos();
}
