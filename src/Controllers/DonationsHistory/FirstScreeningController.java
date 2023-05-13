package Controllers.DonationsHistory;

import UseCases.DonationsHistory.FirstScreeningUseCase;
import WebFake.Request;
import WebFake.Response;

public class FirstScreeningController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();
        boolean[] clinicalScreeningOffsideQuestions = new boolean[payload[1].length()];

        for (int i = 0; i < payload[1].length(); i++) {
            clinicalScreeningOffsideQuestions[i] = payload[1].charAt(i) != '0';
        }

        FirstScreeningUseCase.execute(payload[0], clinicalScreeningOffsideQuestions);

        return new Response(200, "", null, null);
    }
}
