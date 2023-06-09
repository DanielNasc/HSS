package Tests;

import org.junit.Test;

import Model.Entities.Admin;

import static org.junit.Assert.assertEquals;

public class TestAdmin {
    Admin adminTester = new Admin("Daniel", "15948726301", "admin@admin", "6zG4FgEz");

    @Test
    public void testComparePassword() {
        assertEquals(true, adminTester.comparePassword("6zG4FgEz"));
        assertEquals(false, adminTester.comparePassword("6zG4FgES"));
    }
    @Test
    public void testSetPassword(){
        adminTester.setPassword("FjR25G6s");
        assertEquals(true, adminTester.comparePassword("FjR25G6s"));
    }
}
