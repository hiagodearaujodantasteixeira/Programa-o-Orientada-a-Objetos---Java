/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hiago
 */
public class Veiculo {
    private int id;
    private String nome;
    private String cor;
    private int numMarchas;
    private int numPortas;
    private String marca;
    private String anoFabricacao;

    public Veiculo(int id, String nome, String cor, int numMarchas, int numPortas, String marca, String anoFabricacao) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.numMarchas = numMarchas;
        this.numPortas = numPortas;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNumMarchas() {
        return numMarchas;
    }

    public void setNumMarchas(int numMarchas) {
        this.numMarchas = numMarchas;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    
    
 
    public void exibeVeiculo(){
        System.out.println("--- Detalhes do Veiculo ---");
        System.out.println("Nome: " + getNome()); 
        System.out.println("Cor: " + getCor()); 
        System.out.println("Número de marchas: " + getNumMarchas()); 
        System.out.println("Número de portas: " + getNumPortas()); 
        System.out.println("Marca: " + getMarca());
        System.out.println("Ano de fabricação" + getAnoFabricacao());
        System.out.println("---------------------------");
    }
}