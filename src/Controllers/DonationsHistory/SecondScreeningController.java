package Controllers.DonationsHistory;

import UseCases.DonationsHistory.SecondScreeningUseCase;
import WebFake.Request;
import WebFake.Response;

public class SecondScreeningController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();
        int[] clinicalScreeningOffsideQuestions = new int[payload[1].length()];

        for (int i = 0; i < payload[1].length(); i++) {
            clinicalScreeningOffsideQuestions[i] = Integer.parseInt(payload[1].charAt(i) + "");
        }

        boolean hypertensive = payload[2] == "1";

        SecondScreeningUseCase.execute(payload[0], clinicalScreeningOffsideQuestions, hypertensive);

        return new Response(200, "Doação bem sucedida", null, null);
    }
}
