package models;

public class PrintWorkoutsFactory {
    public static PrintWorkouts getPeriod() {
        return PrintWorkouts.builder()
                .startDate("01/02/2022")
                .endDate("02/22/2022")
                .build();
    }
}
