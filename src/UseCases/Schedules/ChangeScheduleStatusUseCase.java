package UseCases.Schedules;

import Errors.NotFoundDataException;
import Model.Repositories.SchedulesRepository;
import Utils.enums.ScheduleStatus;

public class ChangeScheduleStatusUseCase {
    public static void execute(String rg, ScheduleStatus newScheduleStatus) throws NotFoundDataException {
        if (!SchedulesRepository.updateSchedule(rg, newScheduleStatus)) {
            throw new NotFoundDataException("Schedule", "Agendamento para o RG " + rg + " não encontrado");
        }

    }
}
