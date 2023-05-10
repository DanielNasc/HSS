package Testes;

import Dados.Schedule;
import java.time.LocalDate;

import org.junit.Test;

public class TesteS {
    public
    //create a new Schedule object
    Schedule s = new Schedule(
        "12345678910", LocalDate.of(1999, 07, 05));
    
    //getters
    // @Test
    // public void testGetId() {
    //     assert(s.getId().length() == 12);
    // }

    @Test
    public void testGetRg() {
        assert(s.getRg().equals("12345678910"));
    }
    @Test
    public void testGetDateOfBirth() {
        assert(s.getDateOfBirth().equals(LocalDate.of(1999, 07, 05)));
    }
    @Test
    public void testGetDate() {
        try {
            assert(s.getDate().equals(LocalDate.now().plusDays(1)));
        } catch (AssertionError e) {
            assert(s.getDate().equals(LocalDate.now().plusDays(3)));
        }
    }
    //setters
    @Test
    public void testSetDate() {
        s.setDate(LocalDate.now());
        assert(s.getDate().equals(LocalDate.now()));
    }
    //toString
    @Test
    public void testToString() {
        assert(s.toString().equals("ID: " + s.getId() + "\nRG: " + s.getRg() + "\nData de nascimento: " + s.getDateOfBirth() + "\nData da doação: " + s.getDate()));
    }
}
