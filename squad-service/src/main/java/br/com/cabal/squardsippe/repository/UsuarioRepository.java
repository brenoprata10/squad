package br.com.cabal.squardsippe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cabal.squardsippe.model.Usuario;
import br.com.cabal.squardsippe.model.dto.UsuarioDTO;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "new br.com.cabal.squardsippe.model.dto.UsuarioDTO(id,nome,cpf,email) from Usuario")
	List<UsuarioDTO> listar();

	@Query(value = "new br.com.cabal.squardsippe.model.dto.UsuarioDTO(id,nome,cpf,email) u from Usuario where u.id =:id")
	UsuarioDTO buscarPorId(@Param("id") Long id);

}
