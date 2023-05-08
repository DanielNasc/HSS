package br.com.ufca.poo.HSS.Dados;

import java.time.LocalDate;

public class Servidor extends Pessoa{
    private boolean disponivel;

    public Servidor(String nome, String cpf, String telefone, String sexo, LocalDate dataNascimento, boolean disponivel) {
        super(nome, cpf, telefone, sexo, dataNascimento);
        this.disponivel = disponivel;
    }
    public boolean getDisponivel(){
        return disponivel;
    }
}
