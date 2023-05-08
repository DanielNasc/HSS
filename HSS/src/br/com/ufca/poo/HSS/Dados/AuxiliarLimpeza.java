package br.com.ufca.poo.HSS.Dados;
import java.time.LocalDate;


public class AuxiliarLimpeza extends Servidor{
    public AuxiliarLimpeza(String nome, String cpf, String telefone, String sexo, LocalDate dataNascimento, boolean disponivel) {
        super(nome, cpf, telefone, sexo, dataNascimento, disponivel);
    }
    public void limparPiso(){
        //Limpar piso
    }
    public void tirarLixo(){
        //Tirar lixo
    }
    public void verificarGarrafao(){
        //Verificar garrafão
    }
    public void reporGarrafao(){
        //Repor garrafão
    }
    public void limparCantina(){
        //Limpar cantina
    }
    public void limparBanheiro(){
        //Limpar banheiro
    }
    public void higienizarMacas(){
        //Higienizar macas
    }


}
