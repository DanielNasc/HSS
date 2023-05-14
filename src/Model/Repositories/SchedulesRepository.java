package Model.Repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import Model.Entities.Schedule;
import Utils.enums.ScheduleStatus;

public class SchedulesRepository {
    private static ArrayList<Schedule> schedules = new ArrayList<Schedule>();

    public static final SchedulesRepository INSTANCE = new SchedulesRepository();

    public static SchedulesRepository getInstance() {
        return INSTANCE;
    }

    public static boolean add(Schedule schedule) {
        if (checkIfScheduleAlreadyExists(schedule.getRg())) {
            return false;
        }

        schedules.add(schedule);

        return true;
    }

    public static boolean checkIfScheduleAlreadyExists(String rg) {
        for (Schedule s : schedules) {
            if (s.getRg().equals(rg)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Schedule> getAll() {
        return schedules;
    }

    public static Schedule getById(String id) {
        for (Schedule schedule : schedules) {
            if (schedule.getId().equals(id)) {
                return schedule;
            }
        }
        return null;
    }

    public static Schedule getByRg(String rg) {
        for (Schedule schedule : schedules) {
            if (schedule.getRg().equals(rg)) {
                return schedule;
            }
        }

        return null;
    }

    public static Schedule findOne(String rg, LocalDate dateOfBirth) {
        for (Schedule schedule : schedules) {
            if (schedule.getRg().equals(rg)) { // if rg is equal
                if (schedule.getDateOfBirth().equals(dateOfBirth) && schedule.getStatus() == ScheduleStatus.WAITING_DATE) { // and date of birth is equal
                    return schedule;
                }
                
                return null; // if rg is equal but date of birth is not equal
            }
        } 

        return null;
    }

    public static boolean updateSchedule(String rg, ScheduleStatus newStatus) {
        for (Schedule schedule: schedules) {
            if (schedule.getRg().equals(rg)) {
                schedule.changeStatus(newStatus);
                return true;
            }
        }

        return false;
    }

    public static void removeById(String id) {
        for (Schedule s: schedules) {
            if (s.getId().equals(id)) {
                schedules.remove(s);
                break;
            }
        }
    }
    public static boolean removeByRg(String rg) {
        for (Schedule s: schedules) {
            if (s.getRg().equals(rg)) {
                schedules.remove(s);
                return true;
            }
        }

        return false;
    }

    //Remove all
    public static void clearRepository() {
        schedules.clear();
    }
}