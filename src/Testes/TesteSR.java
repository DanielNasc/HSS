package Testes;

import Armazenamento.SchedulesRepository;
import Dados.Schedule;
import java.time.LocalDate;
import org.junit.Test;


public class TesteSR {
    //create a new SchedulesRepository object
    SchedulesRepository sr = new SchedulesRepository();
    SchedulesRepository sr2 = new SchedulesRepository();
    //create a new Schedule object
    Schedule s = new Schedule(
        "12345678910", LocalDate.of(1983, 8, 7));
    Schedule s2 = new Schedule(
        "98765432110", LocalDate.of(1999, 5, 5));
    
    //add
    @Test
    public void testAdd() {
        sr.add(s);
        sr.add(s2);
        assert(sr.getAll().contains(s));
        assert(sr.getAll().contains(s2));
    }
    //getById
    @Test
    public void testGetById() {
        sr.add(s);
        assert(sr.getById(s.getId()).equals(s));
    }
    //getByRg
    @Test
    public void testGetByRg() {
        sr.add(s);
        sr.add(s2);
        assert(sr.getByRg("12345678910").contains(s));
    }
    //getByDay
    // @Test
    // public void testGetByDay() {
    //     sr.add(s);
    //     sr.add(s2);   
    //     assert(sr.getByDay("1999-5-5").contains(s2));
    // }

    //removeById
    @Test
    public void testRemoveById() {
        sr.add(s);
        sr.add(s2);
        sr.removeById(s.getId());
        assert(!sr.getAll().contains(s));
        assert(sr.getAll().contains(s2));
    }
}
