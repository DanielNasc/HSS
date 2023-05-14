package UseCases.Donator;

import java.time.LocalDate;

import Model.Entities.BloodDonator;
import Model.Repositories.DonatorRepository;

public class CreateDonatorUseCase {
    public static boolean execute(
        String name,
        String cpf,
        String email,
        String rg,
        LocalDate dateOfBirth,
        int gender,
        String bloodType,
        String address
    ) {
        BloodDonator bloodDonator = new BloodDonator(
                                                    name, 
                                                    cpf, 
                                                    email,
                                                    dateOfBirth,
                                                    gender,
                                                    bloodType,
                                                    address, rg);


        try {
            DonatorRepository.addDonator(bloodDonator);
            return true;
        } catch(Error error) {
            return false;
        }
    }
}
