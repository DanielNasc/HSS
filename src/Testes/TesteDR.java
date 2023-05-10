package Testes;
import Dados.BloodDonator;
import Armazenamento.DonatorRepository;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TesteDR {
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
    //create a new DonatorRepository object
    DonatorRepository dr = new DonatorRepository();

    @Test
    public void testAddDonator() {
        //add the BloodDonator object to the DonatorRepository
        dr.addDonator(bd);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(true, dr.checkDonator("12345678910"));
    }
    
}
