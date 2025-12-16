/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author hiago
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {

    private static final String URL = "jdbc:sqlite:concessionaria.db";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return conn;
    }

    public static void criarTabelas() {
        String sqlCliente = "CREATE TABLE IF NOT EXISTS cliente ("
                + "cpf TEXT PRIMARY KEY, "
                + "nome TEXT NOT NULL, "
                + "telefone TEXT, "
                + "email TEXT, "
                + "rg TEXT);";
        
        String sqlFuncionario = "CREATE TABLE IF NOT EXISTS funcionario ("
                + "numMatricula INTEGER PRIMARY KEY, "
                + "nome TEXT NOT NULL, "
                + "qualificacao TEXT, "
                + "descricaoFuncao TEXT, "
                + "cargaHorariaSemanal INTEGER);";
        
        String sqlVeiculo = "CREATE TABLE IF NOT EXISTS veiculo ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "cor TEXT, "
                + "numMarcha INTEGER, "
                + "numPortas INTEGER, "
                + "marca TEXT, "
                + "anoFabricacao TEXT);";
        
        String sqlVenda = "CREATE TABLE IF NOT EXISTS venda ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "data TEXT, "
                + "valor REAL NOT NULL, "
                + "cliente TEXT NOT NULL, "
                + "funcionario TEXT NOT NULL, "
                + "veiculo TEXT NOT NULL);";

        try (Connection conn = conectar();
            Statement stmt = conn.createStatement()) { 
            stmt.execute(sqlCliente); 
            stmt.execute(sqlFuncionario); 
            stmt.execute(sqlVeiculo); 
            stmt.execute(sqlVenda); 
            System.out.println("Tabelas criadas/verificadas com sucesso.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}