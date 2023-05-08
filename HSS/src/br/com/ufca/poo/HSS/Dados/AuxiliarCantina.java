package br.com.ufca.poo.HSS.Dados;
import java.time.LocalDate;

public class AuxiliarCantina extends Servidor{
    private String[] menu;
    //private int fila;
    public AuxiliarCantina(String nome, String cpf, String telefone, String sexo, LocalDate dataNascimento, boolean disponivel, String[] menu) {
        super(nome, cpf, telefone, sexo, dataNascimento, disponivel);
        this.menu = menu;
    }
    public void ImprimirCardapio(){
        System.out.println("Cardápio:");
        for(int i = 0; i < menu.length; i++){
            System.out.println(menu[i]);
        }
    }
    public void verificarEstoque(){
        if(menu.length < 5){
            reporEstoque();
        }
    }
    public void reporEstoque(){
        for(int i = 0; i < 30; i++){
            if(menu[i] != null){
                i++;
                break;
            }
            if(i%2 == 0){
                menu[i] = "Suco de Caixinha";
            }
            else{
                menu[i] = "Biscoito";
            }
        }
    }
    public void receberDoador(Doador doador){
        
    }
    public void verificarDoador(Doador doador){
        //Verificar doador
    }
    public void servirLanche(Doador doador){
        //Servir lanche
    }
    public void atualizarEtapaDoacao(Doador doador){
        //Atualizar etapa de doação
    }

    
}
