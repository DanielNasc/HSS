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
    //create another new BloodDonator object
    BloodDonator bd2 = new BloodDonator(
        "Luma",
        "97898546456",
        "Luma@gmail",
        LocalDate.of(1999, 07, 05),
        "F",
        "O-",
        "Rua 3"
    );
    //create a new DonatorRepository object
    DonatorRepository dr = new DonatorRepository();
    DonatorRepository dr2 = new DonatorRepository();


    @Test
    public void testAddDonator() {
        //add the BloodDonator object to the DonatorRepository
        dr.addDonator(bd);
        dr.addDonator(bd);
        dr.addDonator(bd2);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2, dr.numberOfDonators());
    }

    @Test
    public void testCheckDonator() {
        //add the BloodDonator object to the DonatorRepository
        dr.addDonator(bd);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(true, dr.checkDonator("12345678910"));
        
    }
    @Test
    public void testGetAll() {
        //add the BloodDonator object to the DonatorRepository
        dr.addDonator(bd);
        dr.addDonator(bd2);
        
        dr2.getAll();

        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2  , dr2.numberOfDonators());    
    }
    @Test
    public void testGetByCPF() {
        //add the BloodDonator object to the DonatorRepository
        dr.addDonator(bd);
        dr.addDonator(bd2);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(bd, dr.getByCPF("12345678910"));
    }
    @Test
    public void testRemoveByCPF() {
        //add the BloodDonator object to the DonatorRepository
        dr.addDonator(bd);
        dr.addDonator(bd2);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2, dr.numberOfDonators());
        //remove the BloodDonator object from the DonatorRepository
        dr.removeByCPF("12345678910");
        //check if the BloodDonator object was removed from the DonatorRepository
        assertEquals(1, dr.numberOfDonators());
    }
}
