package App;

import Controllers.Admins.LoginController;
import Controllers.BloodDonator.CreateDonatorController;
import Controllers.DonationsHistory.FirstScreeningController;
import Controllers.DonationsHistory.GetExamsController;
import Controllers.DonationsHistory.SecondScreeningController;
import Controllers.Schedules.CreateNewScheduleController;
import Controllers.Schedules.FindScheduleUseCaseController;
import Model.Entities.Admin;
import Model.Repositories.AdminsRepository;
import WebFake.Request;
import WebFake.Response;
import WebFake.Token;

enum Context {
    GUEST, DONATOR, ADMIN
}

public class AppSimulator {
    // private static String token = null;
    private static Context ctx = Context.GUEST;
    private static String token;

    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String ANSI_RESET = "\u001B[0m";

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
                    donatorContext();
                break;
                case ADMIN:
                    adminContext();
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

                if (response.getStatus() == 200) {
                    ctx = Context.ADMIN;
                }

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

        handleResponse(response);
    }

    public static void donatorContext() {
        int choose = IOHelper.donatorMenu();
        Response response = new Response(0, null, null, null);
        Request request;
        String rg;

        switch(choose) {
            case 1: // create profile
                String[] createProfileFormData = IOHelper.getStringArray(new String[] {
                    "Digite seu nome", "Digite seu cpf", "Digite seu email",
                    "Digite seu Rg", "Digite sua data de nascimento",
                    "Digite seu gênero (0 - Homem, 1 - Mulher)",
                    "Digite o tipo sanguíneo",
                    "Digite seu endereço"
                });

                request = new Request(createProfileFormData, token);

                response = CreateDonatorController.handle(request);
                break;
            case 2: // exams
                rg = Token.GetID(token);

                if (rg.equals(null)) {
                    ctx = Context.GUEST;
                    break;
                }
                
                request = new Request(new String[] {rg}, token);

                response = GetExamsController.handle(request);
            case 3: // carteirinha
                
            case 4: // agendamento
                rg = Token.GetID(token);

                if (rg == null) {
                    ctx = Context.GUEST;
                    break;
                }
            
                request = new Request(new String[] {rg}, token);
                response = FindScheduleUseCaseController.handle(request);
            case 5: // logout
                ctx = Context.GUEST;
                break;
            default:
                IOHelper.printError("Opção inválida");
            break;
        }
        
        handleResponse(response);
    }

    public static void adminContext() {
        int choose = IOHelper.adminMenu();
        Response response = new Response(200, BLUE_BOLD, BLACK_BOLD, ANSI_RESET);
        Request request;

        switch(choose) {
            case 1: // modify schedule
                break;
            case 2:
                String rg;
                System.out.print("Digite o RG: ");
                rg = IOHelper.getLine();

                // First
                String answers = IOHelper.generateStringWithResponseInRange(new String[] {
                    "Está com gripe?",
                    "Tem obesidade?",
                    "Tem AIDS?",
                    "Realizou transplante de órgãos ou de medula?",
                    "Já teve hepatite após os 11 anos de idade?",
                    "Já teve malária?",
                    "Tem doença de chagas?",
                    "Já teve algum tipo de cancêr?",
                    "Tem graves problemas no pulmão, coração, rins ou fígado.",
                    "Já teve doenças como: tuberculose extra-pulmonar, elefantíase, hanseníase, calazar, leishmaniose tegumentar ou cutânea, brucelose, ou esquistossomose hepatoesplênica?",
                    "Tem problema de coagulação de sangue?",
                    "É diabético com complicações vasculares ou em uso de insulina?",
                    "Recebeu alguma vacina nas últimas 48 horas?",
                    "Teve diarreia, sintomas de gripe ou resfriado, conjuntivite, extração dentária ou tratamento de canal nos últimos 7 dias?",
                    "Teve Rubéola, Erisipela ou uso de antibióticos nas últimas 2 semanas?",
                    "Teve Dengue, Febre Amarela, passou por cirurgia com anestesia geral ou recebeu soro antitetânico nas últimas 4 semanas?",
                    "Fez Tatuagem, maquiagem definitiva ou micropigmentação no último ano?",
                    "Tem piercing?",
                    "Recebeu transfução de sangue no último ano?",
                    "Tem mal de Parkinson?"
                }, 0, 1);

                Request firstRequest = new Request(new String[] {rg, answers}, token);

                Response firstResponse = FirstScreeningController.handle(firstRequest);

                handleResponse(firstResponse);
                if (firstResponse.getStatus() != 200) {
                    return;
                }

                // Second
                /*
                 * 1 - bloodPressureInfluence
                 * 2 - heartBeatsInfluence
                 * 3 - hemoglobinInfluence
                 * 4 - all
                */
                
                answers = IOHelper.generateStringWithResponseInRange(new String[] { 
                    "Tem histórico de Hipertensão?",
                    "Não conseguiu descansar bem?",

                    "Tem histórico de Ansiedade?",
                    "Fez algum esforço físico recentemente?",

                    "Teve sintomas de desidratação recentemente?",
                    "Tem Anemia?",
                    "Tem sentido fraqueza ou cansaço recentemente?",
                    "Tem apresentado alguma sintoma de desidratação?",

                    "É fumante?"
                }, 0, 1);

                String IQ = "";

                if (Integer.parseInt(answers.substring(0, 1)) != 0) {
                    IQ += "1";
                }
                if (Integer.parseInt(answers.substring(2, 3)) != 0) {
                    IQ += "2";
                }
                if (Integer.parseInt(answers.substring(4, 7)) != 0) {
                    IQ += "3";
                }
                if (IQ.length() == 3 || answers.charAt(8) != '0') {
                    IQ = "4";
                }

                String hypertense = answers.charAt(0) + "";

                request = new Request(new String[] {
                    rg, IQ, hypertense
                }, token);
                response = SecondScreeningController.handle(request);
                break;
            default:
                System.out.println("Opção inválida");
                return;
        }

        handleResponse(response);
    }

    public static void handleResponse(Response response) {
        if (response.getToken() != null) {
            token = response.getToken();
            String type = Token.GetType(token);

            if (type.equals("ADM")) {
                ctx = Context.ADMIN;
            } else if (type.equals("DONATOR")) {
                ctx = Context.DONATOR;
            }
        }

        IOHelper.printResponse(response);
    }
}
