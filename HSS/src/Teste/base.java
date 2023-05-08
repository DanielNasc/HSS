package Teste;

import java.time.LocalDate;
import Dados.*;

public class base {
    public static void main(String[] args) {
        // Teste de Doador (String nome, String cpf, String email, LocalDate dataNascimento, String sexo, String tipoSanguineo, String fatorRH, String endereco)
        Doador d = new Doador("Lucas", "12345678910", "luacas@gmail", LocalDate.of(2000, 10, 10), "Masculino", "A", "+", "Rua 1");
        System.out.println(d.getNome());

        // Teste de AuxiliarCadastro (String nome, String cpf, String email, LocalDate dataNascimento, String sexo)
        AuxiliarCadastro ac = new AuxiliarCadastro("Ana", "12515156110", "ana@gmail", LocalDate.of(1990, 05, 10), "Femino");
        System.out.println(ac.isDisponivel());
        
        
    }
}
