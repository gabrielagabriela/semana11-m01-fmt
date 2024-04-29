package com.semana11.modulo1.semana11modulo1.controller;

import com.semana11.modulo1.semana11modulo1.entity.Caderno;
import com.semana11.modulo1.semana11modulo1.service.CadernoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadernos")
public class CadernoController {

    private final CadernoService cadernoService;

    @Autowired
    public CadernoController(CadernoService cadernoService) {
        this.cadernoService = cadernoService;
    }

    @PostMapping
    public ResponseEntity<Caderno> criarCaderno(@RequestBody Caderno caderno) {
        Caderno novoCaderno = cadernoService.salvar(caderno);
        return ResponseEntity.ok(novoCaderno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caderno> buscarCadernoPorId(@PathVariable Long id) {
        Caderno caderno = cadernoService.buscaId(id);
        return ResponseEntity.ok(caderno);
    }

    @GetMapping
    public ResponseEntity<List<Caderno>> buscarTodosCadernos() {
        List<Caderno> cadernos = cadernoService.buscaTodos();
        return ResponseEntity.ok(cadernos);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Caderno> atualizarCaderno(@PathVariable Long id, @RequestBody Caderno cadernoAtualizado) {
        cadernoAtualizado.setId(id);
        Caderno caderno = cadernoService.atualizar(cadernoAtualizado);
        return ResponseEntity.ok(caderno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaderno(@PathVariable Long id) {
        cadernoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
