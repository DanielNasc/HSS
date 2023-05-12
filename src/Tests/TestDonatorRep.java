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
        "M",
        "O+",
        "Rua 1"
    );
    //create another new BloodDonator object
    BloodDonator lumaBloodDonator = new BloodDonator(
        "Luma",
        "97898546456",
        "Luma@gmail",
        LocalDate.of(1999, 07, 05),
        "F",
        "O-",
        "Rua 3"
    );
    //create a new DonatorRepository object
    DonatorRepository primaryDonatorRepository = new DonatorRepository();
    DonatorRepository secondaryDonatorRepository = new DonatorRepository();


    @Test
    public void testAddDonator() {
        //add the BloodDonator object to the DonatorRepository
        primaryDonatorRepository.addDonator(luannBloodDonator);
        primaryDonatorRepository.addDonator(luannBloodDonator);
        primaryDonatorRepository.addDonator(lumaBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2, primaryDonatorRepository.numberOfDonators());
    }

    @Test
    public void testCheckDonator() {
        //add the BloodDonator object to the DonatorRepository
        primaryDonatorRepository.addDonator(luannBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(true, primaryDonatorRepository.checkDonator("12345678910"));
        
    }
    @Test
    public void testGetAll() {
        //add the BloodDonator object to the DonatorRepository
        primaryDonatorRepository.addDonator(luannBloodDonator);
        primaryDonatorRepository.addDonator(lumaBloodDonator);
        
        secondaryDonatorRepository.getAll();

        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2  , secondaryDonatorRepository.numberOfDonators());    
    }
    @Test
    public void testGetByCPF() {
        //add the BloodDonator object to the DonatorRepository
        primaryDonatorRepository.addDonator(luannBloodDonator);
        primaryDonatorRepository.addDonator(lumaBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(luannBloodDonator, primaryDonatorRepository.getByCPF("12345678910"));
    }
    @Test
    public void testRemoveByCPF() {
        //add the BloodDonator object to the DonatorRepository
        primaryDonatorRepository.addDonator(luannBloodDonator);
        primaryDonatorRepository.addDonator(lumaBloodDonator);
        //check if the BloodDonator object was added to the DonatorRepository
        assertEquals(2, primaryDonatorRepository.numberOfDonators());
        //remove the BloodDonator object from the DonatorRepository
        primaryDonatorRepository.removeByCPF("12345678910");
        //check if the BloodDonator object was removed from the DonatorRepository
        assertEquals(1, primaryDonatorRepository.numberOfDonators());
    }
}
