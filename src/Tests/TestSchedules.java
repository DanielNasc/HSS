package Tests;

import java.time.LocalDate;

import org.junit.Test;

import Model.Entities.Schedule;

public class TestSchedules{
    public
    //create a new Schedule object
    Schedule firstSchedule  = new Schedule("12345678910", LocalDate.of(1999, 7, 5));
    
    //getters
    // @Test
    // public void testGetId() {
    //     assert(s2.getId() == "GzY2gY5pciVF");
    // }

    @Test
    public void testGetRg() {
        assert(firstSchedule.getRg().equals("12345678910"));
    }
    @Test
    public void testGetDateOfBirth() {
        assert(firstSchedule.getDateOfBirth().equals(LocalDate.of(1999, 07, 05)));
    }
    @Test
    public void testGetDate() {
        try {
            assert(firstSchedule.getDate().equals(LocalDate.now().plusDays(1)));
        } catch (AssertionError e) {
            assert(firstSchedule.getDate().equals(LocalDate.now().plusDays(3)));
        }
    }
    //setters
    @Test
    public void testSetDate() {
        firstSchedule.setDate(LocalDate.now());
        assert(firstSchedule.getDate().equals(LocalDate.now()));
    }
    //toString
    @Test
    public void testToString() {
        assert(firstSchedule.toString().equals("ID: " + firstSchedule.getId() + "\nRG: " + firstSchedule.getRg() + "\nData de nascimento: " + firstSchedule.getDateOfBirth() + "\nData da doação: " + firstSchedule.getDate()));
    }
}