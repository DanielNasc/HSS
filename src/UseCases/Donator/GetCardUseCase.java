package UseCases.Donator;

import Model.Entities.BloodDonator;
import Model.Entities.Card;
import Model.Repositories.DonatorRepository;

public class GetCardUseCase {
    public static Card execute(String rg) {
        BloodDonator donator = DonatorRepository.getByRG(rg);

        if (donator == null || donator.getLastExam() == null) {
            return null;
        }

        return new Card(donator.getName(), donator.getLastExam());
    }
}
