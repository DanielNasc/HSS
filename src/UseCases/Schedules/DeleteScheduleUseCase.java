package UseCases.Schedules;

import Errors.NotFoundDataException;
import Model.Repositories.SchedulesRepository;

public class DeleteScheduleUseCase {
    public void execute(String rg) throws NotFoundDataException {
        if (!SchedulesRepository.removeByRg(rg)) {
            throw new NotFoundDataException("Schedule", "Agendamento para o RG " + rg + " não encontrado");
        } 
    }
}
