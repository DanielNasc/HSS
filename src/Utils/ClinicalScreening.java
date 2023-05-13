package Utils;

public class ClinicalScreening {
    private boolean clinicalScreeningFailed;
    private boolean bloodPressureInfluence;
    private boolean heartBeatsInfluence;
    private boolean hemoglobinInfluence;
    private int[] bloodPressure;
    private int heartBeats;
    private double bodyTemperature;
    private double hemoglobin;
    private double height;
    private double weight;
    private double imc;
    
    public ClinicalScreening() {
        this.clinicalScreeningFailed = false;
        this.bloodPressureInfluence = false;
        this.heartBeatsInfluence = false;
        this.hemoglobinInfluence = false;
    }

    public void checkClinicalScreeningOffsideQuestions(boolean[] answears) {
        // Se pelo menos uma resposta tiver sido true, ele não prossegue na triagem;
        int tam = answears.length;

        for(int i = 0; i < tam; i++) {
            if(answears[i]) {
                this.clinicalScreeningFailed = true;
                break;
            }
        }
    }

    public void checkClinicalScreeningInfluentialQuestions(int[] answears) {
        // Se pelo menos 1 pergunta for 1,2 ou 3, influenciará no determinado exame.
        // As perguntas influenciáveis deverão influênciar em três exames:
        // 1 - Pressão Arterial
        // 2 - Batimentos Cardíacos
        // 3 - Hemoglobina

        int tam = answears.length;
        for(int i = 0; i < tam; i++) {
            if(answears[i] == 1) {
                this.bloodPressureInfluence = true; 
                break;
            }
            if (answears[i] == 2) {
                this.heartBeatsInfluence = true;
                break;
            } 
            if (answears[i] == 3) {
                this.hemoglobinInfluence = true;
                break;
            }
        }
    }

    public boolean getClinicalScreeningFailed() {
        return this.clinicalScreeningFailed;
    }

    public boolean getBloodPressureInfluence() {
        return this.bloodPressureInfluence;
    }

    public boolean getHeartBeatsInfluence() {
        return this.heartBeatsInfluence;
    }

    public boolean getHemoglobinInfluence() {
        return this.hemoglobinInfluence;
    }

    public boolean checkIfDonorFailedClinicalScreening() {
        return this.hemoglobinInfluence;
    }

    public void checkBloodPressure(int age, int gender) {
        this.bloodPressure = RandomUtils.generateBloodPressure(this.bloodPressureInfluence, age, gender);
    }

    public int[] getBloodPressure() {
        return this.bloodPressure;
    }

    public void checkHeartBeats() {
        this.heartBeats = RandomUtils.generateHeartBeats(this.heartBeatsInfluence);
    }

    public int getHeartBeats() {
        return this.heartBeats;
    }

    public void checkBodyTemperature() {
        this.bodyTemperature = RandomUtils.generateBodyTemperature();
    }

    public double getBodyTemperature() {
        return this.bodyTemperature;
    }

    public void checkHemoglobin(int gender) {
        this.hemoglobin = RandomUtils.generateHemoglobin(this.hemoglobinInfluence, gender);
    }

    public double getHemoglobin() {
        return this.hemoglobin;
    }

    public void checkHeight(int gender) {
        this.height = RandomUtils.generateHeight(gender);
    }

    public double getHeigh() {
        return this.height;
    }

    public void checkWeight(int gender) {
        this.weight = RandomUtils.generateWeight(gender);
    }

    public double getWeight() {
        return this.weight;
    }

    // IMC = peso (kg)/(altura²)(m)

    public void checkIMC() {
        this.imc = this.weight/(Math.pow(this.height,2));
    }

    public double getIMC() {
        return this.imc;
    }

}