package br.com.ufca.poo.HSS.Dados;
import br.com.ufca.poo.HSS.Armazenamento.PacoteDoadores;
import java.time.LocalDate;
import java.util.Scanner;

public class AuxiliarCadastro extends Servidor{
    private String funcao;
    private PacoteDoadores doadores;
    private Doador doador;

    public AuxiliarCadastro(String nome, String cpf, String telefone, String sexo, LocalDate dataNascimento, boolean disponivel, String funcao) {
        super(nome, cpf, telefone, sexo, dataNascimento, disponivel);
        this.funcao = funcao;
    }
    public String getFuncao(){
        return funcao;
    }
    public void cadastrarDoador(){
        Scanner input = new Scanner(System.in);
        System.out.println("Cadastrar doador: ");
        System.out.println("CPF: ");
        String cpf = input.nextLine();
        boolean existente = doadores.checharDoador(cpf);
        if (existente == true){
            System.out.println("Doador já cadastrado");
        }else{
            System.out.println("Nome: ");
            String nome = input.nextLine();
            System.out.println("Telefone: ");
            String telefone = input.nextLine();
            System.out.println("Sexo: ");
            String sexo = input.nextLine();
            System.out.println("Data de nascimento: ");
            LocalDate dataNascimento = LocalDate.parse(input.nextLine());
            System.out.println("Endereco: ");
            String endereco = input.nextLine();
            System.out.println("Tipo sanguíneo: ");
            String tipoSanguineo = input.nextLine();
            System.out.println("Fator RH: ");
            String fatorRH = input.nextLine();
            System.out.println("Email: ");
            String email = input.nextLine();
            boolean cadastrado = true;
            System.out.println("Carteirinha: ");
            String carteirinha = input.nextLine();
            int EtapaDoacao = 0;
            doador = new Doador(nome, cpf, telefone, sexo, dataNascimento, endereco, tipoSanguineo, fatorRH, email, cadastrado, carteirinha, EtapaDoacao);
            System.out.println("Doador cadastrado com sucesso!");
            input.close();
        }
        doadores.addDoador(doador);
    }

}

