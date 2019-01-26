package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Conta;
import br.com.cabal.squardsippe.model.Usuario;
import br.com.cabal.squardsippe.model.dto.ContaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query("SELECT new br.com.cabal.squardsippe.model.dto.ContaDTO(cod_conta, numero_conta,saldo,ativa,dt_atualizacao,cod_usuario,cod_tipo_conta,cod_agencia) FROM tb_conta WHERE cod_usuario = ?")
    List<ContaDTO> findByIdUsuario(Long id);

    @Query("SELECT new br.com.cabal.squardsippe.model.dto.ContaDTO(cod_conta, numero_conta,saldo,ativa,dt_atualizacao,cod_usuario,cod_tipo_conta,cod_agencia) FROM tb_conta")
    List<ContaDTO> buscarTodos();
}
