package UseCases.Schedules.FindSchedule;

import java.time.LocalDate;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;

public class FindScheduleUseCase {
    public Schedule findShedule(String rg, LocalDate dateOfBirth) {
        for (Schedule schedule : SchedulesRepository.getAll()) {
            if (schedule.getRg().equals(rg)) { // if rg is equal
                if (schedule.getDateOfBirth().equals(dateOfBirth)) { // and date of birth is equal
                    return schedule;
                }
                
                return null; // if rg is equal but date of birth is not equal
            }

            if (schedule.getDateOfBirth().equals(dateOfBirth)) { // if date of birth is equal
                if (schedule.getRg().equals(rg)) { // and rg is equal
                    return schedule;
                }
                
                return null; // if date of birth is equal but rg is not equal
            }
        }   
        
        return null; // if rg is not equal
    }
}
