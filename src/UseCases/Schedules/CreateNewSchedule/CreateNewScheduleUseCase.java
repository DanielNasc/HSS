package UseCases.Schedules.CreateNewSchedule;

import java.time.LocalDate;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;

public class CreateNewScheduleUseCase {
    public void execute(String rg, LocalDate dateOfBirth) {
        Schedule schedule = new Schedule(rg, dateOfBirth);

        if (SchedulesRepository.add(schedule)) {
            System.out.println("Agendamento realizado com sucesso!");
        } else {
            System.out.println("Agendamento não realizado. Já existe um agendamento com esse RG.");
        }
    } 
}
