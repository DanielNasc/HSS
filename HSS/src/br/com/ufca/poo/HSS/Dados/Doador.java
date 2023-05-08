package br.com.ufca.poo.HSS.Dados;

import java.time.LocalDate;

//Doador é pessoa

public class Doador extends Pessoa{
    private String endereco;
    private String tipoSanguineo;
    private String fatorRH;
    private String email;
    private boolean cadastrado;
    private String carteirinha;
    private int EtapaDoacao;

    public Doador(String nome, String cpf, String telefone, String sexo, LocalDate dataNascimento, String endereco, String tipoSanguineo, String fatorRH, String email, boolean cadastrado, String carteirinha, int EtapaDoacao) {
        super(nome, cpf, telefone, sexo, dataNascimento);
        this.endereco = endereco;
        this.tipoSanguineo = tipoSanguineo;
        this.fatorRH = fatorRH;
        this.email = email;
        this.cadastrado = cadastrado;
        this.carteirinha = carteirinha;
        this.EtapaDoacao = EtapaDoacao;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getTipoSanguineo(){
        return tipoSanguineo;
    }
    public String getFatorRH(){
        return fatorRH;
    }
    public String getEmail(){
        return email;
    }
    public boolean getCadastrado(){
        return cadastrado;
    }
    public String getCarteirinha(){
        return carteirinha;
    }
    public int getEtapaDoacao(){
        return EtapaDoacao;
    }
    public void comer(){
        System.out.println("Comendo");

    }
}
