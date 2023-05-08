package br.com.ufca.poo.HSS.Armazenamento;
import br.com.ufca.poo.HSS.Dados.Doador;
import java.util.List;
import java.util.ArrayList;

public class PacoteDoadores {
    private List<Doador> doadores;

    public PacoteDoadores() {
        this.doadores = new ArrayList<>();
    }
    public void addDoador(Doador doador){
        doadores.add(doador);
    }
    public List<Doador> getDoadores(){
        return doadores;
    }
    public boolean checharDoador(String cpf){
        for(Doador doador : doadores){
            if(doador.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }
    public Doador getDoador(String cpf){
        for(Doador doador : doadores){
            if(doador.getCpf().equals(cpf)){
                return doador;
            }
        }
        return null;
    }
    public void removerDoador(String cpf){
        for(Doador doador : doadores){
            if(doador.getCpf().equals(cpf)){
                doadores.remove(doador);
            }
            else{
                System.out.println("Doador não encontrado");
            }
        }
    }

}
