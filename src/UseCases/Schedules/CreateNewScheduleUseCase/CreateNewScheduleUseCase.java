package UseCases.Schedules.CreateNewScheduleUseCase;

import java.time.LocalDate;

import Dados.Schedule;
import Armazenamento.SchedulesRepository;

public class CreateNewScheduleUseCase {
    public static void execute(String rg, LocalDate dateOfBirth) {
        Schedule schedule = new Schedule(rg, dateOfBirth);

        if (SchedulesRepository.add(schedule)) {
            System.out.println("Agendamento realizado com sucesso!");
        } else {
            System.out.println("Agendamento não realizado. Já existe um agendamento com esse RG e/ou data de nascimento.");
        }
    } 
}
