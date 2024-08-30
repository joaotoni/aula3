package org.example;

import org.example.dao.AlunoDAO;
import org.example.model.Aluno;
import org.example.model.Cursos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
//        aluno.setCursos(Cursos.ADS);
//        aluno.setMaioridade(true);
//        aluno.setNome("Rapaz Doido");
//        aluno.setSexo("Masculino");
//
//        AlunoDAO dao = new AlunoDAO();
//        dao.create(aluno);
        aluno.setSexo("Feminino");
        aluno.setNome("Rapaz Doido");
    }
}