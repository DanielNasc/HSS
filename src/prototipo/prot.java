package prototipo;
import Dados.*;
import Armazenamento.*;
import java.time.LocalDate;


public class prot {
    public static void main(String[] args){
        // Create new blood donators
        BloodDonator bd = new BloodDonator(
            "Luann",
            "12345678910",
            "luann@gmail",
            LocalDate.of(1999, 07, 05),
            "M",
            "O+",
            "Rua 1"
        );
        BloodDonator bd4 = new BloodDonator(
            "Luann",
            "12345678910",
            "luann@gmail",
            LocalDate.of(1999, 07, 05),
            "M",
            "O+",
            "Rua 1"
        );
        BloodDonator bd2 = new BloodDonator(
            "Daniel",
            "15645645646",
            "Daniel@gmail",
            LocalDate.of(1999, 07, 05),
            "M",
            "O+",
            "Rua 2"
        );
        BloodDonator bd3 = new BloodDonator(
            "Luma",
            "15935778910",
            "luma2@gmail",
            LocalDate.of(1999, 07, 05),
            "S",
            "A-",
            "Rua 3"
        );
        // Create new donator repository
        DonatorRepository donatorRepository = new DonatorRepository();

        // Add donators to repository
        donatorRepository.addDonator(bd);
        donatorRepository.addDonator(bd2);
        donatorRepository.addDonator(bd3);
        donatorRepository.addDonator(bd4);

        // Print donators
        donatorRepository.printDonatorsByBloodType("O+");
        
        // Check if donator exists
        if(donatorRepository.checkDonator("12345678910")){
            System.out.println("Donator exists");
        }else{
            System.out.println("Donator does not exist");
        }

        // Remove donator
        donatorRepository.removeByCPF("12345678910");

        // Get donator by CPF
        BloodDonator bd5 = donatorRepository.getByCPF(bd2.getCpf());
        // print donator
        if(bd5 == null){
            System.out.println("Donator does not exist");
        }else{
            System.out.println(
                bd5.getName() + " : "+ bd5.getCpf() + " : " + 
                bd5.getEmail() + " : " + bd5.getDateOfBirth() + " : " + 
                bd5.getSex() + " : " + bd5.getBloodType() + " : " + 
                bd5.getAddress() + " : " + bd5.getAge());
        }
        




    }
}
