package com.sprint.treino.controllers;

import com.sprint.treino.dtos.ExercicioDTO;
import com.sprint.treino.entities.Exercicio;
import com.sprint.treino.services.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    // lista todos
    @GetMapping("/listar")
    public ResponseEntity<List<Exercicio>> listarTodos(){
        return ResponseEntity.ok(exercicioService.listarTodos());
    }

    // listar 1
    @GetMapping("/listar/{id}")
    public ResponseEntity<ExercicioDTO> listarUm(@PathVariable Long id) {
        return ResponseEntity.ok(exercicioService.listar(id));
    }

    // cria um novo
    @PostMapping("/criar")
    public ResponseEntity<String> criar (@Valid @RequestBody ExercicioDTO exercicioDTO){
        exercicioDTO = exercicioService.criar(exercicioDTO);
        return ResponseEntity.ok("Exercicio criado com sucesso!");
    }

    // atualiza o que já tem
    @PutMapping("salvar/{id}")
    public ResponseEntity<String> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ExercicioDTO exercicioDTO) {
        try {
            ExercicioDTO exercicioAtualizado = exercicioService.salvar(id, exercicioDTO);
            return ResponseEntity.ok("Exercicio atualizado com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // deleta
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletar (@PathVariable Long id){
        exercicioService.excluir(id);
        return ResponseEntity.ok("Exercicio deletado com sucesso!");
    }
}