package Dados;

import java.time.LocalDate;

public class Doador {
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private int idade;
    private String sexo;
    private String tipoSanguineo;
    private String fatorRH;
    private String endereco;
    private boolean cadastrado;
    private int etapaDoacao;
    private int doacoesRealizadas;

    public Doador(
            String nome,
            String cpf,
            String email,
            LocalDate dataNascimento,
            String sexo,
            String tipoSanguineo,
            String fatorRH,
            String endereco
        ) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.idade = geraIdade(dataNascimento);
        this.sexo = sexo;
        this.cadastrado = false;
        this.tipoSanguineo = tipoSanguineo;
        this.fatorRH = fatorRH;
        this.endereco = endereco;
        this.etapaDoacao = 0;
        this.doacoesRealizadas = 0;
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

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    public String getFatorRH() {
        return fatorRH;
    }
    public String getEndereco() {
        return endereco;
    }
    public boolean isCadastrado() {
        return cadastrado;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getEtapaDoacao() {
        return etapaDoacao;
    }
    public int getDoacoesRealizadas() {
        return doacoesRealizadas;
    }
    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
        this.etapaDoacao = 1;
    }
}
