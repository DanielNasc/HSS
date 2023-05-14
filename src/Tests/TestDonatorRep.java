package Tests;
import Model.Entities.BloodDonator;
import Model.Repositories.DonatorRepository;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class TestDonatorRep {
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
    //create another new BloodDonator object
    BloodDonator lumaBloodDonator = new BloodDonator(
        "Luma",
        "97898546456",
        "Luma@gmail",
        LocalDate.of(1999, 07, 05),
        0,
        "O-",
        "Rua 3",
        "10987654321"
    );

    @Test
    public void testAddDonator() {
        //add the BloodDonator object to the DonatorRepository
        DonatorRepository.addDonator(luannBloodDonator);
        DonatorRepository.addDonator(lumaBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2, DonatorRepository.numberOfDonators());
        DonatorRepository.clear();
    }

    @Test
    public void testCheckDonator() {
        //add the BloodDonator object to the DonatorRepository
        DonatorRepository.addDonator(luannBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(true, DonatorRepository.checkDonator("12345678910"));
        DonatorRepository.clear();
    }
    @Test
    public void testGetAll() {
        //add the BloodDonator object to the DonatorRepository
        DonatorRepository.addDonator(luannBloodDonator);
        DonatorRepository.addDonator(lumaBloodDonator);
        
        DonatorRepository.getAll();

        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2  , DonatorRepository.numberOfDonators());    
        DonatorRepository.clear();
    }
    @Test
    public void testGetByCPF() {
        //add the BloodDonator object to the DonatorRepository
        DonatorRepository.addDonator(luannBloodDonator);
        DonatorRepository.addDonator(lumaBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(luannBloodDonator, DonatorRepository.getByCPF("12345678910"));
        DonatorRepository.clear();
    }
    @Test
    public void testRemoveByCPF() {
        //add the BloodDonator object to the DonatorRepository
        DonatorRepository.addDonator(luannBloodDonator);
        DonatorRepository.addDonator(lumaBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2, DonatorRepository.numberOfDonators());
        //remove the BloodDonator object from the DonatorRepository
        DonatorRepository.removeByCPF("12345678910");
        //check if the BloodDonator object was removed from the DonatorRepository
        assertEquals(1, DonatorRepository.numberOfDonators());
        DonatorRepository.clear();
    }
}
