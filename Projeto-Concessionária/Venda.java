package model;

import model.Veiculo;
import model.Funcionario;
import model.Cliente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hiago
 */
public class Venda{
    private int id;
    private String data;
    private double valor;
    private Cliente cliente;
    private Funcionario funcionario;
    private Veiculo veiculo;

    public Venda(int id, String data, double valor, Cliente cliente, Funcionario funcionario, Veiculo veiculo) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public void exibeVenda(){
        System.out.println("--- Detalhes da Venda ---");
        System.out.println("Data: " + getData()); 
        System.out.println("Valor: " + getValor()); 
        System.out.println("Cliente: " + getCliente().getNome()); 
        System.out.println("Funcionário: " + getFuncionario().getNome());
        System.out.println("Veículo: " + getVeiculo().getNome());
        System.out.println("---------------------------");
}
}
