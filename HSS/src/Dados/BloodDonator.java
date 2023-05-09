package Dados;

import java.time.LocalDate;

public class BloodDonator {
    private String name;
    private String cpf;
    private String email;
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
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.age = geraIdade(dateOfBirth);
        this.sex = sex;
        this.registred = false;
        this.bloodType = bloodType;
        this.address = address;
        this.donationStep = 0;
        this.donationsCounter = 0;
    }
    public static int geraIdade(final LocalDate aniversario) {
        final LocalDate dataAtual = LocalDate.now();
        final int Ano = dataAtual.getYear() - aniversario.getYear() - 1;
        final int Mes = aniversario.getMonthValue();
        final int Dia = aniversario.getDayOfMonth();
        if (dataAtual.getMonthValue() > Mes || dataAtual.getMonthValue() == Mes && dataAtual.getDayOfMonth() >= Dia) {
            return Ano + 1;
        }
        return Ano;
    }
    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public int getIAge() {
        return age;
    }
    public String getSex() {
        return sex;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
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
