package com.semana11.modulo1.semana11modulo1.service;

import com.semana11.modulo1.semana11modulo1.entity.Usuario;
import com.semana11.modulo1.semana11modulo1.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final BCryptPasswordEncoder bCryptEncoder;
    private final UsuarioRepository usuarioRepository;


    public void cadastraNovoUsuario(
            @RequestBody Usuario inserirUsuarioRequest
    ) {
        boolean usuarioExsite = usuarioRepository.findByNomeUsuario(inserirUsuarioRequest.getNomeUsuario()).isPresent();

        if (usuarioExsite) {
            throw new RuntimeException("Usuario já existe");
        }

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(inserirUsuarioRequest.getNomeUsuario());
        usuario.setSenha(
                bCryptEncoder.encode(inserirUsuarioRequest.getSenha()) // codificar a senha
        );

        usuarioRepository.save(usuario);
    }
}