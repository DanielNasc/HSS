package UseCases.DonationsHistory.CreateDonationRegistry;

import Model.Entities.DonationRegistry;
import Model.Repositories.DonationHistoryRepository;

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
    }
}
