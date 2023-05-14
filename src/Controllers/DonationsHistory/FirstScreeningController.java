package Controllers.DonationsHistory;

import Model.Repositories.AdminsRepository;
import UseCases.DonationsHistory.FirstScreeningUseCase;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class FirstScreeningController {
    public static Response handle(Request request) {
        String[] tokenData = Token.BreakToken(request.getToken());

        if (tokenData == null || tokenData[0] != "ADM" || AdminsRepository.getById(tokenData[1]) == null) {
            return new Response(403, "Operação não permitida", null, null);
        }

        String[] payload = request.getPayload();
        boolean[] clinicalScreeningOffsideQuestions = new boolean[payload[1].length()];

        for (int i = 0; i < payload[1].length(); i++) {
            clinicalScreeningOffsideQuestions[i] = payload[1].charAt(i) != '0';
        }

        try {
            FirstScreeningUseCase.execute(payload[0], clinicalScreeningOffsideQuestions);
        } catch (Error err) {
            return new Response(400, err.getMessage(), null, clinicalScreeningOffsideQuestions);
        }

        return new Response(200, "Tudo certo, prosseguir para a próxima etapa de perguntas (Perguntas Influẽnciáveis)", null, null);
    }
}
