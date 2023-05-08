package Dados;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private int idade;
    private String sexo;

    public Pessoa(String nome, String cpf, String email, LocalDate dataNascimento, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.idade = geraIdade(dataNascimento);
        this.sexo = sexo;

    }
    public static int geraIdade(final LocalDate aniversario) {
        final LocalDate dataAtual = LocalDate.now();
        final int Ano = dataAtual.getYear() - aniversario.getYear() - 1;
        final int Mes = aniversario.getMonthValue();
        final int Dia = aniversario.getDayOfMonth();
        if (dataAtual.getMonthValue() > Mes || dataAtual.getMonthValue() == Mes && dataAtual.getDayOfMonth() >= Dia) {
            return Ano + 1;
        }
        return Ano;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public int getIdade() {
        return idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
