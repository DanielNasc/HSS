package Testes;
import Dados.Admin;
import Armazenamento.AdminsRepository;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TesteAdminsRep{
    AdminsRepository adminsRep = new AdminsRepository();
    Admin adminTester = new Admin("Daniel", "15948726301", "Daniel@gmial", "6zG4FgEz");
    Admin adminTester2 = new Admin("Dariel", "1346192857", "Dariel@gmail", "S4Fa5pLs");

    @Test
    public void testAdd() {
        adminsRep.add(adminTester);
        String id = adminTester.getId();
        assertEquals(adminTester, adminsRep.getById(id));
        adminsRep.removeAll();
    }
    @Test
    public void testGetAll() {
        adminsRep.add(adminTester);
        adminsRep.add(adminTester2);
        assertEquals(adminsRep.getAll().size(), 2);
        adminsRep.removeAll();
    }
    @Test
    public void testGetById() {
        adminsRep.add(adminTester);
        String id = adminTester.getId();
        assertEquals(adminTester, adminsRep.getById(id));
        adminsRep.removeAll();
    }
    @Test
    public void testGetAdminByEmail() {
        adminsRep.add(adminTester);
        assertEquals(adminTester, adminsRep.getAdminByEmail("Daniel@gmial"));
        adminsRep.removeAll();
    }
    @Test
    public void testRemoveById() {
        adminsRep.add(adminTester);
        adminsRep.add(adminTester2);
        adminsRep.removeById(adminTester.getId());
        assertEquals(adminsRep.getAll().size(), 1);
        adminsRep.removeAll();
    }
    
}
