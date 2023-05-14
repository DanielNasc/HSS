package Controllers.Schedules;

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

        boolean result = ChangeScheduleStatusUseCase.execute(payload[0], ScheduleStatus.FAILED);

        if (!result) {
            return new Response(400, "Agendamento não encontrado", null, null);
        }

        return new Response(200, "Agendamento atualizado", null, null);
    }
}
