package Armazenamento;

import java.util.ArrayList;
import Dados.Schedule;

public class SchedulesRepository {
    private static ArrayList<Schedule> schedules = new ArrayList<Schedule>();

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

    public static ArrayList<Schedule> getByRg(String rg) {
        ArrayList<Schedule> schedulesByRg = new ArrayList<Schedule>();
        for (Schedule schedule : schedules) {
            if (schedule.getRg().equals(rg)) {
                schedulesByRg.add(schedule);
            }
        }
        return schedulesByRg;
    }

    public static ArrayList<Schedule> getByDay(String day) {
        ArrayList<Schedule> schedulesByDay = new ArrayList<Schedule>();
        for (Schedule schedule : schedules) {
            if (schedule.getDate().toString().equals(day)) {
                schedulesByDay.add(schedule);
            }
        }
        return schedulesByDay;
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

}