package Controllers.Schedules;

import java.time.LocalDate;

import Errors.NotFoundDataException;
import Model.Entities.Schedule;
import UseCases.Schedules.FindScheduleUseCase;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class FindScheduleUseCaseController {
    public static Response handle(Request request) {
        String rg = Token.GetID(request.getToken());

        String[] payload = request.getPayload();

        if (payload.length != 2 && rg == null) {
            return new Response(400, "Formato de dados inválido", null, null);
        }

        LocalDate dateOfBirth = null;
        
        if (rg == null) {
            try {
                String[] date = payload[1].split("/");
                int day = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);
                dateOfBirth = LocalDate.of(year, month, day);
            } catch(Exception err) {
                return new Response(400, "Dada de nascimento inválida", null, null);
            }
        }

        try {
            Schedule schedule = FindScheduleUseCase.execute(payload[0], dateOfBirth, rg != null);

            if (schedule != null) {
                String token = Token.CreateToken("DONATOR", payload[0]);
                return new Response(200, "Agendamento encontrado", token, schedule);
            } else {
                return new Response(404, "Agendamento não encontrado, você criou um agendamento/conta?", null, null);
            }
        } catch (NotFoundDataException err) {
            return new Response(500, err.getMessage(), null, null);
        }
    }
}
