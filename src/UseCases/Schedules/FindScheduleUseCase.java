package UseCases.Schedules;

import java.time.LocalDate;

import Errors.NotFoundDataException;
import Model.Entities.BloodDonator;
import Model.Entities.Schedule;
import Model.Repositories.DonatorRepository;
import Model.Repositories.SchedulesRepository;

public class FindScheduleUseCase {
    public static Schedule execute(String rg, LocalDate dateOfBirth, boolean hasToken) throws NotFoundDataException {
        if (hasToken) {
            BloodDonator donator = DonatorRepository.getByRG(rg);
            
            if (donator == null) throw new NotFoundDataException("Donator", "Donator com RG " + rg + " não encontrado");

            dateOfBirth = donator.getDateOfBirth();
        }

        return SchedulesRepository.findOne(rg, dateOfBirth);
    }
}
