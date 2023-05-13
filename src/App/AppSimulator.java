package App;

import Controllers.Admins.LoginController;
import Controllers.Schedules.CreateNewScheduleController;
import Controllers.Schedules.FindScheduleUseCaseController;
import Model.Entities.Admin;
import Model.Repositories.AdminsRepository;
import WebFake.Request;
import WebFake.Response;

enum Context {
    GUEST, DONATOR, ADMIN
}

public class AppSimulator {
    // private static String token = null;
    private static Context ctx = Context.GUEST;

    public static void main(String[] args) {
        Admin defaultAdmin = new Admin( "default", 
                                        "1234567890", 
                                        "adm@adm.com", 
                                        "default");
        AdminsRepository.add(defaultAdmin);

        while(true) {
            switch(ctx) {
                case GUEST:
                    guestContext();
                break;
                case DONATOR:
                break;
                case ADMIN:
                break;
            }
        }
    }

    public static void guestContext() {
        int choose = IOHelper.guestMenu();
        Response response;
        Request request;

        switch(choose) {
            case 1: // search schedule
                String[] findScheduleFormData = IOHelper.getStringArray(new String[] {
                    "Digite seu rg", "Digite sua data de nascimento"
                });

                request = new Request(findScheduleFormData, null);

                response = FindScheduleUseCaseController.handle(request);
                break;
            case 2: // login as admin
                String[] adminFormData = IOHelper.getStringArray(new String[] {
                    "Digite seu email", "Digite sua senha"
                });

                request = new Request(adminFormData, null);

                response = LoginController.handle(request);
                break;
            case 3: // first donation
                String[] firstDontationFormdData = IOHelper.getStringArray(new String[] {
                    "Digite seu rg", "Digite sua data de nascimento"
                });

                request = new Request(firstDontationFormdData, null);

                response = CreateNewScheduleController.handle(request);
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }

        System.out.println(response.getMessage());
        if (response.getData() != null) {
            System.out.println(response.getData());
        }
        if (response.getToken() != null) {
            // token = response.getToken();
            ctx = Context.ADMIN;
        }
    }

    public static void adminContext() {
        int choose = IOHelper.adminMenu();
        Response response;
        Request request;

        switch(choose) {
            case 1: // search schedule
                String[] findScheduleFormData = IOHelper.getStringArray(new String[] {
                    "Digite seu rg", "Digite sua data de nascimento"
                });

                request = new Request(findScheduleFormData, null);

                response = FindScheduleUseCaseController.handle(request);
                break;
            case 2: // login as admin
                String[] adminFormData = IOHelper.getStringArray(new String[] {
                    "Digite seu email", "Digite sua senha"
                });

                request = new Request(adminFormData, null);

                response = LoginController.handle(request);
                break;
            case 3: // first donation
                String[] firstDontationFormdData = IOHelper.getStringArray(new String[] {
                    "Digite seu rg", "Digite sua data de nascimento"
                });

                request = new Request(firstDontationFormdData, null);

                response = CreateNewScheduleController.handle(request);
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }
        
        
    }
}
