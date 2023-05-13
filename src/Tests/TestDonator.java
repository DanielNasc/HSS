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
        "M",
        "O+",
        "Rua 1"
    );

    @Test
    public void testaGetters() {
        assert(luannBloodDonator.getName().equals("Luann"));
        assert(luannBloodDonator.getCpf().equals("12345678910"));
        assert(luannBloodDonator.getEmail().equals("luann@gmail"));
        assert(luannBloodDonator.getDateOfBirth().equals(LocalDate.of(1999, 07, 05)));
        assert(luannBloodDonator.getSex().equals("M"));
        assert(luannBloodDonator.getBloodType().equals("O+"));
        assert(luannBloodDonator.getAddress().equals("Rua 1"));
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