package Dados;
import java.time.LocalDate;

public class Servidor extends Pessoa{
    private boolean disponivel;

    public Servidor(String nome, String cpf, String email, LocalDate dataNascimento, String sexo) {
        super(nome, cpf, email, dataNascimento, sexo);
        this.disponivel = true;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}
