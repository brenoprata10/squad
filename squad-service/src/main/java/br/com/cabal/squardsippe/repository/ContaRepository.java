package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query(value = "SELECT c FROM Conta c WHERE c.usuario.id = ?1")
    List<Conta> findByIdUsuario( Long id);

    @Query(value = "select c from Conta c where c.usuario.id = ?1 and c.id = ?2 and c.agencia.id = ?3")
    Conta buscarIdUsuarioAndContaAndAgencia(Long idUsuario, Long idConta, Long idAgencia);
}
