package com.semana11.modulo1.semana11modulo1.controller;

import com.semana11.modulo1.semana11modulo1.entity.Nota;
import com.semana11.modulo1.semana11modulo1.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    @Autowired
    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public ResponseEntity<Nota> criarNota(@RequestBody Nota nota) {
        Nota novoNota = notaService.salvar(nota);
        return ResponseEntity.ok(novoNota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> buscarNotaPorId(@PathVariable Long id) {
        Nota nota = notaService.buscaId(id);
        return ResponseEntity.ok(nota);
    }

    @GetMapping
    public ResponseEntity<List<Nota>> buscarTodosNotas() {
        List<Nota> notas = notaService.buscaTodos();
        return ResponseEntity.ok(notas);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Nota> atualizarNota(@PathVariable Long id, @RequestBody Nota notaAtualizado) {
        notaAtualizado.setId(id);
        Nota nota = notaService.atualizar(notaAtualizado);
        return ResponseEntity.ok(nota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNota(@PathVariable Long id) {
        notaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
