package org.example;

import org.example.dao.AlunoDAO;
import org.example.model.Aluno;
import org.example.model.Cursos;
import org.example.util.Funcoes;

import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno();
        /*
        aluno.setNome("Socorro de Deus");
        aluno.setSexo("feminino");
        aluno.setMaioridade(true);
        aluno.setTelefone("2345678");
        aluno.setCurso(Cursos.ADS);


        AlunoDAO dao = new AlunoDAO();
        dao.create(aluno);

        aluno.setNome("Amanda");
        aluno.setSexo("feminino");
        aluno.setMaioridade(true);
        aluno.setTelefone("555666777");
        aluno.setCurso(Cursos.ECMP);
        dao.create(aluno);
        */

        Optional<Aluno> a = dao.findById(3l);

        Funcoes.print(a.get());

        List<Aluno> alunos = dao.findAll();

        Funcoes.printList(alunos);
        /*
        aluno.setNome("Roberto Parametro");
        aluno.setSexo("masculino");
        aluno.setMaioridade(false);
        aluno.setTelefone("33344456");
        aluno.setCurso(Cursos.OUTROS);
        dao.create(aluno);

        Funcoes.print(aluno);
        */
        System.err.println("=== Find By Curso ===");
        alunos = dao.findByCurso(Cursos.ADS);
        Funcoes.printList(alunos);
    }
}