package com.semana11.modulo1.semana11modulo1.service;

import com.semana11.modulo1.semana11modulo1.entity.Caderno;
import com.semana11.modulo1.semana11modulo1.repository.CadernoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadernoService {

    private final CadernoRepository cadernoRepository;


    public Caderno salvar(String token, Caderno caderno){
        cadernoRepository.save(caderno);
        return caderno;
    }

    public Caderno buscaId(String token,Long id){
        Caderno caderno = cadernoRepository.findById(id).orElseThrow(() -> new RuntimeException(" caderno nao encontrado"));
        return caderno;
    }

    public List<Caderno> buscaTodos(String token){
        return cadernoRepository.findAll();
    }

    public Caderno atualizar(String token,Caderno caderno){
        if(caderno.getId() == null){
            throw new IllegalArgumentException("O ID do caderno não pode ser nulo para atualização.");
        }
        return cadernoRepository.save(caderno);
    }

    public void deletar(String token, Long id){
        Caderno caderno = buscaId(token, id);
        cadernoRepository.delete(caderno);
    }
}
