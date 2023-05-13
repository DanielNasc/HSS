package Controllers.Schedules;

import java.time.LocalDate;

import App.ResponseClass;
import UseCases.Schedules.CreateNewScheduleUseCase;

public class CreateNewScheduleController {
    public static ResponseClass handle(String[] request) {
        if (request.length != 2) {
            return new ResponseClass(400, "", null);
        }

        LocalDate dateOfBirth;
        try {
            String[] date = request[1].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            dateOfBirth = LocalDate.of(year, month, day);
        } catch(Exception err) {
            return new ResponseClass(400, "Dada de nascimento inválida", null);
        }

        try {
            boolean creationResult = CreateNewScheduleUseCase.execute(request[0], dateOfBirth);

            if (creationResult) {
                return new ResponseClass(200, "Agendamento criado", null);
            } else {
                return new ResponseClass(400, "Agendamento já existe", null);
            }
        } catch (Error err) {
            return new ResponseClass(500, "Erro desconhecido", null);
        }
    }
}
