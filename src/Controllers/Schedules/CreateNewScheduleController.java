package Controllers.Schedules;

import java.time.LocalDate;

import UseCases.Schedules.CreateNewScheduleUseCase;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class CreateNewScheduleController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();

        if (payload.length != 2) {
            return new Response(400, "", null, null);
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
            boolean creationResult = CreateNewScheduleUseCase.execute(payload[0], dateOfBirth);
            String token = Token.CreateToken("DONATOR", payload[0]);

            if (creationResult) {
                return new Response(200, "Agendamento criado", token, null);
            } else {
                return new Response(400, "Agendamento já existe", null, null);
            }
        } catch (Error err) {
            return new Response(500, "Erro desconhecido", null, null);
        }
    }
}
