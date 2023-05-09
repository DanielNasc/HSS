package Armazenamento;

import java.util.ArrayList;
import Dados.Schedule;

public class SchedulesRepository {
    private static ArrayList<Schedule> schedules = new ArrayList<Schedule>();

    public static void add(Schedule schedule) {
        schedules.add(schedule);
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

    public static ArrayList<Schedule> getByDonatorId(String donatorId) {
        ArrayList<Schedule> schedulesByDonatorId = new ArrayList<Schedule>();
        for (Schedule schedule : schedules) {
            if (schedule.getDonatorId().equals(donatorId)) {
                schedulesByDonatorId.add(schedule);
            }
        }
        return schedulesByDonatorId;
    }

    public static void removeById(String id) {
        for (Schedule s: schedules) {
            if (s.getId().equals(id)) {
                schedules.remove(s);
                break;
            }
        }
    }

    public static void removeByDonatorId(String donatorId) {
        for (Schedule s: schedules) {
            if (s.getDonatorId().equals(donatorId)) {
                schedules.remove(s);
                break;
            }
        }
    }
}