package Dados;
import java.time.LocalDate;

public class Doador extends Pessoa{
    private String tipoSanguineo;
    private String fatorRH;
    private String endereco;
    private boolean cadastrado;
    private int etapaDoacao;
    private int doacoesRealizadas;

    public Doador(String nome, String cpf, String email, LocalDate dataNascimento, String sexo, String tipoSanguineo, String fatorRH, String endereco) {
        super(nome, cpf, email, dataNascimento, sexo);
        this.cadastrado = false;
        this.tipoSanguineo = tipoSanguineo;
        this.fatorRH = fatorRH;
        this.endereco = endereco;
        this.etapaDoacao = 0;
        this.doacoesRealizadas = 0;
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
