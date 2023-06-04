package Controllers.Admins;

import Errors.NotFoundDataException;
import UseCases.Admins.LoginUseCase;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class LoginController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();

        if (payload.length != 2) {
            return new Response(400, "", null, null);
        }

        try {
            String loginResult = LoginUseCase.login(payload[0], payload[1]);

            if (loginResult != null) {
                String token = Token.CreateToken("ADM", loginResult);
                return new Response(200, "Login bem sucedido", token, null);
            } else {
                return new Response(400, "Dados de login inválidos", null, null);
            }
        } catch (NotFoundDataException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }
    }
}
