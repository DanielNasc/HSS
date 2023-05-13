package Controllers.Admins;

import App.ResponseClass;
import UseCases.Admins.LoginUseCase;
import Utils.RandomUtils;

public class LoginController {
    public static ResponseClass handle(String[] request) {
        if (request.length != 2) {
            return new ResponseClass(400, "", null);
        }

        try {
            boolean loginResult = LoginUseCase.login(request[0], request[1]);

            if (loginResult) {
                String token = RandomUtils.generateId(15);
                return new ResponseClass(200, "Login bem sucedido", token);
            } else {
                return new ResponseClass(400, "Dados de login inválidos", null);
            }
        } catch (Error err) {
            return new ResponseClass(500, "Erro desconhecido", null);
        }
    }
}
