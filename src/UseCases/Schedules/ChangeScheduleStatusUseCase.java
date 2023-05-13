package UseCases.Schedules;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;
import Utils.enums.ScheduleStatus;

public class ChangeScheduleStatusUseCase {
    public void execute(String rg, ScheduleStatus newScheduleStatus) {
        Schedule schedule = SchedulesRepository.getByRg(rg);
        schedule.changeStatus(newScheduleStatus);
    }
}
