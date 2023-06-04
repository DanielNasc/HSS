package Controllers.DonationsHistory;

import java.util.ArrayList;

import Errors.NotFoundDataException;
import Model.Entities.DonationRegistry;
import UseCases.DonationsHistory.GetExamsUseCase;
import WebFake.Request;
import WebFake.Response;

public class GetExamsController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();

        if (payload == null || payload.length == 0) {
            return new Response(400, "Dados inválidos", null, null);
        }

        String rg = payload[0];

        try{
            ArrayList<DonationRegistry> registries = GetExamsUseCase.execute(rg);
            return new Response(200, "Exame encontrado", null, registries);
        } catch (NotFoundDataException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }

    }
}
