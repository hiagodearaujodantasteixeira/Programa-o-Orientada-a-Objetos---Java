/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Venda;
import model.Veiculo;
import model.Funcionario;
import model.Cliente;
import java.sql.*;
/**
 *
 * @author hiago
 */

public class Concessionaria implements OperacoesConcessionaria{
    
    @Override
    public boolean cadastrarCliente(String nome, String telefone, String email, String rg, String cpf) {
        String sql = "INSERT INTO cliente(nome, telefone, email, rg, cpf) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, nome);
            pstmt.setString(2, telefone);
            pstmt.setString(3, email);
            pstmt.setString(4, rg);
            pstmt.setString(5, cpf);

            pstmt.executeUpdate(); 
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public Cliente consultarCliente(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?"; 
        Cliente cliente = null;

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cpf);
            java.sql.ResultSet rs = pstmt.executeQuery(); 

            if (rs.next()) {
                cliente = new Cliente(
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("rg"),
                    rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return cliente;
    }
    
    @Override
    public void alterarCliente(String novoNome, String novoNumTelefone, String novoEmail, String cpf) {
        String sql = "UPDATE cliente SET nome = ?, telefone = ?, email = ? WHERE cpf = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, novoNome);
            pstmt.setString(2, novoNumTelefone);
            pstmt.setString(3, novoEmail);

            pstmt.setString(4, cpf);

            pstmt.executeUpdate();
            System.out.println("Cliente alterado com sucesso no Banco de Dados!");

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao alterar cliente: " + e.getMessage());
        }
    }
    
    @Override
    public void removerCliente(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cpf);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Cliente removido do Banco de Dados.");
            } else {
                System.out.println("Nenhum cliente encontrado com esse CPF.");
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }   
    
    @Override
    public String getRelatorioClientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- LISTA DE CLIENTES (DO BANCO DE DADOS) ---\n\n");

