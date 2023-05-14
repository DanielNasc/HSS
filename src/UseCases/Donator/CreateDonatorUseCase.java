package UseCases.Donator;

import java.time.LocalDate;

import Model.Entities.BloodDonator;
import Model.Repositories.DonatorRepository;

public class CreateDonatorUseCase {
    public static void execute(
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

        DonatorRepository.addDonator(bloodDonator);
    }
}
