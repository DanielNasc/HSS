package Model.Entities;

import java.time.LocalDate;

import Utils.RandomUtils;

public class DonationRegistry {
    private String id;
    private int[] bloodPressure;
    private int heartBeats;
    private double bodyTemperature;
    private double hemoglobin;
    private double height;
    private double weight;
    private double imc;
    private String donatorID;
    private LocalDate date;

    public DonationRegistry (
        int[] bloodPressure,
        int heartBeats,
        double bodyTemperature,
        double hemoglobin,
        double height,
        double weight,
        double imc,
        String donatorID
    ) {
        this.id = RandomUtils.generateId(12);
        this.bloodPressure = bloodPressure;
        this.heartBeats = heartBeats;
        this.bodyTemperature = bodyTemperature;
        this.hemoglobin = hemoglobin;
        this.height = height;
        this.weight = weight;
        this.imc = imc;
        this.donatorID = donatorID;
        this.date = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public int[] getBloodPressure() {
        return bloodPressure;
    }
    public int getHeartBeats() {
        return heartBeats;
    }
    public double getBodyTemperature() {
        return bodyTemperature;
    }
    public double getHemoglobin() {
        return hemoglobin;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public double getIMC() {
        return imc;
    }
    public String getdonatorID() {
        return donatorID;
    }
    public LocalDate getDate() {
        return date;
    }

    public boolean equals(DonationRegistry comparedDonation) {
        return this.donatorID.equals(comparedDonation.getdonatorID())
                && this.date.equals(comparedDonation.getDate());
    }   

    public String toString() {
        // this.bloodPressure = bloodPressure;
        // this.heartBeats = heartBeats;
        // this.bodyTemperature = bodyTemperature;
        // this.hemoglobin = hemoglobin;
        // this.height = height;
        // this.weight = weight;
        // this.imc = imc;
        // this.donatorID = donatorID;
        // this.date = LocalDate.now();
        return "==================================================\n"
            +  "Pressão: " + bloodPressure + "\n"
            +  "Batimentos: " + heartBeats + "\n"
            +  "Temperatura: " + bodyTemperature + "\n"
            +  "Hemoglobinas: " + hemoglobin + "g/dL\n"
            +  "Altura: " + height + "\n"
            +  "Peso: " + weight + "Kg\n"
            +  "IMC" + imc + "\n"
            +  "Data: " + date + "\n"
            +  "==================================================\n";
    }
}
