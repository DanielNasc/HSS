package Model.Repositories;
import java.util.ArrayList;
import java.util.List;

import Model.Entities.BloodDonator;

public class DonatorRepository {
    private static List<BloodDonator> donators;

    public DonatorRepository() {
        donators = new ArrayList<BloodDonator>();
    }
    public void addDonator(BloodDonator donator) {
        if (checkDonator(donator.getCpf())) {
            System.out.println("Doador já cadastrado");
            return;
        }
        donators.add(donator);
    }
    public boolean checkDonator(String cpf) {
        for (BloodDonator donator : donators) {
            if (donator.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
    public List<BloodDonator> getAll() {
        return donators;
    }
    public void printDonatorsByBloodType(String bloodType) {
        for (BloodDonator donator : donators) {
            if (donator.getBloodType().equals(bloodType)) {
                System.out.println(donator.getName() + 
                " - " + donator.getCpf() +
                " - " + donator.getBloodType() + 
                " - " + donator.getDonationsCounter() + " doações.");
            }
        }
    }
    public BloodDonator getByCPF(String cpf) {
        for (BloodDonator donator : donators) {
            if (donator.getCpf().equals(cpf)) {
                return donator;
            }
        }
        return null;
    }
    public void removeByCPF(String cpf) {
        for (BloodDonator donator: donators) {
            if (donator.getCpf().equals(cpf)) {
                donators.remove(donator);
                System.out.println("Doador removido com sucesso");
                break;
            }
        }
    }
    public int numberOfDonators() {
        return donators.size();
    }
}
