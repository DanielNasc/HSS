package Teste;

import java.time.LocalDate;
import Dados.*;

public class base {
    public static void main(String[] args) {
        // Teste de Pessoa
        Pessoa p = new Pessoa("João", "12345678910", "luann@gmail.com", LocalDate.of(1999, 5, 9), "M");
        System.out.println("Nome: " + p.getNome());
        //idade
        System.out.println("Idade: " + p.getIdade());
    }
}
