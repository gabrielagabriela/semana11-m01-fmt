package com.semana11.modulo1.semana11modulo1.service;

import com.semana11.modulo1.semana11modulo1.entity.Nota;
import com.semana11.modulo1.semana11modulo1.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;


    public Nota salvar(Nota nota){
        notaRepository.save(nota);
        return nota;
    }

    public Nota buscaId(Long id){
        Nota nota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException(" nota nao encontrado"));
        return nota;
    }

    public List<Nota> buscaTodos(){
        return notaRepository.findAll();
    }

    public Nota atualizar(Nota nota){
        if(nota.getId() == null){
            throw new IllegalArgumentException("O ID do nota não pode ser nulo para atualização.");
        }
        return notaRepository.save(nota);
    }

    public void deletar(Long id){
        Nota nota = buscaId(id);
        notaRepository.delete(nota);
    }
}
