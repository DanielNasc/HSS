package Controllers.DonationsHistory;

import java.util.ArrayList;

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

        ArrayList<DonationRegistry> registries = GetExamsUseCase.execute(rg);

        if (registries == null || registries.size() == 0) {
            return new Response(404, "Não foi encontrado um exame para este RG", null, null);
        }

        return new Response(200, "Exame encontrado", null, registries);
    }
}
