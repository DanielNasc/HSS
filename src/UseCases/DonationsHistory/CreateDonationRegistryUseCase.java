package UseCases.DonationsHistory;

import Model.Entities.DonationRegistry;
import Model.Repositories.DonationHistoryRepository;
import Model.Repositories.DonatorRepository;

public class CreateDonationRegistryUseCase {
    public void execute(
        int[] bloodPressure,
        int heartBeats,
        double bodyTemperature,
        double hemoglobin,
        double height,
        double weight,
        double imc,
        String donatorID
    ) {
        DonationRegistry newDonation = new DonationRegistry(
            bloodPressure,
            heartBeats,
            bodyTemperature,
            hemoglobin,
            height,
            weight,
            imc,
            donatorID
        );
        
        DonationHistoryRepository.add(newDonation);

        DonatorRepository.updateLastExam(donatorID, newDonation.getDate());
    }
}
