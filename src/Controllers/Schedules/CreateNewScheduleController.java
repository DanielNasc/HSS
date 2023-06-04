package Controllers.Schedules;

import java.time.LocalDate;

import Errors.GenericAppException;
import UseCases.Schedules.CreateNewScheduleUseCase;
import Utils.RequestTypesChecker;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class CreateNewScheduleController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();

        String[] payloadTypes = {"string", "date"};


        LocalDate dateOfBirth;

        try {
            RequestTypesChecker checker = new RequestTypesChecker(payload, payloadTypes, 2);
            checker.runChecks();

            String[] date = payload[1].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            dateOfBirth = LocalDate.of(year, month, day);

            boolean creationResult = CreateNewScheduleUseCase.execute(payload[0], dateOfBirth);
            String token = Token.CreateToken("DONATOR", payload[0]);

            if (creationResult) {
                return new Response(200, "Agendamento criado", token, null);
            } else {
                return new Response(400, "Agendamento já existe", null, null);
            }
        } catch (GenericAppException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }
    }
}
