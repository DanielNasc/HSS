package Model.Entities;

import java.time.LocalDate;

public class BloodDonator extends Person {
    private String rg;
    private LocalDate dateOfBirth;
    private int age;
    private int gender;
    private String bloodType;
    private String address;
    private int donationsCounter;
    private LocalDate lastExam;

    public BloodDonator(
            String name,
            String cpf,
            String email,
            LocalDate dateOfBirth,
            int gender,
            String bloodType,
            String address,
            String rg
        ) {
        super(name, cpf, email);
        this.rg = rg;
        this.dateOfBirth = dateOfBirth;
        this.age = geraIdade(dateOfBirth);
        this.gender = gender;
        this.bloodType = bloodType;
        this.address = address;
        this.donationsCounter = 0;
    }
    private static int geraIdade(final LocalDate aniversario) {
        final LocalDate dataAtual = LocalDate.now();
        final int Ano = dataAtual.getYear() - aniversario.getYear() - 1;
        final int Mes = aniversario.getMonthValue();
        final int Dia = aniversario.getDayOfMonth();
        if (dataAtual.getMonthValue() > Mes || dataAtual.getMonthValue() == Mes && dataAtual.getDayOfMonth() >= Dia) {
            return Ano + 1;
        }
        return Ano;
    }
    public void addDonation() {
        this.donationsCounter++;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public int getAge() {
        return age;
    }
    public int getGender() {
        return gender;
    }
    public String getBloodType() {
        return bloodType;
    }
    public String getAddress() {
        return address;
    }
    public void setAdress(String address) {
        this.address = address;
    }
    public LocalDate getLastExam() {
        return lastExam;
    }
    public void setLastExam(LocalDate lastExam) {
        this.lastExam = lastExam;
    }
    public int getDonationsCounter() {
        return donationsCounter;
    }
    public String getRG(){
        return rg;
    }
    public boolean equals(BloodDonator bloodDonator) {
        return this.rg.equals(bloodDonator.getRG());
    }
}
