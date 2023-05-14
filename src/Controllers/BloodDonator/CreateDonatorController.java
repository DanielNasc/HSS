package Controllers.BloodDonator;

import java.time.LocalDate;

import UseCases.Donator.CreateDonatorUseCase;
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

        LocalDate dateOfBirth;
        try {
            String[] date = payload[4].split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            dateOfBirth = LocalDate.of(year, month, day);
        } catch(Exception err) {
            return new Response(400, "Dada de nascimento inválida", null, null);
        }
        
        int gender;
        try {
            gender = Integer.parseInt(payload[5]);
            if (gender != 0 && gender != 1) 
                throw new Exception("Invalid gender");
        } catch (Exception err) {
            return new Response(400, "Gênero inválido", null, dateOfBirth);
        }

        try {
            CreateDonatorUseCase.execute(payload[0], 
                                            payload[1], 
                                            payload[2], 
                                            payload[3], 
                                            dateOfBirth, 
                                            gender, 
                                            payload[6], 
                                            payload[7]);
        } catch (Error err) {
            return new Response(400, "Dados inválidos", null, null);
        }
        
        return new Response(200, "Perfil criado.", null, null);
   }
}