        String sql = "SELECT * FROM cliente";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = pstmt.executeQuery()) {

            if (!rs.isBeforeFirst()) { 
                 sb.append("Nenhum cliente cadastrado.");
            }

            while (rs.next()) {
                sb.append("Nome: ").append(rs.getString("nome")).append("\n");
                sb.append("CPF:  ").append(rs.getString("cpf")).append("\n");
                sb.append("Email: ").append(rs.getString("email")).append("\n");
                sb.append("Telefone: ").append(rs.getString("telefone")).append("\n");
                sb.append("RG: ").append(rs.getString("rg")).append("\n");
                sb.append("-------------------------\n");
            }

        } catch (java.sql.SQLException e) {
            sb.append("Erro ao gerar relatório: ").append(e.getMessage());
            System.out.println("Erro SQL: " + e.getMessage());
        }

        return sb.toString();
    }

    @Override
    public boolean cadastrarFuncionario(String nome, int numMatricula, String qualificacao, String descricaoFuncao, int cargaHoraria){
        String sql = "INSERT INTO funcionario(nome, numMatricula, qualificacao, descricaoFuncao, cargaHorariaSemanal) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, nome);
            pstmt.setInt(2, numMatricula);
            pstmt.setString(3, qualificacao);
            pstmt.setString(4, descricaoFuncao);
            pstmt.setInt(5, cargaHoraria);

            pstmt.executeUpdate(); 
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public Funcionario consultarFuncionario(int matricula) {
        String sql = "SELECT * FROM funcionario WHERE numMatricula = ?"; 
        Funcionario funcionario = null;

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, matricula);
            java.sql.ResultSet rs = pstmt.executeQuery(); 

            if (rs.next()) {
                funcionario = new Funcionario(
                    rs.getString("nome"),
                    rs.getInt("numMatricula"),
                    rs.getString("qualificacao"),
                    rs.getString("descricaoFuncao"),
                    rs.getInt("cargaHorariaSemanal")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return funcionario;
    }
    
    @Override
    public void alterarFuncionario(int matricula, String novoNome, String novaQualificacao, String novaDescricao, int novaCargaHorariaSemanal) {
        String sql = "UPDATE funcionario SET nome = ?, qualificacao = ?, descricaoFuncao = ?, cargaHorariaSemanal = ? WHERE numMatricula = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, novoNome);
            pstmt.setString(2, novaQualificacao);
            pstmt.setString(3, novaDescricao);
            pstmt.setInt(4, novaCargaHorariaSemanal);
            pstmt.setInt(5, matricula);

            pstmt.executeUpdate();
            System.out.println("Funcionário alterado com sucesso no Banco de Dados!");

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao alterar funcionário: " + e.getMessage());
        }
    }
    
    @Override
    public void removerFuncionario(int matricula) {
        String sql = "DELETE FROM funcionario WHERE numMatricula = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, matricula);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Funcionário removido do Banco de Dados.");
            } else {
                System.out.println("Nenhum funcionário encontrado com essa matrícula.");
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao remover funcionário: " + e.getMessage());
        } 
    }
    
    @Override
    public String getRelatorioFuncionarios() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- LISTA DE FUNCIONÁRIOS (DO BANCO DE DADOS) ---\n\n");

        String sql = "SELECT * FROM funcionario";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = pstmt.executeQuery()) {

            if (!rs.isBeforeFirst()) { 
                 sb.append("Nenhum funcionário cadastrado.");
            }

            while (rs.next()) {
                sb.append("Nome: ").append(rs.getString("nome")).append("\n");
                sb.append("Matrícula:  ").append(rs.getInt("numMatricula")).append("\n");
                sb.append("Qualificação: ").append(rs.getString("qualificacao")).append("\n");
                sb.append("Descrição da Função: ").append(rs.getString("descricaoFuncao")).append("\n");
                sb.append("Carga Horária Semanal: ").append(rs.getInt("cargaHorariaSemanal")).append("\n");
                sb.append("-------------------------\n");
            }

        } catch (java.sql.SQLException e) {
            sb.append("Erro ao gerar relatório: ").append(e.getMessage());
            System.out.println("Erro SQL: " + e.getMessage());
        }

        return sb.toString();
    }
    
    @Override
    public boolean cadastrarVeiculo(String nomeVeiculo, String corVeiculo, int numMarchaVeiculo, int numPortaVeiculo, String marcaVeiculo, String anoFabricacaoVeiculo){
        String sql = "INSERT INTO veiculo(nome, cor, numMarcha, numPortas, marca, anoFabricacao) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) { 
            
            pstmt.setString(1, nomeVeiculo);
            pstmt.setString(2, corVeiculo);
            pstmt.setInt(3, numMarchaVeiculo);
            pstmt.setInt(4, numPortaVeiculo);
            pstmt.setString(5, marcaVeiculo);
            pstmt.setString(6, anoFabricacaoVeiculo);

            pstmt.executeUpdate(); 
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public Veiculo consultarVeiculo(int id) {
        String sql = "SELECT * FROM veiculo WHERE id = ?"; 
        Veiculo veiculo = null;

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            java.sql.ResultSet rs = pstmt.executeQuery(); 

            if (rs.next()) {
                veiculo = new Veiculo(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cor"),
                    rs.getInt("numMarcha"),
                    rs.getInt("numPortas"),
                    rs.getString("marca"),
                    rs.getString("anoFabricacao")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return veiculo;
    }
    
    @Override
    public void alterarVeiculo(int id, String novoNome, String novaCor, int novaNumMarchas, int novoNumPortas, String novaMarca, String novoAnoFabricacao) {
        String sql = "UPDATE veiculo SET nome = ?, cor = ?, numMarcha = ?, numPortas = ?, marca = ?, anoFabricacao = ? WHERE id = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, novoNome);
            pstmt.setString(2, novaCor);
            pstmt.setInt(3, novaNumMarchas);
            pstmt.setInt(4, novoNumPortas); 
            pstmt.setString(5, novaMarca);
            pstmt.setString(6, novoAnoFabricacao);

            pstmt.setInt(7, id);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Veículo alterado com sucesso no Banco de Dados!");
            } else {
                System.out.println("Erro: Veículo não encontrado para alteração.");
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao alterar veículo: " + e.getMessage());
        }
    }
    
    @Override
    public void removerVeiculo(int id) {
        String sql = "DELETE FROM veiculo WHERE id = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Veículo removido do Banco de Dados.");
            } else {
                System.out.println("Nenhum veículo encontrado com esse id.");
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        } 
    }
    
    @Override
    public String getRelatorioVeiculos() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- LISTA DE VEÍCULOS (DO BANCO DE DADOS) ---\n\n");

        String sql = "SELECT * FROM veiculo";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = pstmt.executeQuery()) {

            if (!rs.isBeforeFirst()) { 
                 sb.append("Nenhum veículo cadastrado.");
            }

            while (rs.next()) {
                sb.append("id: ").append(rs.getInt("id")).append("\n");
                sb.append("Nome:  ").append(rs.getString("nome")).append("\n");
                sb.append("Cor: ").append(rs.getString("cor")).append("\n");
                sb.append("Número de marchas: ").append(rs.getInt("numMarcha")).append("\n");
                sb.append("Número de portas: ").append(rs.getInt("numPortas")).append("\n");
                sb.append("Marca: ").append(rs.getString("marca")).append("\n");
                sb.append("Ano de Fabricação: ").append(rs.getString("anoFabricacao")).append("\n");
                sb.append("-------------------------\n");
            }

        } catch (java.sql.SQLException e) {
            sb.append("Erro ao gerar relatório: ").append(e.getMessage());
            System.out.println("Erro SQL: " + e.getMessage());
        }

        return sb.toString();
    }
    
    @Override
    public boolean cadastrarVenda(String data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo){
        String sql = "INSERT INTO venda(data, valor, cliente, funcionario, veiculo) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) { 

            pstmt.setString(1, data);
            pstmt.setDouble(2, valor);
            pstmt.setString(3, cliente.getCpf());
            pstmt.setInt(4, funcionario.getNumMatricula());
            pstmt.setInt(5, veiculo.getId());

            pstmt.executeUpdate(); 
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public Venda consultarVenda(int id) {
        String sql = "SELECT * FROM venda WHERE id = ?"; 
        Venda venda = null;

        try (Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            java.sql.ResultSet rs = pstmt.executeQuery(); 

            if (rs.next()) {
                
                String data = rs.getString("data");
                double valor = rs.getDouble("valor");
                
                String cpfCliente = rs.getString("cliente");
                int matriculaFunc = rs.getInt("funcionario");
                int idVeiculo = rs.getInt("veiculo");
                
                Cliente objCliente = this.consultarCliente(cpfCliente);
                Funcionario objFunc = this.consultarFuncionario(matriculaFunc);
                Veiculo objVeiculo = this.consultarVeiculo(idVeiculo);
                
                if (objCliente != null && objFunc != null && objVeiculo != null) {
                venda = new Venda(id, data, valor, objCliente, objFunc, objVeiculo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        return venda;
    }

    @Override
    public void alterarVenda(int id, String novaData, double novoValor, Cliente novoCliente, Funcionario novoFuncionario, Veiculo novoVeiculo) {
        String sql = "UPDATE venda SET data = ?, valor = ?, cliente = ?, funcionario = ?, veiculo = ? WHERE id = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, novaData);
            pstmt.setDouble(2, novoValor);
            pstmt.setString(3, novoCliente.getCpf());
            pstmt.setInt(4, novoFuncionario.getNumMatricula());
            pstmt.setInt(5, novoVeiculo.getId());
            pstmt.setInt(6, id);

            pstmt.executeUpdate();
            System.out.println("Venda alterada com sucesso no Banco de Dados!");

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao alterar venda: " + e.getMessage());
        }
    }

    @Override
    public void removerVenda(int id) {
        String sql = "DELETE FROM venda WHERE id = ?";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Venda removida do Banco de Dados.");
            } else {
                System.out.println("Nenhuma venda encontrada com esse id.");
            }

        } catch (java.sql.SQLException e) {
            System.out.println("Erro ao remover venda: " + e.getMessage());
        } 
    }
    
    @Override
    public String getRelatorioVendas() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- LISTA DE VENDAS (DO BANCO DE DADOS) ---\n\n");

        String sql = "SELECT * FROM venda";

        try (java.sql.Connection conn = ConexaoBD.conectar();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = pstmt.executeQuery()) {

            if (!rs.isBeforeFirst()) { 
                 sb.append("Nenhuma venda cadastrada.");
            }

            while (rs.next()) {
                sb.append("ID Venda: ").append(rs.getInt("id")).append("\n");
                sb.append("Data:     ").append(rs.getString("data")).append("\n");
                sb.append("Valor:R$ ").append(rs.getDouble("valor")).append("\n");

               
                String cpfDoCliente = rs.getString("cliente"); 
                int matriculaFunc = rs.getInt("funcionario");
                int idVeiculo = rs.getInt("veiculo");

                Cliente c = consultarCliente(cpfDoCliente);
                Funcionario f = consultarFuncionario(matriculaFunc);
                Veiculo v = consultarVeiculo(idVeiculo);

                if (c != null) sb.append("Cliente:  ").append(c.getNome()).append("\n");
                else sb.append("Cliente:  [Não encontrado - CPF: ").append(cpfDoCliente).append("]\n");

                if (f != null) sb.append("Func.:    ").append(f.getNome()).append("\n");
                if (v != null) sb.append("Veículo:  ").append(v.getNome()).append("\n");

                sb.append("-------------------------\n");
            }

        } catch (java.sql.SQLException e) {
            sb.append("Erro: ").append(e.getMessage());
            System.out.println("Erro SQL: " + e.getMessage());
        }
        return sb.toString();
    }
}