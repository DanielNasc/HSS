package Tests;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;


public class TestSchedulesRep{
    //create a new SchedulesRepository object
    private static SchedulesRepository repository = new SchedulesRepository();
    //create a new Schedule object
    private static Schedule firstSchedule = new Schedule(
        "12345678910", LocalDate.of(1983, 8, 7));
    private static Schedule secondSchedule = new Schedule(
        "98765432110", LocalDate.of(1999, 5, 5));

    
    //add
    @Test
    public static void testAdd() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        assert(repository.getAll().contains(firstSchedule));
        assert(repository.getAll().contains(secondSchedule));
        repository.clearRepository();
    }
    //getById
    @Test
    public static void testGetById() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        assertEquals(firstSchedule, repository.getById(firstSchedule.getId()));
        repository.clearRepository();
    }
    //getByRg
    @Test
    public static void testGetByRg() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        repository.clearRepository();
        }

    //removeById
    @Test
    public static void testRemoveById() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        repository.removeById(firstSchedule.getId());
        assert(!repository.getAll().contains(firstSchedule));
        assert(repository.getAll().contains(secondSchedule));
        repository.clearRepository();
    }
    //removeByRg
    @Test
    public static void testRemoveByRg() {
        repository.add(firstSchedule);
        repository.add(secondSchedule);
        assertEquals(true, repository.removeByRg(firstSchedule.getRg()));
        assert(!repository.getAll().contains(firstSchedule));
        assert(repository.getAll().contains(secondSchedule));
    }
}
