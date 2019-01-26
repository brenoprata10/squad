package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Agencia;
import br.com.cabal.squardsippe.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}
