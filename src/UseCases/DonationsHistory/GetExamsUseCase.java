package UseCases.DonationsHistory;

import java.util.ArrayList;

import Errors.NotFoundDataException;
import Model.Entities.BloodDonator;
import Model.Entities.DonationRegistry;
import Model.Repositories.DonationHistoryRepository;
import Model.Repositories.DonatorRepository;

public class GetExamsUseCase {
    public static ArrayList<DonationRegistry> execute(String rg) throws NotFoundDataException {
        BloodDonator donator = DonatorRepository.getByRG(rg);

        if (donator == null) {
            throw new NotFoundDataException("Donator", "Doador com RG: " + rg + " não encontrado");
        }

        return DonationHistoryRepository.getByDonatorId(donator.getRG());
    }
}
