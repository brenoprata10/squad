package br.com.cabal.squardsippe.controller;

import br.com.cabal.squardsippe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario/")
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
