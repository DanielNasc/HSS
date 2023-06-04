package Utils;

import java.util.ArrayList;

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

    private int donatorAge;
    private int donatorGender;

    private ArrayList<String> failedTests;
    
    public ClinicalScreening() {
        this.clinicalScreeningFailed = false;
        this.bloodPressureInfluence = false;
        this.heartBeatsInfluence = false;
        this.hemoglobinInfluence = false;
    }

    public ClinicalScreening(int donatorAge, int donatorGender) {
        this.clinicalScreeningFailed = false;
        this.bloodPressureInfluence = false;
        this.heartBeatsInfluence = false;
        this.hemoglobinInfluence = false;

        this.donatorAge = donatorAge;
        this.donatorGender = donatorGender;

        this.failedTests = new ArrayList<String>();
    }

    public void checkResults() {
        if (getBodyTemperature() > 37.0 ||
        (getHemoglobin() < 13.0 && donatorGender == 0) ||
        (getHemoglobin() < 12.5 && donatorGender == 1)
        ) {
            this.failedTests.add("Hemoglobina");
        }

        if (
            (getBloodPressure()[0] < 90 && getBloodPressure()[1] < 60) ||
            ((getBloodPressure()[0] > 140 && getBloodPressure()[1] > 90)) ||
            ((getBloodPressure()[0] > 180 && getBloodPressure()[1] > 100)))
            {
                this.failedTests.add("Pressão Arterial");
            }

            if (getWeight() < 50.0) {
                this.failedTests.add("Peso");
            }

            if (getHeartBeats() < 60 || getHeartBeats() > 100) {
                this.failedTests.add("Batimentos Cardíacos");
            }

            if (getIMC() < 18.5 ) {
                this.failedTests.add("IMC");
            }

        if (donatorAge < 18 || donatorAge > 69) {
            this.failedTests.add("Idade");
        }
    }

    public ArrayList<String> getFailedTests() {
        return this.failedTests;
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

    public void checkBloodPressure() {
        this.bloodPressure = RandomUtils.generateBloodPressure(this.bloodPressureInfluence, this.donatorAge, this.donatorGender);
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

    public void checkHemoglobin() {
        this.hemoglobin = RandomUtils.generateHemoglobin(this.hemoglobinInfluence, this.donatorGender);
    }

    public double getHemoglobin() {
        return this.hemoglobin;
    }

    public void checkHeight() {
        this.height = RandomUtils.generateHeight(this.donatorGender);
    }

    public double getHeigh() {
        return this.height;
    }

    public void checkWeight() {
        this.weight = RandomUtils.generateWeight(this.donatorGender);
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