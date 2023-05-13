package UseCases.Schedules.CreateNewSchedule;

public class CreateNewScheduleController {
    private static CreateNewScheduleUseCase createNewScheduleUseCase = new CreateNewScheduleUseCase();

    public static void handle() {
        createNewScheduleUseCase.execute(null, null);
    }
}
