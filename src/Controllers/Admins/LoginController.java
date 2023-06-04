package Controllers.Admins;

import Errors.GenericAppException;
import UseCases.Admins.LoginUseCase;
import Utils.RequestTypesChecker;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class LoginController {
    public static Response handle(Request request) {
        
        try {
            String[] payload = request.getPayload();
            String[] payloadTypes = {"string", "string"};

            RequestTypesChecker checker = new RequestTypesChecker(payload, payloadTypes, 2);
            checker.runChecks();

            String loginResult = LoginUseCase.login(payload[0], payload[1]);

            String token = Token.CreateToken("ADM", loginResult);
            return new Response(200, "Login bem sucedido", token, null);
        } catch (GenericAppException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }
    }
}
