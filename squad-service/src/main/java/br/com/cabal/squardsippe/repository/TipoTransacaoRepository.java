package br.com.cabal.squardsippe.repository;


import br.com.cabal.squardsippe.model.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao, Long> {
}
