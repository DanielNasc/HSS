package Dados;
import java.time.LocalDate;

public class AuxiliarCadastro extends Servidor{
    public AuxiliarCadastro(String nome, String cpf, String email, LocalDate dataNascimento, String sexo) {
        super(nome, cpf, email, dataNascimento, sexo);
    }
}
