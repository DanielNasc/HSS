package App;

import java.util.Scanner;

public class IOHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int guestMenu() {
        int choose;
        System.out.println("Selecione uma opção");

        System.out.println("1 - Checar Agendamento");
        System.out.println("2 - Logar como Admin");
        System.out.println("3 - Doador de primeira viagem");

        choose = scanner.nextInt();
        scanner.nextLine();
        return choose;
    }

    public static int adminMenu() {
        int choose;
        System.out.println("Selecione uma opção");

        System.out.println("1 - Modificar agendamento");
        System.out.println("2 - Realizar triagem");

        choose = scanner.nextInt();
        scanner.nextLine();
        return choose;
    }

    public static String[] getStringArray(
        String[] prompts
    ) {
        String[] results = new String[prompts.length];

        for (int i = 0; i < prompts.length; i++) {
            System.out.print(prompts[i] + ": ");
            results[i] = scanner.nextLine();
        }

        return results;
    }
}
