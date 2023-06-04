package Controllers.DonationsHistory;

import java.util.ArrayList;

<<<<<<< HEAD
import Errors.NotFoundDataException;
=======
import Errors.GenericAppException;
>>>>>>> Daniel
import Model.Entities.DonationRegistry;
import UseCases.DonationsHistory.GetExamsUseCase;
import Utils.RequestTypesChecker;
import WebFake.Request;
import WebFake.Response;

public class GetExamsController {
    public static Response handle(Request request) {
        String[] payload = request.getPayload();
        String[] payloadTypes = {"string"};

        try{
            RequestTypesChecker checker = new RequestTypesChecker(payload, payloadTypes, 1);
            checker.runChecks();

            String rg = payload[0];

            ArrayList<DonationRegistry> registries = GetExamsUseCase.execute(rg);
            return new Response(200, "Exame encontrado", null, registries);
        } catch (GenericAppException err) {
            return new Response(err.getStatus(), err.getMessage(), null, null);
        }

    }
}
