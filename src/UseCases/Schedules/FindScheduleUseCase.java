package UseCases.Schedules;

import java.time.LocalDate;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;

public class FindScheduleUseCase {
    public static Schedule execute(String rg, LocalDate dateOfBirth) {
        return SchedulesRepository.findOne(rg, dateOfBirth);
    }
}
