package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Conta;
import br.com.cabal.squardsippe.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(value = "SELECT * FROM tb_conta WHERE cod_usuario = ?")
    List<Conta> findByIdUsuario(Long id);
}
