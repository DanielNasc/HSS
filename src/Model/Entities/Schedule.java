package Model.Entities;

import java.time.LocalDate;

import Utils.RandomUtils;
import Utils.enums.ScheduleStatus;

public class Schedule {
    String id;
    String rg;
    LocalDate dateOfBirth;
    LocalDate date;
    ScheduleStatus status;
    
    public Schedule(String rg, LocalDate dateOfBirth) {
        this.id = RandomUtils.generateId(12);
        this.rg = rg;
        this.dateOfBirth = dateOfBirth;
        this.status = ScheduleStatus.WAITING_DATE;

        LocalDate now = LocalDate.now();
        // now + 1 day if today inst friday or saturday
        if (now.getDayOfWeek().getValue() == 5 || now.getDayOfWeek().getValue() == 6) {
            now = now.plusDays(3);
        } else {
            now = now.plusDays(1);
        }

        this.date = now;
    }

    public String getId() {
        return this.id;
    }

    public String getRg() {
        return this.rg;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public LocalDate getDate() {
        return this.date;
    }
    public ScheduleStatus getStatus() {
        return status;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void changeStatus(ScheduleStatus newStatus) {
        this.status = newStatus;
    }

    public String toString() {
        return "ID: " + this.id + "\nRG: " + this.rg + "\nData de nascimento: " + this.dateOfBirth + "\nData da doação: " + this.date;
    }
}
