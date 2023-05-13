package Controllers.Schedules;

import java.time.LocalDate;

import App.ResponseClass;
import Model.Entities.Schedule;
import UseCases.Schedules.FindScheduleUseCase;

public class FindScheduleUseCaseController {
    public static ResponseClass handle(String[] request) {
        if (request.length != 2) {
            return new ResponseClass(400, "Formato de dados inválido", null, null);
        }

        LocalDate dateOfBirth;
        try {
            String[] date = request[1].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            dateOfBirth = LocalDate.of(year, month, day);
        } catch(Exception err) {
            return new ResponseClass(400, "Dada de nascimento inválida", null, null);
        }

        try {
            Schedule schedule = FindScheduleUseCase.execute(request[0], dateOfBirth);

            if (schedule != null) {
                return new ResponseClass(200, "Agendamento encontrado", null, schedule);
            } else {
                return new ResponseClass(400, "Agendamento não encontrado", null, null);
            }
        } catch (Error err) {
            return new ResponseClass(500, "Erro desconhecido", null, null);
        }
    }
}
