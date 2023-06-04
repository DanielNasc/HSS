package Controllers.Schedules;

import java.time.LocalDate;

import Errors.GenericAppException;
import Model.Entities.Schedule;
import UseCases.Schedules.FindScheduleUseCase;
import Utils.RequestTypesChecker;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class FindScheduleUseCaseController {
    public static Response handle(Request request) {
        String rg = Token.GetID(request.getToken());

        String[] payload = request.getPayload();

        String[] payloadTypes = {"string", "date"};
    
        try {
            RequestTypesChecker checker = new RequestTypesChecker(payload, payloadTypes, 2);
            checker.runChecks();

            String[] date = payload[1].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            LocalDate dateOfBirth = LocalDate.of(year, month, day);

            Schedule schedule = FindScheduleUseCase.execute(payload[0], dateOfBirth, rg != null);

            if (schedule != null) {
                String token = Token.CreateToken("DONATOR", payload[0]);
                return new Response(200, "Agendamento encontrado", token, schedule);
            } else {
                return new Response(404, "Agendamento não encontrado, você criou um agendamento/conta?", null, null);
            }
        } catch (GenericAppException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }
    }
}
