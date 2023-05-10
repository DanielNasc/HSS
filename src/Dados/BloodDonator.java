package Dados;

import java.time.LocalDate;

public class BloodDonator extends Person {
    private LocalDate dateOfBirth;
    private int age;
    private String sex;
    private String bloodType;
    private String address;
    private boolean registred;
    private int donationStep;
    private int donationsCounter;

    public BloodDonator(
            String name,
            String cpf,
            String email,
            LocalDate dateOfBirth,
            String sex,
            String bloodType,
            String address
        ) {
        super(name, cpf, email);
        this.dateOfBirth = dateOfBirth;
        this.age = geraIdade(dateOfBirth);
        this.sex = sex;
        this.registred = false;
        this.bloodType = bloodType;
        this.address = address;
        this.donationStep = 0;
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
    public String getSex() {
        return sex;
    }
    public String getBloodType() {
        return bloodType;
    }
    public String getAddress() {
        return address;
    }
    public boolean isRegistred() {
        return registred;
    }
    public void setAdress(String address) {
        this.address = address;
    }
    public int getDonationStep() {
        return donationStep;
    }
    public int getDonationsCounter() {
        return donationsCounter;
    }
    public void setRegistred(boolean registred) {
        this.registred = registred;
        this.donationStep = 1;
    }
}
