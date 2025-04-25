package com.sprint.treino.dtos;

import com.sprint.treino.entities.Exercicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ExercicioDTO {

    private Long id;
    private String nome;
    private String imagem;
    private Integer series;
    private Integer repeticoes;

    public ExercicioDTO(Exercicio exercicio) {

    }


}
