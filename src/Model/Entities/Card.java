package Model.Entities;

import java.time.LocalDate;

public class Card {
    String name;
    LocalDate lastExam;

    public Card(String name, LocalDate lastExam) {
        this.name = name;
        this.lastExam = lastExam;
    }

    @Override
    public String toString() {
        return "\n==================================================\n"
            +  "Nome: " + name + "\n"
            +  "Último exame: " + lastExam.toString() + "\n"
            +  "==================================================\n";
    }
}
