package UseCases.DonationsHistory;

import Model.Repositories.SchedulesRepository;
import Utils.ClinicalScreening;
import Utils.enums.ScheduleStatus;

public class FirstScreeningUseCase {
    public static boolean execute(
        String rg,
        boolean[] clinicalScreeningOffsideQuestions
    ) {
        ClinicalScreening clinicalScreening = new ClinicalScreening();

        clinicalScreening.checkClinicalScreeningOffsideQuestions(clinicalScreeningOffsideQuestions);

        if (clinicalScreening.getClinicalScreeningFailed()) {
            SchedulesRepository.updateSchedule(rg, ScheduleStatus.FAILED);

            return false;
        }

        return true;
    }
}
