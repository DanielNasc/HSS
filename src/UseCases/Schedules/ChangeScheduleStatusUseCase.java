package UseCases.Schedules;

import Model.Repositories.SchedulesRepository;
import Utils.enums.ScheduleStatus;

public class ChangeScheduleStatusUseCase {
    public static boolean execute(String rg, ScheduleStatus newScheduleStatus) {
        return SchedulesRepository.updateSchedule(rg, newScheduleStatus);
    }
}
