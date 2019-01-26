package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.model.dto.UsuarioDTO;
import br.com.cabal.squardsippe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("usuario/api")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;
//
//    @GetMapping
//    public List<UsuarioDTO> listar() {
//        return ;
//    }


//    public UsuarioDTO save()
}
