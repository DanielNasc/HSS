package Armazenamento;
import java.util.ArrayList;
import java.util.List;
import Dados.BloodDonator;

public class DonatorRepository {
    private static List<BloodDonator> donators;

    public DonatorRepository() {
        donators = new ArrayList<BloodDonator>();
    }
    public static void addDonator(BloodDonator donator) {
        donators.add(donator);
    }
    public static boolean checkDonator(String cpf) {
        for (BloodDonator donator : donators) {
            if (donator.getCpf().equals(cpf) && donator.getDonationsCounter()>0) {
                return true;
            }
        }
        return false;
    }
    public static List<BloodDonator> getAll() {
        return donators;
    }
    public static void printDonatorsByBloodType(String bloodType) {
        for (BloodDonator donator : donators) {
            if (donator.getBloodType().equals(bloodType)) {
                System.out.println(donator.getName() + 
                " - " + donator.getCpf() +
                " - " + donator.getBloodType() + 
                " - " + donator.getDonationsCounter() + " doações.");
            }
        }
    }
    public static BloodDonator getByCPF(String cpf) {
        for (BloodDonator donator : donators) {
            if (donator.getCpf().equals(cpf)) {
                return donator;
            }
        }
        return null;
    }
    public static void removeByCPF(String cpf) {
        for (BloodDonator donator: donators) {
            if (donator.getCpf().equals(cpf)) {
                donators.remove(donator);
                System.out.println("Doador removido com sucesso");
                break;
            }
        }
    }
    public static int numberOfDonators() {
        return donators.size();
    }
}
