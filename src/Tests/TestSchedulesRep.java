package Tests;

import Model.Entities.Schedule;
import Model.Repositories.SchedulesRepository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;


public class TestSchedulesRep{
    //create a new SchedulesRepository object
    //create a new Schedule object
    private static Schedule firstSchedule = new Schedule(
        "12345678910", LocalDate.of(1983, 8, 7));
    private static Schedule secondSchedule = new Schedule(
        "98765432110", LocalDate.of(1999, 5, 5));

    
    //add
    @Test
    public void testAdd() {
        SchedulesRepository.add(firstSchedule);
        SchedulesRepository.add(secondSchedule);
        assert(SchedulesRepository.getAll().contains(firstSchedule));
        assert(SchedulesRepository.getAll().contains(secondSchedule));
        SchedulesRepository.clearRepository();
    }
    //getById
    @Test
    public void testGetById() {
        SchedulesRepository.add(firstSchedule);
        SchedulesRepository.add(secondSchedule);
        assertEquals(firstSchedule, SchedulesRepository.getById(firstSchedule.getId()));
        SchedulesRepository.clearRepository();
    }
    //getByRg
    @Test
    public void testGetByRg() {
        SchedulesRepository.add(firstSchedule);
        SchedulesRepository.add(secondSchedule);
        SchedulesRepository.clearRepository();
        }

    //removeById
    @Test
    public void testRemoveById() {
        SchedulesRepository.add(firstSchedule);
        SchedulesRepository.add(secondSchedule);
        SchedulesRepository.removeById(firstSchedule.getId());
        assert(!SchedulesRepository.getAll().contains(firstSchedule));
        assert(SchedulesRepository.getAll().contains(secondSchedule));
        SchedulesRepository.clearRepository();
    }
    //removeByRg
    @Test
    public void testRemoveByRg() {
        SchedulesRepository.add(firstSchedule);
        SchedulesRepository.add(secondSchedule);
        assertEquals(true, SchedulesRepository.removeByRg(firstSchedule.getRg()));
        assert(!SchedulesRepository.getAll().contains(firstSchedule));
        assert(SchedulesRepository.getAll().contains(secondSchedule));
        SchedulesRepository.clearRepository();
    }
}
