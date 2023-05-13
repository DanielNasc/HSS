package Controllers.Admins;

import UseCases.Admins.LoginUseCase;
import Utils.RandomUtils;
import WebFake.Request;
import WebFake.Response;

public class LoginController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();

        if (payload.length != 2) {
            return new Response(400, "", null, null);
        }

        try {
            boolean loginResult = LoginUseCase.login(payload[0], payload[1]);

            if (loginResult) {
                String token = RandomUtils.generateId(15);
                return new Response(200, "Login bem sucedido", token, null);
            } else {
                return new Response(400, "Dados de login inválidos", null, null);
            }
        } catch (Error err) {
            return new Response(500, "Erro desconhecido", null, null);
        }
    }
}
