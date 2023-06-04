package Controllers.BloodDonator;

import java.time.LocalDate;

import Errors.GenericAppException;
import Errors.InvalidRequestException;
import UseCases.Donator.CreateDonatorUseCase;
import Utils.RequestTypesChecker;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

public class CreateDonatorController {
    public static Response handle(Request request) {
        String[] tokenData = Token.BreakToken(request.getToken());

        if (tokenData == null || !tokenData[0].equals("DONATOR")) {
            return new Response(403, "Operação não permitida", null, null);
        }

        String[] payload = request.getPayload();
        String[] payloadTypes = {"string", "string", "string", "string", "date", "int", "string", "string"};

        LocalDate dateOfBirth;
        int gender;

        try {
            RequestTypesChecker checker = new RequestTypesChecker(payload, payloadTypes, 8);
            checker.runChecks();

            String[] date = payload[4].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            dateOfBirth = LocalDate.of(year, month, day);

            gender = Integer.parseInt(payload[5]);
            if (gender != 0 && gender != 1) 
                throw new InvalidRequestException("gender: 1 ou 0");


            CreateDonatorUseCase.execute(payload[0], 
                                            payload[1], 
                                            payload[2], 
                                            payload[3], 
                                            dateOfBirth, 
                                            gender, 
                                            payload[6], 
                                            payload[7]);
        } catch (GenericAppException err) {
            return new Response(400, "Dados inválidos", null, null);
        }
        
        return new Response(200, "Perfil criado.", null, null);
   }
}
