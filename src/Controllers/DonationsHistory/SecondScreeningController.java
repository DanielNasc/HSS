package Controllers.DonationsHistory;

import Errors.NotFoundDataException;
import Model.Repositories.AdminsRepository;
import UseCases.DonationsHistory.SecondScreeningUseCase;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class SecondScreeningController {
    public static Response handle(Request request) {
        String[] tokenData = Token.BreakToken(request.getToken());

        if (tokenData == null || !tokenData[0].equals("ADM") || AdminsRepository.getById(tokenData[1]) == null) {
            return new Response(403, "Operação não permitida", null, null);
        }

        String[] payload = request.getPayload();
        int[] clinicalScreeningOffsideQuestions = new int[payload[1].length()];

        for (int i = 0; i < payload[1].length(); i++) {
            clinicalScreeningOffsideQuestions[i] = Integer.parseInt(payload[1].charAt(i) + "");
        }

        boolean hypertensive = payload[2] == "1";

        try {
            SecondScreeningUseCase.execute(payload[0], clinicalScreeningOffsideQuestions, hypertensive);
        } catch(NotFoundDataException err) {
            return new Response(400, err.getMessage(), null, null);
        }

        return new Response(200, "Doação bem sucedida", null, null);
    }
}
