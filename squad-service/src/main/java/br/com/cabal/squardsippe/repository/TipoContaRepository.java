package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {
}
