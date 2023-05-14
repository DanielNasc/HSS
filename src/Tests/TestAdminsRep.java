package Tests;
import Model.Entities.Admin;
import Model.Repositories.AdminsRepository;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TestAdminsRep{
    Admin adminTester = new Admin("Daniel", "15948726301", "Daniel@gmial", "6zG4FgEz");
    Admin adminTester2 = new Admin("Dariel", "1346192857", "Dariel@gmail", "S4Fa5pLs");

    @Test
    public void testAdd() {
        AdminsRepository.add(adminTester);
        String id = adminTester.getId();
        assertEquals(adminTester, AdminsRepository.getById(id));
        AdminsRepository.removeAll();
    }
    @Test
    public void testGetAll() {
        AdminsRepository.add(adminTester);
        AdminsRepository.add(adminTester2);
        assertEquals(AdminsRepository.getAll().size(), 2);
        AdminsRepository.removeAll();
    }
    @Test
    public void testGetById() {
        AdminsRepository.add(adminTester);
        String id = adminTester.getId();
        assertEquals(adminTester, AdminsRepository.getById(id));
        AdminsRepository.removeAll();
    }
    @Test
    public void testGetAdminByEmail() {
        AdminsRepository.add(adminTester);
        assertEquals(adminTester, AdminsRepository.getAdminByEmail("Daniel@gmial"));
        AdminsRepository.removeAll();
    }
    @Test
    public void testRemoveById() {
        AdminsRepository.add(adminTester);
        AdminsRepository.add(adminTester2);
        AdminsRepository.removeById(adminTester.getId());
        assertEquals(AdminsRepository.getAll().size(), 1);
        AdminsRepository.removeAll();
    }
    
}
