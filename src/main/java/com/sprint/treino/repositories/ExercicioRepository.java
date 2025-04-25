package com.sprint.treino.repositories;

import com.sprint.treino.entities.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}
