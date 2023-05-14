package UseCases.Schedules;

import java.time.LocalDate;

import Model.Entities.BloodDonator;
import Model.Entities.Schedule;
import Model.Repositories.DonatorRepository;
import Model.Repositories.SchedulesRepository;

public class FindScheduleUseCase {
    public static Schedule execute(String rg, LocalDate dateOfBirth, boolean hasToken) {
        if (hasToken) {
            BloodDonator donator = DonatorRepository.getByRG(rg);
            
            if (donator == null) return null;

            dateOfBirth = donator.getDateOfBirth();
        }

        return SchedulesRepository.findOne(rg, dateOfBirth);
    }
}
