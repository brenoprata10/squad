package br.com.cabal.squardsippe.repository;

import br.com.cabal.squardsippe.model.Conta;
import br.com.cabal.squardsippe.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
