package com.mrcs.ecommerce.Usuario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController (UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/teste")
    public String testando(){
        return "Oi, primeira rota!";
    }

    @PostMapping("/cadastro")
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }
}
