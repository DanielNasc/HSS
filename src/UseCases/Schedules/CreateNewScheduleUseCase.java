package UseCases.Schedules;

import java.time.LocalDate;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;

public class CreateNewScheduleUseCase {
    public static boolean execute(String rg, LocalDate dateOfBirth) {
        Schedule schedule = new Schedule(rg, dateOfBirth);

        return SchedulesRepository.add(schedule);
    } 
}
