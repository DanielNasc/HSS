package Controllers.Schedules;

import Errors.NotFoundDataException;
import Model.Repositories.AdminsRepository;
import UseCases.Schedules.ChangeScheduleStatusUseCase;
import Utils.enums.ScheduleStatus;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class ChangeScheduleStatusController {
    public static Response handle(Request request) {
        String[] tokenData = Token.BreakToken(request.getToken());

        if (tokenData == null || !tokenData[0].equals("ADM") || AdminsRepository.getById(tokenData[1]) == null) {
            return new Response(403, "Operação não permitida", null, null);
        }

        String[] payload = request.getPayload();

        if (payload == null || payload.length == 0) {
            return new Response(400, "RG ausente", null, null);
        }

        try {
            ChangeScheduleStatusUseCase.execute(payload[0], ScheduleStatus.FAILED);

            return new Response(200, "Agendamento atualizado", null, null);
        } catch (NotFoundDataException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }

    }
}
