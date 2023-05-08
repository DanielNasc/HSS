package br.com.ufca.poo.HSS.Dados;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa{
    private String nome;
    private String cpf;
    //private String rg;
    private String telefone;
    private String sexo;
    private LocalDate dataNascimento;
    private int idade;

    public Pessoa(String nome, String cpf, String telefone, String sexo, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.idade = geraIdade(dataNascimento);
    }

    public static int geraIdade(final LocalDate aniversario) {
        final LocalDate dataAtual = LocalDate.now();
        final Period idade = Period.between(aniversario, dataAtual);
        return idade.getYears();
    }

    //Retornar dados
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getSexo(){
        return sexo;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public int getIdade(){
        return idade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
}