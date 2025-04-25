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
    ExercicioRepository exercicioRepository;

    public ExercicioDTO criar(ExercicioDTO exercicioDTO){
        Exercicio exercicio = new Exercicio();

        exercicio.setNome(exercicioDTO.getNome()); // setá com o que vem do DTO
        exercicio.setImagem(exercicioDTO.getImagem()); // setá com o que vem do DTO
        exercicio.setSeries(exercicioDTO.getSeries()); // setá com o que vem do DTO
        exercicio.setRepeticoes(exercicioDTO.getRepeticoes()); // setá com o que vem do DTO

        exercicio = exercicioRepository.save(exercicio); // pega tudo que foi salvo nele e mete no banco

        return new ExercicioDTO(exercicio); // só pra retornar no postman

    }
    public ExercicioDTO salvar(Long id, ExercicioDTO exercicioDTO){
        Exercicio exercicio = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));

        // Atualiza os dados existentes
        exercicio.setNome(exercicioDTO.getNome());
        exercicio.setImagem(exercicioDTO.getImagem());
        exercicio.setSeries(exercicioDTO.getSeries());
        exercicio.setRepeticoes(exercicioDTO.getRepeticoes());

        // Salva as atualizações
        exercicio = exercicioRepository.save(exercicio);

        return new ExercicioDTO(exercicio);
    }




    public List<Exercicio> listar(){
        List<Exercicio> exercicios = exercicioRepository.findAll();
        return exercicios;
    }



}