package com.Daniblue02.dao;

import com.Daniblue02.model.Revision;
import com.Daniblue02.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RevisionDao {

    private Connection connection;

    public RevisionDao() {
        connection = ConectorBD.getConection();
    }

    public void addRevision (Revision revision){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO revision (codigo, filtro, aceite, frenos, placa) VALUES (?, ?, ?, ?, ?)" );

            preparedStatement.setString(1, revision.getCodigo());
            preparedStatement.setString(2, revision.getFiltro());
            preparedStatement.setString(3, revision.getAceite());
            preparedStatement.setString(4, revision.getFrenos());
            preparedStatement.setString(5, revision.getPlaca());
            preparedStatement.executeUpdate();

            System.out.println(revision + " fue registrada!");
        } catch (SQLException e) {
            System.out.println("Error al registrar la revisión: " + e.getMessage());
        }
    }

    public void updateRevision(Revision revision){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE revision SET codigo=?, filtro=?, aceite=?, frenos=?, placa=? WHERE codigo=?");

            preparedStatement.setString(1, revision.getCodigo());
            preparedStatement.setString(2, revision.getFiltro());
            preparedStatement.setString(3, revision.getAceite());
            preparedStatement.setString(4, revision.getFrenos());
            preparedStatement.setString(5,revision.getPlaca());

            preparedStatement.setString(6, revision.getCodigo());
            preparedStatement.executeUpdate();

            System.out.println(revision + " fue editada!");
        } catch (SQLException e) {
            System.out.println("Error al editar la revisión : " + e.getMessage());
        }
    }

    public void deleteRevision(String codigo){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM revision WHERE codigo=?"
            );
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();

            System.out.println(codigo + " eliminada!");
        } catch (SQLException e) {
            System.out.println("Error al borrar la revisión: " + e.getMessage());
        }
    }

    public List<Revision> getAllRevisiones() {
        List<Revision> revisiones = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM revision");
            while (resultSet.next()) {
                Revision revision = new Revision();
                revision.setCodigo(resultSet.getString("codigo"));
                revision.setFiltro(resultSet.getString("filtro"));
                revision.setAceite(resultSet.getString("aceite"));
                revision.setFrenos(resultSet.getString("frenos"));
                revision.setPlaca(resultSet.getString("placa"));

                revisiones.add(revision);
            }
        } catch (SQLException e) {
            System.out.println("Error al Listar las revisiones: " + e.getMessage());
        }

        return revisiones;
    }
}
