package com.mrcs.ecommerce.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController (UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/cadastra")
    public UsuarioModel cadastrarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/lista")
    public List<UsuarioModel> listarUsuarios (){
        return usuarioRepository.findAll();
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioAtualizado){
        Optional<UsuarioModel> optional = usuarioRepository.findById(id);

        if (usuarioRepository.existsById(id)) {

            usuarioAtualizado.setId(id);
            UsuarioModel salvo = usuarioRepository.save(usuarioAtualizado);
            return ResponseEntity.ok(salvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
