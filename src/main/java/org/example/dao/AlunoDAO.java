package org.example.dao;

import org.example.config.ConnectionFactory;
import org.example.model.Aluno;
import org.example.model.Cursos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AlunoDAO implements IAlunoDAO{
    @Override
    public Aluno create(Aluno aluno) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "INSERT into Aluno " +
                    "(nome, telefone, maioridade, curso, sexo)" +
                    "values (?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setBoolean(3, aluno.isMaioridade());
            preparedStatement.setString(4, aluno.getCursos().toString());
            preparedStatement.setString(5, aluno.getSexo());
            preparedStatement.executeUpdate();

            // recuperando o ID
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                aluno.setMatricula(resultSet.getLong("matricula"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setMaioridade(resultSet.getBoolean("maioridade"));
                aluno.setSexo(resultSet.getString("sexo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aluno;
    }

    @Override
    public void update(Aluno aluno) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "UPDATE Aluno SET " +
                    "nome = ?, telefone = ?, maioridade = ?, curso = ?, sexo = ? " +
                    "WHERE matricula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setBoolean(3, aluno.isMaioridade());
            preparedStatement.setString(5, aluno.getSexo());
            preparedStatement.setLong(6, aluno.getMatricula());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Aluno aluno) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String query = "DELETE FROM Aluno " +
                    "WHERE matricula = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, aluno.getMatricula());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Aluno> findById(Long id) {
        Aluno aluno = new Aluno();
        String query = "SELECT * FROM alunos WHERE matricula = ?";
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            aluno.setMatricula(resultSet.getLong("matricula"));
            aluno.setNome(resultSet.getString("nome"));
            aluno.setMaioridade(resultSet.getBoolean("maioridade"));
            aluno.setCursos(Cursos.valueOf(resultSet.getString("curso")));
            aluno.setSexo(resultSet.getString("sexo"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(aluno);
    }

    @Override
    public List<Aluno> findAll() {
        List<Aluno> Aluno = new ArrayList<>();
        String query = "SELECT * FROM alunos";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(resultSet.getLong("matricula"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setMaioridade(resultSet.getBoolean("maioridade"));
                aluno.setCursos(Cursos.valueOf(resultSet.getString("curso")));
                aluno.setSexo(resultSet.getString("sexo"));
                Aluno.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Aluno;
    }

    @Override
    public List<Aluno> findByCurso(Cursos curso) {
        List<Aluno> Aluno = new ArrayList<>();
        String query = "SELECT * FROM alunos WHERE curso = ?";

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(curso));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(resultSet.getLong("matricula"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setMaioridade(resultSet.getBoolean("maioridade"));
                aluno.setCursos(Cursos.valueOf(resultSet.getString("curso")));
                aluno.setSexo(resultSet.getString("sexo"));
                Aluno.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Aluno;
    }
}