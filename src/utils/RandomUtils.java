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

    // Pré-Triagem

    // AFERIR PRESSÃO ARTERIAL
    // Referência: https://www.gestaods.com.br/tabela-de-pressao-arterial/

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

    // Status: 
        // 1 - Histórico de Pressão Baixa (Hipotensão)
        // 2 - Histórico de Pressão Normal
        // 3 - Histórico de Pressão Alta (Hipertensão)

    public static int[] generateBloodPressure(int status, int age, int gender) {
        int systolic = 0, diastolic = 0;
    
        switch(status) {
            case 1: // Baixa
                systolic = random.nextInt(125 - 85) + 85;
                diastolic = random.nextInt(79 - 55) + 55;
                break;
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
                break;
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
                break;
        }
        // System.out.println("Pressão Arterial:" + systolic + "mmHg/" + diastolic + "mmHg");
        return new int[] {systolic, diastolic};
    }

    // AFERIR BATIMENTOS CARDÍACOS

    // Referência: https://www.tuasaude.com/frequencia-cardiaca/#como-medir
    // Cálculo dos Pulso Normal pela Idade:
                        // Mulheres         Homens
    // Idade 18 - 29 anos: 74 - 78           70 - 73
    // Idade 30 - 39 anos: 72 - 78           71 - 75
    // Idade 40 - 49 anos: 74 - 77           72 - 76
    // Idade 50 - 69 anos: 74 - 76           70 - 75

    // Intervalo permitido: 60 - 100

    // Intervalo randômico baixo: 50 - 72
    // Intervalo randômico normal: 60 - 100
    // Intervalo randômico alto: 78 - 110

    // Status
        // 1 - Histórico de Baixo Pulso
        // 2 - Histórico de Pulso Normal
        // 3 - Histórico de Alto Pulso

    // Como os resultados não variam tanto entre idades, diferentemente do que acontece com a pressão arterial, que aumenta com o decorrer da idade, deixei o cálculo do pulso só com o intervalo.
    public static int generateHeartBeats(int status) {
        int pulse = 0;
        
        switch(status) {
            case 1:
                pulse = random.nextInt(72 - 50) + 50;
                break;
            case 2:
                pulse = random.nextInt(100 - 60) + 60;
                break;
            case 3:
                pulse = random.nextInt(110 - 78) + 78;
                break;
        }

        return pulse;
    }

    // AFERIR TEMPERATURA CORPORAL

    // Referências: https://semiologiamedica.ufop.br/temperatura-corporal, https://super.abril.com.br/mundo-estranho/qual-e-o-nivel-maximo-e-o-minimo-que-a-temperatura-do-corpo-pode-atingir/
    // Febre leve ou febrícula ou subfebril: até 37,5°C
    // Febre moderada : 37,5 a 38,5°C
    // Febre alta ou elevada: acima de 38,5°C
    // Intervalo permitido: 36,5 a 37
    // Intervalo randômico: 35,5 a 38

    public static double generateBodyTemperature() {
        return random.nextDouble(38.0 - 35.5) + 35.5;
    }

    // AFERIR DOSAGEM DE HEMOGLOBINA
    
    //  Referências: https://www.saude.ce.gov.br/2019/07/04/habitos-saudaveis-aumentam-chances-de-ser-um-potencial-doador-de-sangue/, https://www.tuasaude.com/hemoglobina/
    // Para realizar a doação é necessário que os homens apresentem hemoglobina maior ou igual de 13g/dl e as mulheres um valor de 12,5g/dl. 

    // Intervalo normal:
        // Homens: 13,0 a 18,0 g/dl
        // Mulheres: 12,5 a 16,0g/dl

    // Intervalo randômico:
        // Homens: 12,5 a 19,0 g/dl
        // Mulheres: 11,5 a 18,0 g/dl
    public static double generateHemoglobin(int gender) {
        double hemoglobin = 0.0;
        if(gender == 1) { //woman
            hemoglobin = random.nextDouble(18.0 - 11.5) + 11.5;
        }
        else { //man
            hemoglobin = random.nextDouble(19.0 - 12.5) + 12.5;
        }
        return hemoglobin;
    }

    // AFERIR ALTURA,PESO E IMC

    // Referências: https://www.unimed.coop.br/viver-bem/pais-e-filhos/estatura-por-idade, https://g1.globo.com/brasil/noticia/2010/08/metade-dos-adultos-brasileiros-esta-acima-do-peso-segundo-ibge.html
    // Intervalo permitido: pesar mais de 50 quilos e ter IMC maior ou igual a 18,5 

    // Cálculo do IMC por meio do Índice de Kettle
    // Para calcular, você deve elevar o valor da estatura ao quadrado. Depois, divida o peso pelo resultado da multiplicação.

    // IMC = peso (kg)/(altura²)(m)

    // Valores de IMC
    // Abaixo de 18,5 -> Déficit de massa corporal 
    // Entre 18,5 e 24,9 -> Massa corporal normal
    // Entre 25 e 29,9 -> Sobrepeso

    // Intervalo randômico de altura:
        // Homens: 
            // Baixa estatura: 1,58 - 1,65
            // Estatura Mediana: 1,66 - 1,79
            // Alta estatura: 1,80 - 1,90
        // Mulheres: 
            // Baixa estatura: 1,47- 1,59
            // Estatura Mediana: 1,60 - 1,69
            // Alta estatura: 1,70 - 1,79

    // Intervalo randômico de peso:
        // Homens: 
            // Para Baixa Estatura: 50,0 - 62,0
            // Para Estatura Mediana: 53,8 - 75,0
            // Para Alta estatura: 63,8 - 80,0
        // Mulheres: 
            // Para Baixa Estatura: 50,0 - 55,0
            // Para Estatura Mediana: 52,5 - 70,0
            // Para Alta estatura: 56,5 - 75,0

    // status
        // 1 - Baixa estatura
        // 2 - Estatura mediana
        // 3 - Alta estatura
        
    public static double generateHeight(int status, int gender) {
        double height = 0.0;
        
        switch(status){
            case 1:
                if(gender == 1) { //woman
                    height = random.nextDouble(1.59 - 1.47) + 1.47;
                }
                else { //man
                    height = random.nextDouble(1.65 - 1.58) + 1.58;
                }
               break; 
            case 2:
                if(gender == 1) { //woman
                    height = random.nextDouble(1.69 - 1.60) + 1.60;
                }
                else { //man
                    height = random.nextDouble(1.79 - 1.66) + 1.66;
                }
            break; 
            case 3:
                if(gender == 1) { //woman
                    height = random.nextDouble(1.79 - 1.70) + 1.70;
                }
                else { //man
                    height = random.nextDouble(1.90- 1.80) + 1.80;
                }
            break; 
        }
        return height;
    }


    // Impedimentos
    // Não pode está com febre (não poderá exceder 37° C)
    // Não pode está com gripe
    // HIV
    // Parkinson
    // Transplante de órgãos ou de medula
    // Se já teve hepatite após os 11 anos de idade
    // Teve sintomas de desidratação recentemente? (Afeta hemoglobina)
    // Se já teve malária
    // Se tem doença de chagas
    // Se teve algum tipo de cancêr
    // Se tem graves problemas no pulmão, coração, rins ou fígado.
    // Se teve doenças como: tuberculose extra-pulmonar, elefantíase, hanseníase, calazar, leishmaniose tegumentar ou cutânea, brucelose, ou esquistossomose hepatoesplênica
    // Anemia (Afeta hemoglobina)
    // Gravidez
    // Amamentando
    // Batimentos/pulso entre 60 e 100
    // Pressão Mínima: < 90mmHg / < 60 mmHg
    // Sem histórico de hipertensão: 140 mmHg / 90 mmHg
    // Com histórico de hiperte+nsão: >= 180 mmHg / 100mmHg
    // Peso abaixo de 50 kg
    // Quem tem 61 anos ou mais e nunca doou está inapto. 
    // Idade fora do intervalo entre 18 - 69 anos
    // Fora do intervalo de tempo permitido
    // Tem problema de coagulação de sangue
    // Diabético com complicações vasculares ou em uso de insulina

    // Perguntas
    // Referência: https://www.prosangue.sp.gov.br/artigos/quem_nao_pode_doar.html
    // Histórico de Ansiedade?
    // Histórico de Pressão Arterial Baixa ou Hipertensa?
    // Você descansou bem?
    // Fez algum esforço físico recentemente?
    // Está grávida?
    // Está amamentando?
    // Recebeu alguma vacina nas últimas 48 horas?
    // Teve diarreia, sintomas de gripe ou resfriado, conjuntivite, extração dentária ou tratamento de canal nos últimos 7 dias?
    // Teve Rubéola, Erisipela ou uso de antibióticos nas últimas 2 semanas?
    // Teve Dengue, Febre Amarela, passou por cirurgia com anestesia geral ou recebeu soro antitetânico nas últimas 4 semanas?
    // Fez Tatuagem, maquiagem definitiva ou micropigmentação no último ano?
    // Tem piercing?
    // Recebeu transfução de sangue no último ano?
    // É virgem?
    // É casada?
    // Já teve malária?
    // Teve contato sexual com alguma pessoa com AIDS ou com teste positivo para HIV?
    // Teve contato sexual em troca de dinheiro ou de drogas ou seus respectivos parceiros sexuais?
    // Teve contato sexual com usuário de droga endovenosa?
    // Teve contato sexual com pessoa que tenha recebido transfusão de sangue nos últimos 12 meses?
    // Sofreu algum acidente grave no último ano?
    // Teve sífilis ou gonorréia no último ano?
    // Teve câncer?
    // Tem graves problemas no pulmão, coração, rins ou fígado?
    // Tem problema de coagulação de sangue?
    // Tem diabetes? Se sim, faz uso de insulina ou tem complicações vasculares?
    // Já teve tuberculose extra-pulmonar, elefantíase, hanseníase, calazar, leishmaniose tegumentar ou cutânea, brucelose, ou esquistossomose hepatoesplênica?
    // Foi submetido a transplante de órgãos ou de medula?
    // Tem mal de Parkinson?

    
}
