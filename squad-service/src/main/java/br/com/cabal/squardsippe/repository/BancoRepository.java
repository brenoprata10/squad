package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Banco;
import br.com.cabal.squardsippe.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
}
