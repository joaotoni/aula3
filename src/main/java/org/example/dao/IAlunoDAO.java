package org.example.dao;

import org.example.model.Aluno;

import java.util.List;

public interface IAlunoDAO {
    Aluno create (Aluno aluno);

    Aluno update(Aluno aluno);
    void delete(Aluno aluno);
    Aluno findById(int id);
    List<Aluno> findAll();

}
