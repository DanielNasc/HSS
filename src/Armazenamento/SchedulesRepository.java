package Armazenamento;

import java.util.ArrayList;
import Dados.Schedule;

public class SchedulesRepository {
    private static ArrayList<Schedule> schedules = new ArrayList<Schedule>();

    public static void add(Schedule schedule) {
        if (checkIfScheduleAlreadyExists(schedule)) {
            return;
        }

        schedules.add(schedule);
    }

    public static boolean checkIfScheduleAlreadyExists(Schedule schedule) {
        for (Schedule s : schedules) {
            if (s.equals(schedule)) {
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

}