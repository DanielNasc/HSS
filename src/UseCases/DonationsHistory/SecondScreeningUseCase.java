package UseCases.DonationsHistory;

import java.util.ArrayList;

import Errors.NotFoundDataException;
import Errors.ScreeningException;
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
    ) throws NotFoundDataException, ScreeningException {
        BloodDonator donator = DonatorRepository.getByRG(rg);

        if (donator == null) {
            throw new NotFoundDataException("Donator", "Doador com RG: " + rg + " não encontrado");
        }

        ClinicalScreening clinicalScreening = new ClinicalScreening(donator.getAge(), donator.getGender());

        clinicalScreening.checkClinicalScreeningInfluentialQuestions(clinicalScreeningInfluentialQuestions);

        clinicalScreening.checkBloodPressure();
        clinicalScreening.checkHeartBeats();
        clinicalScreening.checkBodyTemperature();
        clinicalScreening.checkHemoglobin();
        clinicalScreening.checkHeight();
        clinicalScreening.checkWeight();
        clinicalScreening.checkIMC();

        // Não pode doar a pessoa que apresentar hematócrito menor que 39% ( ou hemoglobina <13g/dL) no homem e 38% (ou hemoglobina <12,5g/dL) na mulher. 
        // Batimentos/pulso entre 60 e 100
        // Pressão Mínima: < 90mmHg / < 60 mmHg
        // Sem histórico de hipertensão: 140 mmHg / 90 mmHg
        // Com histórico de hiperte+nsão: >= 180 mmHg / 100mmHg
        // Peso abaixo de 50 kg
        // Idade fora do intervalo entre 18 - 69 anos
        clinicalScreening.checkResults();
        ArrayList<String> failedTests = clinicalScreening.getFailedTests();
        if (failedTests.size() > 0) {
            SchedulesRepository.updateSchedule(rg, ScheduleStatus.FAILED);
            String failedTestsString = "";
            for (String failedTest : failedTests) {
                failedTestsString += failedTest + ", ";
            }

            throw new ScreeningException(failedTestsString);
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
