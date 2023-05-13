package UseCases.Schedules;

import java.time.LocalDate;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;

public class FindScheduleUseCase {
    public static Schedule execute(String rg, LocalDate dateOfBirth) {
        for (Schedule schedule : SchedulesRepository.getAll()) {
            if (schedule.getRg().equals(rg)) { // if rg is equal
                if (schedule.getDateOfBirth().equals(dateOfBirth)) { // and date of birth is equal
                    return schedule;
                }
                
                return null; // if rg is equal but date of birth is not equal
            }
        }   
        
        return null; // if rg is not equal
    }
}
