import java.util.Scanner;

public class Hemoce {
    Pessoa[] pessoas;

    public void cadastrarPessoa(Pessoa pessoa) {
        Pessoa[] pessoas = new Pessoa[this.pessoas.length + 1];
        for (int i = 0; i < this.pessoas.length; i++) {
            pessoas[i] = this.pessoas[i];
        }
        pessoas[pessoas.length - 1] = pessoa;
        this.pessoas = pessoas;
    }

    public void removerPessoa(Pessoa pessoa) {
        //buscar pessoa
        int index = -1;
        for (int i = 0; i < this.pessoas.length; i++) {
            if (this.pessoas[i].nome.equals(pessoa.nome)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Pessoa não encontrada");
            return;
        }
        //remover pessoa
        Pessoa[] pessoas = new Pessoa[this.pessoas.length - 1];
        for (int i = 0; i < pessoas.length; i++) {
            if (i < index) {
                pessoas[i] = this.pessoas[i];
            } else {
                pessoas[i] = this.pessoas[i + 1];
            }
        }
        this.pessoas = pessoas;
    }
    public void checarImpedimento(){
        for (int i = 0; i < this.pessoas.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("A pessoa " + this.pessoas[i].nome + " teve Gripe, resfriado e/ou febre? (S/N)");
            String resposta = scanner.nextLine();
            System.out.println("A pessoa " + this.pessoas[i].nome + " está no período gestacional ou pós-gravidez? (S/N)");
            resposta = scanner.nextLine();
            System.out.println("A pessoa " + this.pessoas[i].nome + " fez tatuagem ou colocou piercing nos últimos 12 meses? (S/N)");
            resposta = scanner.nextLine();
            System.out.println("A pessoa " + this.pessoas[i].nome + " fez endoscopia nos últimos 6 meses? (S/N)");
            resposta = scanner.nextLine();
            System.out.println("A pessoa " + this.pessoas[i].nome + " fez cirurgia nos últimos 6 meses? (S/N)");
            resposta = scanner.nextLine();
            System.out.println("A pessoa " + this.pessoas[i].nome + " fez transfusão de sangue nos últimos 12 meses? (S/N)");
            resposta = scanner.nextLine();
            System.out.println("A pessoa " + this.pessoas[i].nome + " fez tratamento dentário nos últimos 3 dias? (S/N)");
            resposta = scanner.nextLine();
            System.out.println("A pessoa " + this.pessoas[i].nome + " fez tratamento com vacina nos últimos 30 dias? (S/N)");
            resposta = scanner.nextLine();
            if (resposta.equals("S")) {
                this.pessoas[i].apto = false;
            }
            scanner.close();
        }
    }

    public void checarRequisitos(){
        checarImpedimento();
        for (int i = 0; i < this.pessoas.length; i++) {
            if (this.pessoas[i].idade >= 16 && this.pessoas[i].idade <= 69) {
                if (this.pessoas[i].peso >= 50) {
                    if (this.pessoas[i].sexo.equals("F") && this.pessoas[i].idade <= 60) {
                        if (this.pessoas[i].apto) {
                            this.pessoas[i].doador = true;
                        }
                    } else if (this.pessoas[i].sexo.equals("M") && this.pessoas[i].idade <= 65) {
                        if (this.pessoas[i].apto) {
                            this.pessoas[i].doador = true;
                        }
                    }
                }
            }
        }
    }

    public void listarDoadores(){
        for (int i = 0; i < this.pessoas.length; i++) {
            if (this.pessoas[i].doador) {
                System.out.println(this.pessoas[i].nome);
            }
        }
    }
    
    public void listarDoadoresPorTipoSanguineo(String tipoSanguineo){
        for (int i = 0; i < this.pessoas.length; i++) {
            if (this.pessoas[i].doador && this.pessoas[i].tipoSanguineo.equals(tipoSanguineo)) {
                System.out.println(this.pessoas[i].nome);
            }
        }
    }

    public void listarDoadoresPorSexo(String sexo){
        for (int i = 0; i < this.pessoas.length; i++) {
            if (this.pessoas[i].doador && this.pessoas[i].sexo.equals(sexo)) {
                System.out.println(this.pessoas[i].nome);
            }
        }
    }
    

}
