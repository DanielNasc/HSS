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

        Card card = GetCardUseCase.execute(rg);

        if (card == null) {
            return new Response(400, " Não é possível criar uma carteirinha para essa conta.", null, null);
        }

        return new Response(200, "Carteirinha criada.", null, card);
    }
}
