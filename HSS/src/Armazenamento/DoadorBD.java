package Armazenamento;
import java.util.ArrayList;
import java.util.List;
import Dados.Doador;

public class DoadorBD {
    private static List<Doador> doadores = new ArrayList<Doador>();

    public static void addDoador(Doador doador) {
        doadores.add(doador);
        ordenaDoadores();
    }
    public static List<Doador> getDoadores() {
        return doadores;
    }
    public static Doador getDoador(String cpf) {
        for (Doador doador : doadores) {
            if (doador.getCpf().equals(cpf)) {
                return doador;
            }
        }
        return null;
    }

    public static void removeDoador(String cpf) {
        for (Doador doador : doadores) {
            if (doador.getCpf().equals(cpf)) {
                doadores.remove(doador);
                ordenaDoadores();
                break;
            }
        }
    }
    public static void ordenaDoadores(){
        for (int i = 0; i < doadores.size(); i++) {
            for (int j = 0; j < doadores.size() - 1; j++) {
                if (doadores.get(j).getDataNascimento().isAfter(doadores.get(j + 1).getDataNascimento())) {
                    Doador aux = doadores.get(j);
                    doadores.set(j, doadores.get(j + 1));
                    doadores.set(j + 1, aux);
                }
            }
        }
    }
    public static Boolean isDoador(String cpf) {
        for (Doador doador : doadores) {
            if (doador.getCpf().equals(cpf) && doador.getDoacoesRealizadas() != 0) {
                return true;
            }
        }
        return false;
    }

}
