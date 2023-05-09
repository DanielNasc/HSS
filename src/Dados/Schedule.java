package Dados;

import java.time.LocalDate;

public class Schedule {
    String id;
    String donatorId;
    LocalDate date;
    
    Schedule(String id, String donatorId) {
        this.id = id;
        this.donatorId = donatorId;

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

    public String getDonatorId() {
        return this.donatorId;
    }

    public LocalDate getDate() {
        return this.date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
