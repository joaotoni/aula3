package org.example.dao;

import org.example.config.ConnectionFactory;
import org.example.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class AlunoDAO implements IAlunoDAO{
    @Override
    public Aluno create (Aluno aluno){
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "INSERT into alunos " +
                    "(nome, maioridade, curso, sexo)" +
                    "values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setBoolean(2, aluno.isMaioridade());
            preparedStatement.setString(3, aluno.getCursos().toString());
            preparedStatement.setString(4, aluno.getSexo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Aluno update(Aluno aluno){
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "UPDATE into alunos " +
                    "(nome, maioridade, curso, sexo)" +
                    "values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setBoolean(2, aluno.isMaioridade());
            preparedStatement.setString(3, aluno.getCursos().toString());
            preparedStatement.setString(4, aluno.getSexo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(Aluno aluno) {

    }

    @Override
    public Aluno findById(int id) {
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        return List.of();
    }
}
