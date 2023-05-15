package UseCases.DonationsHistory;

import Model.Entities.BloodDonator;
import Model.Entities.DonationRegistry;
import Model.Repositories.DonationHistoryRepository;
import Model.Repositories.DonatorRepository;
import Model.Repositories.SchedulesRepository;
import Utils.ClinicalScreening;
import Utils.enums.ScheduleStatus;

public class SecondScreeningUseCase {
    public static void execute(
        String rg,
        int[] clinicalScreeningInfluentialQuestions,
        boolean hypertensive
    ) {
        BloodDonator donator = DonatorRepository.getByRG(rg);

        if (donator == null) {
            throw new Error("Doador não existe.");
        }

        ClinicalScreening clinicalScreening = new ClinicalScreening();

        clinicalScreening.checkClinicalScreeningInfluentialQuestions(clinicalScreeningInfluentialQuestions);

        clinicalScreening.checkBloodPressure(donator.getAge(), donator.getGender());
        clinicalScreening.checkHeartBeats();
        clinicalScreening.checkBodyTemperature();
        clinicalScreening.checkHemoglobin(donator.getGender());
        clinicalScreening.checkHeight(donator.getGender());
        clinicalScreening.checkWeight(donator.getGender());
        clinicalScreening.checkIMC();

        // Não pode doar a pessoa que apresentar hematócrito menor que 39% ( ou hemoglobina <13g/dL) no homem e 38% (ou hemoglobina <12,5g/dL) na mulher. 
        // Batimentos/pulso entre 60 e 100
        // Pressão Mínima: < 90mmHg / < 60 mmHg
        // Sem histórico de hipertensão: 140 mmHg / 90 mmHg
        // Com histórico de hiperte+nsão: >= 180 mmHg / 100mmHg
        // Peso abaixo de 50 kg
        // Idade fora do intervalo entre 18 - 69 anos
        if (
            clinicalScreening.getBodyTemperature() > 37 ||
            (clinicalScreening.getHemoglobin() < 13 && donator.getGender() == 0) ||
            (clinicalScreening.getHemoglobin() < 12.5 && donator.getGender() == 1) ||
            (clinicalScreening.getBloodPressure()[0] < 90 || clinicalScreening.getBloodPressure()[1] < 60) ||
            ((clinicalScreening.getBloodPressure()[0] > 140 || clinicalScreening.getBloodPressure()[1] > 90) && hypertensive == false) ||
            ((clinicalScreening.getBloodPressure()[0] > 180 || clinicalScreening.getBloodPressure()[1] > 100) && hypertensive == true) ||
            clinicalScreening.getWeight() < 50 ||
            clinicalScreening.getHeartBeats() < 60 || clinicalScreening.getHeartBeats() > 100 ||
            clinicalScreening.getIMC() < 18.5 ||
            donator.getAge() < 18 || donator.getAge() > 69
        ) {
            SchedulesRepository.updateSchedule(rg, ScheduleStatus.FAILED);

            throw new Error("Infelizmente, você não está apto(a) para doar.");
        }
    
        DonationRegistry donation = new DonationRegistry(
            clinicalScreening.getBloodPressure(),
            clinicalScreening.getHeartBeats(),
            clinicalScreening.getBodyTemperature(),
            clinicalScreening.getHemoglobin(),
            clinicalScreening.getHeigh(),
            clinicalScreening.getWeight(),
            clinicalScreening.getIMC(),
            donator.getId()
        );

        DonationHistoryRepository.add(donation);

        SchedulesRepository.updateSchedule(rg, ScheduleStatus.SUCESS);

        donator.addDonation();
    }
}
