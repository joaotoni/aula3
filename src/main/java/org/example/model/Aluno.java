package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {
    Long matricula;
    String nome;
    boolean maioridade;
    Cursos cursos;
    String sexo;
}
