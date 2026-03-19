package com.mrcs.ecommerce.Usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping("/teste")
    public String testando(){
        return "Oi, primeira rota!";
    }
}
