package com.sprint.treino.services;

import com.sprint.treino.dtos.ExercicioDTO;
import com.sprint.treino.entities.Exercicio;
import com.sprint.treino.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    public ExercicioDTO criar(ExercicioDTO dto) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNome(dto.getNome());
        exercicio.setImagem(dto.getImagem());
        exercicio.setSeries(dto.getSeries());
        exercicio.setRepeticoes(dto.getRepeticoes());
        return new ExercicioDTO(exercicioRepository.save(exercicio));
    }

    public ExercicioDTO salvar(Long id, ExercicioDTO dto) {
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
        exercicio.setNome(dto.getNome());
        exercicio.setImagem(dto.getImagem());
        exercicio.setSeries(dto.getSeries());
        exercicio.setRepeticoes(dto.getRepeticoes());
        return new ExercicioDTO(exercicioRepository.save(exercicio));
    }

    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }

    public ExercicioDTO listar(Long id) {
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado com ID: " + id));
        return new ExercicioDTO(exercicio);
    }

    public void excluir(Long id) {
        if (!exercicioRepository.existsById(id)) {
            throw new RuntimeException("Exercício não encontrado");
        }
        exercicioRepository.deleteById(id);
    }
}
