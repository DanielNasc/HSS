package Controllers.BloodDonator;

import Model.Entities.Card;
import UseCases.Donator.GetCardUseCase;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class GetCardController {
    public static Response handle(Request request) {
        String rg = Token.GetID(request.getToken());

        if (rg == null) {
            return new Response(403, "Operação não permitida", null, null);
        }


        try {
            Card card = GetCardUseCase.execute(rg);
            return new Response(200, "Carteirinha criada.", null, card);
        } catch (Exception err) {
            return new Response(404, err.getMessage(), null, null);
        }
    }
}
