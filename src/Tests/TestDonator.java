package Tests;
import java.time.LocalDate;
import org.junit.Test;

import Model.Entities.BloodDonator;

import static org.junit.Assert.assertEquals;

public class TestDonator {
    //create a new BloodDonator object
    BloodDonator luannBloodDonator = new BloodDonator(
        "Luann",
        "12345678910",
        "luann@gmail",
        LocalDate.of(1999, 07, 05),
        0,
        "O+",
        "Rua 1",
        "10987654321"
    );

    @Test
    public void testaGetters() {
        assert(luannBloodDonator.getName().equals("Luann"));
        assert(luannBloodDonator.getCpf().equals("12345678910"));
        assert(luannBloodDonator.getEmail().equals("luann@gmail"));
        assert(luannBloodDonator.getDateOfBirth().equals(LocalDate.of(1999, 07, 05)));
        assert(luannBloodDonator.getGender() == 0);
        assert(luannBloodDonator.getBloodType().equals("O+"));
        assert(luannBloodDonator.getAddress().equals("Rua 1"));
        assert(luannBloodDonator.getRG().equals("10987654321"));
    }

    @Test
    public void testaGeraIdade() {
        assertEquals(23, luannBloodDonator.getAge());
    }
    
    @Test
    public void testaSetters() {
        luannBloodDonator.setName("Luann2");
        luannBloodDonator.setEmail("luann2@gmail");
        assertEquals("Luann2", luannBloodDonator.getName());
        assertEquals("luann2@gmail", luannBloodDonator.getEmail());
    }
}