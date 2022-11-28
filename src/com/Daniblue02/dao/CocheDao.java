package com.Daniblue02.dao;

import com.Daniblue02.model.Coche;
import com.Daniblue02.util.ConectorBD;
import com.Daniblue02.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CocheDao {
    private Connection connection;

    public CocheDao() {
        connection = ConectorBD.getConection();
    }

    public void addCoche (Coche coche){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO coche (placa, marca, modelo, color, precio, nif) VALUES (?, ?, ?, ?, ?, ?)" );

            preparedStatement.setString(1, coche.getPlaca());
            preparedStatement.setString(2, coche.getMarca());
            preparedStatement.setString(3, coche.getModelo());
            preparedStatement.setString(4, coche.getColor());
            preparedStatement.setDouble(5, coche.getPrecio());
            preparedStatement.setString(6, coche.getNif());
            preparedStatement.executeUpdate();

            System.out.println(coche + " fue creado!");
        } catch (SQLException e) {
            System.out.println("Error al crear el coche: " + e.getMessage());
        }
    }

    public void updateCoche(Coche coche){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE coche SET placa=?, marca=?, modelo=?, color=?, precio=?, nif=? WHERE placa=?");

            preparedStatement.setString(1, coche.getPlaca());
            preparedStatement.setString(2, coche.getMarca());
            preparedStatement.setString(3, coche.getModelo());
            preparedStatement.setString(4, coche.getColor());
            preparedStatement.setDouble(5,coche.getPrecio());
            preparedStatement.setString(6, coche.getNif());

            preparedStatement.setString(7, coche.getPlaca());
            preparedStatement.executeUpdate();

            System.out.println(coche + " fue editado!");
        } catch (SQLException e) {
            System.out.println("Error al editar el coche: " + e.getMessage());
        }
    }

    public void deleteCoche(String placa){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM coche WHERE placa=?"
            );
            preparedStatement.setString(1, placa);
            preparedStatement.executeUpdate();

            System.out.println(placa + " eliminado!");
        } catch (SQLException e) {
            System.out.println("Error al borrar el coche: " + e.getMessage());
        }
    }

    public List<Coche> getAllCoches() {
        List<Coche> coches = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM coche");
            while (resultSet.next()) {
                Coche coche = new Coche();
                coche.setPlaca(resultSet.getString("placa"));
                coche.setMarca(resultSet.getString("marca"));
                coche.setModelo(resultSet.getString("modelo"));
                coche.setColor(resultSet.getString("color"));
                coche.setPrecio(resultSet.getInt("precio"));
                coche.setNif(resultSet.getString("nif"));

                coches.add(coche);
            }
        } catch (SQLException e) {
            System.out.println("Error al Listar los coches: " + e.getMessage());
        }

        return coches;
    }
}
