package Controllers.Schedules;

import java.time.LocalDate;

import Model.Entities.Schedule;
import UseCases.Schedules.FindScheduleUseCase;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class FindScheduleUseCaseController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();

        if (payload.length != 2) {
            return new Response(400, "Formato de dados inválido", null, null);
        }

        LocalDate dateOfBirth;
        try {
            String[] date = payload[1].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            dateOfBirth = LocalDate.of(year, month, day);
        } catch(Exception err) {
            return new Response(400, "Dada de nascimento inválida", null, null);
        }

        try {
            Schedule schedule = FindScheduleUseCase.execute(payload[0], dateOfBirth);

            if (schedule != null) {
                String token = Token.CreateToken("DONATOR", payload[0]);
                return new Response(200, "Agendamento encontrado", token, schedule);
            } else {
                return new Response(404, "Agendamento não encontrado", null, null);
            }
        } catch (Error err) {
            return new Response(500, "Erro desconhecido", null, null);
        }
    }
}
