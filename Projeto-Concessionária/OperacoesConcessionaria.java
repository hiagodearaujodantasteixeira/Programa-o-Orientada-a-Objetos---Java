/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Venda;
import model.Veiculo;
import model.Funcionario;
import model.Cliente;

/**
 *
 * @author hiago
 */
interface OperacoesConcessionaria{
    
    boolean cadastrarCliente(String nome, String numTelefone, String emailPessoal, String rg, String cpf);
    Cliente consultarCliente(String cpf);
    void alterarCliente(String novoNome, String novoNumTelefone, String novoEmail, String cpf);
    void removerCliente(String cpf);
    String getRelatorioClientes();
    
    boolean cadastrarFuncionario(String nome, int matricula, String qualificacao, String descricao, int cargaHorariaSemanal);
    Funcionario consultarFuncionario(int matricula);
    void alterarFuncionario(int matricula, String novoNome, String novaQualificacao, String novaDescricao, int novaCargaHorariaSemanal);
    void removerFuncionario(int matricula);
    String getRelatorioFuncionarios();
    
    boolean cadastrarVeiculo(String nomeVeiculo, String corVeiculo, int numMarchaVeiculo, int numPortaVeiculo, String marcaVeiculo, String anoFabricacaoVeiculo);
    Veiculo consultarVeiculo(int id);
    void alterarVeiculo(int id, String novoNome, String novaCor, int novaNumMarchas, int novoNumPortas, String novaMarca, String novoAnoFabricacao);
    void removerVeiculo(int id);
    String getRelatorioVeiculos();
    
    boolean cadastrarVenda(String data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo);
    Venda consultarVenda(int id);
    void alterarVenda(int id, String novaData, double novoValor, Cliente novoCliente, Funcionario novoFuncionario, Veiculo novoVeiculo);
    void removerVenda(int id);
    String getRelatorioVendas();
    
}
