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
    public ResponseEntity<Caderno> criarCaderno( @RequestHeader(name = "Authorization") String token ,@RequestBody Caderno caderno) {
        Caderno novoCaderno = cadernoService.salvar(token.substring(7), caderno);
        return ResponseEntity.ok(novoCaderno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caderno> buscarCadernoPorId(@RequestHeader(name = "Authorization") String token ,@PathVariable Long id) {
        Caderno caderno = cadernoService.buscaId(token.substring(7), id);
        return ResponseEntity.ok(caderno);
    }

    @GetMapping
    public ResponseEntity<List<Caderno>> buscarTodosCadernos(@RequestHeader(name = "Authorization") String token) {
        List<Caderno> cadernos = cadernoService.buscaTodos(token.substring(7));
        return ResponseEntity.ok(cadernos);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Caderno> atualizarCaderno(@RequestHeader(name = "Authorization") String token , @PathVariable Long id, @RequestBody Caderno cadernoAtualizado) {
        cadernoAtualizado.setId(id);
        Caderno caderno = cadernoService.atualizar(token.substring(7),cadernoAtualizado);
        return ResponseEntity.ok(caderno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaderno(@RequestHeader(name = "Authorization") String token , @PathVariable Long id) {
        cadernoService.deletar(token.substring(7),id);
        return ResponseEntity.noContent().build();
    }
}
