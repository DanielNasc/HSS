package App;

import java.util.Scanner;

import WebFake.Response;

public class IOHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String ANSI_RESET = "\u001B[0m";

    public static int guestMenu() {
        int choose;
        System.out.println(WHITE_BOLD + "Selecione uma opção");

        System.out.println("1 - Checar Agendamento");
        System.out.println("2 - Logar como Admin");
        System.out.println("3 - Doador de primeira viagem" + ANSI_RESET);

        choose = scanner.nextInt();
        scanner.nextLine();

        return choose;
    }

    public static int adminMenu() {
        int choose;
        System.out.println();

        System.out.println(WHITE_BOLD+"Selecione uma opção");

        System.out.println("1 - Modificar agendamento");
        System.out.println("2 - Realizar triagem");
        System.out.println("3 - Sair da conta"+ANSI_RESET);

        choose = scanner.nextInt();
        scanner.nextLine();

        return choose;
    }

    public static int donatorMenu() {
        int choose;

        System.out.println();
        System.out.println(WHITE_BOLD+"Selecione uma opção");

        System.out.println("1 - Atualizar perfil");
        System.out.println("2 - Verificar Exames");
        System.out.println("3 - Carteirnha");
        System.out.println("4 - Agendamento");
        System.out.println("5 - Sair da conta"+ANSI_RESET);

        choose = scanner.nextInt();
        scanner.nextLine();

        return choose;
    }

    public static String[] getStringArray(
        String[] prompts
    ) {
        String[] results = new String[prompts.length];

        for (int i = 0; i < prompts.length; i++) {
            System.out.print(WHITE_BOLD+prompts[i] + ": " + ANSI_RESET);
            results[i] = scanner.nextLine();
        }

        return results;
    }

    public static int getNumberInRange(int a, int b) {
        if (a > b) {
            throw new Error("Invalid range");
        }

        try {
            int number = Integer.parseInt(getLine());
            if (number < a || number > b)
                throw new Exception("Invalid number");
            return number;
        } catch (Exception err) {
            System.out.println("Digite um número no intervalo [ "+ a + ", " + b + " ]");
            return getNumberInRange(a, b);
        }
    }

    public static String getLine() {
        return scanner.nextLine();
    }

    public static String generateStringWithResponseInRange(String[] prompts, int a, int b) {
        String answers = "";

        for (String prompt: prompts) {
            System.out.print(WHITE_BOLD+ prompt + " " + ANSI_RESET);
            answers += getNumberInRange(a, b);
        }

        return answers;
    }

    public static void printResponse(Response response) {
        System.out.println();
        if (response.getStatus() >= 400) {
            System.out.println(RED_BOLD + "STATUS: " + response.getStatus());
            System.out.println("MESSAGE: " + response.getMessage());
        }
        else if (response.getStatus() >= 300) {
            System.out.println(BLUE_BOLD + "STATUS: " + response.getStatus());
            System.out.println("MESSAGE: " + response.getMessage());
        } else if (response.getStatus() >= 200) {
            System.out.println(GREEN_BOLD + "STATUS: " + response.getStatus());
            System.out.println("MESSAGE: " + response.getMessage());
        } else {
            System.out.println(WHITE_BOLD + "STATUS: " + response.getStatus());
            System.out.println("MESSAGE: " + response.getMessage());
        }

        if (response.getData() != null) {
            System.out.println(BLUE_BOLD+"DADOS: ");
            System.err.println(response.getData());
        }
        System.out.println(ANSI_RESET);
    }    

    public static void printLogo() {}

    public static void printError(String message) {
        System.out.println(RED_BOLD + message + ANSI_RESET);
    }
}
