package org.example.util;

import org.example.model.Aluno;

import java.util.List;

public class Funcoes {
    public Funcoes(){}
    public static void print(Aluno aluno) {
        System.err.println("Nome: " + aluno.getNome());
        System.err.println("Matricula: " + aluno.getMatricula());
        System.err.println("Curso: " + aluno.getCursos());
        System.err.println(aluno.isMaioridade()?"Maior idade":"Menor idade");
        System.err.println("Sexo: " + aluno.getSexo());
        System.out.println("=====================================================");
    }

    public static void printList(List<Aluno> lista) {
        for (Aluno aluno : lista){
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Curso: " + aluno.getCursos());
            System.out.println(aluno.isMaioridade() ? "Maior idade" : "Menor idade");
            System.out.println("Sexo: " + aluno.getSexo());
            System.out.println("=====================================================");
        }
    }
}