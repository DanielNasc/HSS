package Testes;

import Armazenamento.SchedulesRepository;
import Dados.Schedule;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;


public class TesteSchedulesRep{
    //create a new SchedulesRepository object
    SchedulesRepository repository = new SchedulesRepository();
    //create a new Schedule object
    Schedule firstSchedule = new Schedule(
        "12345678910", LocalDate.of(1983, 8, 7));
    Schedule secondSchedule = new Schedule(
        "98765432110", LocalDate.of(1999, 5, 5));

    
    //add
    @Test
    public void testAdd() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        assert(repository.getAll().contains(firstSchedule));
        assert(repository.getAll().contains(secondSchedule));
        repository.clearRepository();
    }
    //getById
    @Test
    public void testGetById() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        assertEquals(firstSchedule, repository.getById(firstSchedule.getId()));
        repository.clearRepository();
    }
    //getByRg
    @Test
    public void testGetByRg() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        repository.clearRepository();
        }

    //removeById
    @Test
    public void testRemoveById() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        repository.removeById(firstSchedule.getId());
        assert(!repository.getAll().contains(firstSchedule));
        assert(repository.getAll().contains(secondSchedule));
        repository.clearRepository();
    }
    //removeByRg
    @Test
    public void testRemoveByRg() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        assertEquals(true, repository.removeByRg(firstSchedule.getRg()));
        assert(!repository.getAll().contains(firstSchedule));
        assert(repository.getAll().contains(secondSchedule));
    }
}
