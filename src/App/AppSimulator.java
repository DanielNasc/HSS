package App;

import Controllers.Admins.LoginController;
import Model.Entities.Admin;
import Model.Repositories.AdminsRepository;

enum Context {
    GUEST_HOME, SCHEDULE_SEARCH, HISTORY_SEARCH, ADMIN_LOGIN
}

public class AppSimulator {
    private String token = null;
    private static Context ctx = Context.GUEST_HOME;

    public static void main(String[] args) {
        Admin defaultAdmin = new Admin( "default", 
                                        "1234567890", 
                                        "adm@adm.com", 
                                        "default");
        AdminsRepository.add(defaultAdmin);

        while(true) {
            switch(ctx) {
                case GUEST_HOME:
                    guestContext();
                break;
                case SCHEDULE_SEARCH:
                break;
                case HISTORY_SEARCH:
                break;
                case ADMIN_LOGIN:
                break;
            }
        }
    }

    public static void guestContext() {
        int choose = IOHelper.guest();
        ResponseClass response;

        switch(choose) {
            case 1: // search schedule

                break;
            case 2: // login as admin
                String[] adminFormData = IOHelper.getStringArray(new String[] {
                    "Digite seu email", "Digite sua senha"
                });

                response = LoginController.handle(adminFormData);
                System.out.println(response.getMessage());
                break;
            case 3: // first donation
                String[] firstDontationFormdData = IOHelper.getStringArray(new String[] {
                    "Digite seu rg", "Digite sua data de nascimento"
                });

                break;
            case 4: // search history

                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }


}
