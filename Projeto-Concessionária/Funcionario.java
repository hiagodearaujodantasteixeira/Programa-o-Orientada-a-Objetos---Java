/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hiago
 */
public class Funcionario extends Pessoa {
    private int numMatricula;
    private String qualificacao;
    private String descricaoFuncao;
    private int cargaHorariaSemanal;

    public Funcionario(String nome, int numMatricula, String qualificacao, String descricaoFuncao, int cargaHorariaSemanal) {
        super(nome);
        this.numMatricula = numMatricula;
        this.qualificacao = qualificacao;
        this.descricaoFuncao = descricaoFuncao;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }
    
    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatriculo) {
        this.numMatricula = numMatriculo;
    }

    public String getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(String qualificacao) {
        this.qualificacao = qualificacao;
    }

    public String getDescricaoFuncao() {
        return descricaoFuncao;
    }

    public void setDescricaoFuncao(String descricaoFuncao) {
        this.descricaoFuncao = descricaoFuncao;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(int cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }
    
    public void exibeFuncionario() {
        System.out.println("--- Detalhes do Funcionário ---");
        System.out.println("Número de matrícula: " + getNumMatricula()); 
        System.out.println("Qualificação: " + getQualificacao()); 
        System.out.println("Descrição da função: " + getDescricaoFuncao()); 
        System.out.println("Carga horária semanal de trabalho: " + getCargaHorariaSemanal()); 
        System.out.println("---------------------------");
    }
}
