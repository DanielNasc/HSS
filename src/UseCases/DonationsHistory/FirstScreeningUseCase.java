package UseCases.DonationsHistory;

import Model.Repositories.SchedulesRepository;
import Utils.ClinicalScreening;
import Utils.enums.ScheduleStatus;

public class FirstScreeningUseCase {
    public static void execute(
        String rg,
        boolean[] clinicalScreeningOffsideQuestions
    ) {
        ClinicalScreening clinicalScreening = new ClinicalScreening();

        clinicalScreening.checkClinicalScreeningOffsideQuestions(clinicalScreeningOffsideQuestions);

        if (clinicalScreening.getClinicalScreeningFailed()) {
            SchedulesRepository.updateSchedule(rg, ScheduleStatus.FAILED);

            throw new Error("Infelizmente, de acordo com as perguntas iniciais da Triagem Clínica, você não está apto(a) para doar.");
        }
    }
}
