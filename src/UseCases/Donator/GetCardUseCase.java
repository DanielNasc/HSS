package UseCases.Donator;

import Errors.NotFoundDataException;
import Model.Entities.BloodDonator;
import Model.Entities.Card;
import Model.Repositories.DonatorRepository;

public class GetCardUseCase {
    public static Card execute(String rg) throws NotFoundDataException {
        BloodDonator donator = DonatorRepository.getByRG(rg);

        if (donator == null || donator.getLastExam() == null) {
            throw new NotFoundDataException("Donator", "Donator com RG " + rg + " não encontrado ou não possui exames");
        }

        return new Card(donator.getName(), donator.getLastExam());
    }
}
