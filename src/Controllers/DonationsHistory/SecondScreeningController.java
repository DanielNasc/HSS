package Controllers.DonationsHistory;

import Errors.GenericAppException;
import Model.Repositories.AdminsRepository;
import UseCases.DonationsHistory.SecondScreeningUseCase;
import Utils.RequestTypesChecker;
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
        String[] payloadTypes = {"any", "any", "any"};

        try {
            RequestTypesChecker checker = new RequestTypesChecker(payload, payloadTypes, 3);
            checker.runChecks();

            int[] clinicalScreeningOffsideQuestions = new int[payload[1].length()];

            for (int i = 0; i < payload[1].length(); i++) {
                clinicalScreeningOffsideQuestions[i] = Integer.parseInt(payload[1].charAt(i) + "");
            }

            boolean hypertensive = payload[2] == "1";

        
            SecondScreeningUseCase.execute(payload[0], clinicalScreeningOffsideQuestions, hypertensive);
        } catch(GenericAppException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }

        return new Response(200, "Doação bem sucedida", null, null);
    }
}
