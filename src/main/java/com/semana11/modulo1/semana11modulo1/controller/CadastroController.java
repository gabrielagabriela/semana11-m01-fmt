package com.semana11.modulo1.semana11modulo1.controller;

import com.semana11.modulo1.semana11modulo1.entity.Usuario;
import com.semana11.modulo1.semana11modulo1.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CadastroController {
    private final UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> novoUsuario(
            @Validated @RequestBody Usuario inserirUsuario
    ) {

        usuarioService.cadastraNovoUsuario(inserirUsuario);

        return ResponseEntity.ok("Usuario Salvo!");
    }

}