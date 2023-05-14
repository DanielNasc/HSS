package UseCases.DonationsHistory;

import java.util.ArrayList;

import Model.Entities.BloodDonator;
import Model.Entities.DonationRegistry;
import Model.Repositories.DonationHistoryRepository;
import Model.Repositories.DonatorRepository;

public class GetExamsUseCase {
    public static ArrayList<DonationRegistry> execute(String rg) {
        BloodDonator donator = DonatorRepository.getByRG(rg);

        if (donator == null) {
            return null;
        }

        return DonationHistoryRepository.getByDonatorId(donator.getRG());
    }
}
