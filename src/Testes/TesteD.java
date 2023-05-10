package Testes;
import Dados.BloodDonator;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TesteD {
    //create a new BloodDonator object
    BloodDonator bd = new BloodDonator(
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
        assert bd.getName().equals("Luann");
        assert bd.getCpf().equals("12345678910");
        assert bd.getEmail().equals("luann@gmail");
        assert bd.getDateOfBirth().equals(LocalDate.of(1999, 07, 05));
        assert bd.getSex().equals("M");
        assert bd.getBloodType().equals("O+");
        assert bd.getAddress().equals("Rua 1");
    }

    @Test
    public void testaGeraIdade() {
        assertEquals(23, bd.getAge());
    }
    
    @Test
    public void testaSetters() {
        bd.setName("Luann2");
        bd.setEmail("luann2@gmail");
        assertEquals("Luann2", bd.getName());
        assertEquals("luann2@gmail", bd.getEmail());
    }
}
