package UseCases.Schedules.DeleteScheduleUseCase;

import Model.Repositories.SchedulesRepository;

public class DeleteScheduleUseCase {
    public void execute(String rg) {
        if (SchedulesRepository.removeByRg(rg)) {
            System.out.println("Agendamento removido com sucesso!");
        } else {
            System.out.println("Agendamento não removido. Não existe um agendamento com esse RG.");
        }
    }
}
