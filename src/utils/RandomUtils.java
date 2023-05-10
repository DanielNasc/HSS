package utils;
import java.util.Random;

public class RandomUtils {
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase();
    public static final String digits = "0123456789";
    public static final String alphanum = upper + lower + digits;
    public static final Random random = new Random();

    public static String generateId(int length) {
        String buffer = "";

        for (int i = 0; i < length; i++) {
            buffer += alphanum.charAt((int) (Math.random() * alphanum.length()));
        }

        return buffer;
    }

    // Triagem
    // Realizar aferição da pressão arterial
    // Pressão Baixa: 85 - 119 mmHg / 55 - 79 mmHg
    // Pressão arterial Normal utilizada para o cálculo da hipertensão: 130 - 139 mmHg / 85 - 89 mmHg
    // Hipertensão Leve: 140 - 159 mmHg / 90 - 99 mmHg
    // Hipertensão Moderada 160 - 179 mmHg / 100 - 109 mmHg
    // Hipertesão Grave: >= 180 mmHg / >= 110 mmHg

    // Cálculo da Hipertenção Leve -> Normal + (número aleatório de 10 - 20) / Normal + (número aleatório de 5 - 10)
    // Cálculo da Hipertenção Moderada -> Normal + (número aleatório de 30 - 40) / Normal + (número aleatório de 15 - 20)
    // Cálculo da Hipertenção Grave -> Normal + 50 / Normal + 25

    // Cálculo da Pressão Normal pela Idade:
                            // Mulheres             Homens
    // Idade 18 - 29 anos: 120 mmHg / 80 mmHg       121 mmHg/ 80mmHg   (min)
    // Idade 30 - 39 anos: 122 mmHg / 81 mmHg       123 mmHg / 82 mmHg (min)
    // Idade 40 - 49 anos: 124 mmHg / 83 mmHg       127 mmHg / 84 mmHg (min)
    // Idade 50 - 69 anos: 130 mmHg / 85 mmHg       131 mmHg / 87 mmHg (min)

    public static int[] generateBloodPressure(int Status, int age, int gender) {
        int systolic = 0, diastolic = 0;
    
        switch(Status) {
            case 1: // Baixa
                systolic = random.nextInt(125 - 85) + 85;
                diastolic = random.nextInt(79 - 55) + 55;
            case 2: // Normal
            if(age >= 18 && age < 30) {
                if(gender == 1) { // woman
                    systolic = (random.nextInt(139 - 120) + 120);
                    diastolic = (random.nextInt(89 - 80) + 80);
                }
                else{ // man
                    systolic = (random.nextInt(139 - 121) + 121);
                    diastolic = (random.nextInt(89 - 80) + 80);
                }
            }
            if(age >= 30 && age < 39) {
                if(gender == 1) { // woman
                    systolic = (random.nextInt(139 - 122) + 122);
                    diastolic = (random.nextInt(89 - 81) + 81);
                }
                else{ // man
                    systolic = (random.nextInt(139 - 123) + 123);
                    diastolic = (random.nextInt(89 - 82) + 82);
                }
            }
            if(age >= 40 && age < 49) {
                if(gender == 1) { // woman
                    systolic = (random.nextInt(139 - 124) + 124);
                    diastolic = (random.nextInt(89 - 83) + 83);
                }
                else{ // man
                    systolic = (random.nextInt(139 - 127) + 127);
                    diastolic = (random.nextInt(89 - 84) + 84);
                }
            }
            if(age >= 50 && age <= 69) {
                if(gender == 1) { // woman
                    systolic = (random.nextInt(139 - 130) + 130);
                    diastolic = (random.nextInt(89 - 85) + 85);
                }
                else{ // man
                    systolic = (random.nextInt(139 - 130) + 131);
                    diastolic = (random.nextInt(89 - 87) + 87);
                }
            }
            case 3: // Alta
                if(age >= 18 && age < 30) {
                    if(gender == 1) { // woman
                        systolic = (random.nextInt(139 - 120) + 120) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 80) + 80) + (random.nextInt(25 - 5) + 5);
                    }
                    else{ // man
                        systolic = (random.nextInt(139 - 121) + 121) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 80) + 80) + (random.nextInt(25 - 5) + 5);
                    }
                }
                if(age >= 30 && age < 39) {
                    if(gender == 1) { // woman
                        systolic = (random.nextInt(139 - 122) + 122) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 81) + 81) + (random.nextInt(25 - 5) + 5);
                    }
                    else{ // man
                        systolic = (random.nextInt(139 - 123) + 123) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 82) + 82) + (random.nextInt(25 - 5) + 5);
                    }
                }
                if(age >= 40 && age < 49) {
                    if(gender == 1) { // woman
                        systolic = (random.nextInt(139 - 124) + 124) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 83) + 83) + (random.nextInt(25 - 5) + 5);
                    }
                    else{ // man
                        systolic = (random.nextInt(139 - 127) + 127) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 84) + 84) + (random.nextInt(25 - 5) + 5);
                    }
                }
                if(age >= 50 && age <= 69) {
                    if(gender == 1) { // woman
                        systolic = (random.nextInt(139 - 130) + 130) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 85) + 85) + (random.nextInt(25 - 5) + 5);
                    }
                    else{ // man
                        systolic = (random.nextInt(139 - 130) + 131) + (random.nextInt(50 - 10) + 10);
                        diastolic = (random.nextInt(89 - 87) + 87) + (random.nextInt(25 - 5) + 5);
                    }
                }
        }
        System.out.println("Pressão Arterial:" + systolic + "mmHg/" + diastolic + "mmHg");
        return new int[] {systolic, diastolic};
    }
    // Impedimentos
    // Não pode está com febre
    // Não pode está com gripe
    // Batimentos/pulso entre 60 e 100
    // Pressão Mínima: < 90mmHg / < 60 mmHg
    // Sem histórico de hipertensão: 140 mmHg / 90 mmHg
    // Com histórico de hipertensão: >= 180 mmHg / 100mmHg
    // Peso abaixo de 50 kg
    // Idade fora do intervalo entre 18 - 69 anos
    // Fora do intervalo de tempo permitido

    // Perguntas
    // Histórico de Ansiedade?
    // Histórico de Pressão Arterial Baixa ou Hipertensa?
    
}
