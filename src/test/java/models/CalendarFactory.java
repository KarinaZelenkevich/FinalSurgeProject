package models;


import com.github.javafaker.Faker;

public class CalendarFactory {
    static Faker faker = new Faker();

    public static Calendar getSpotsEvent() {
        return Calendar.builder()
                .workoutDate("08/18/2022")
                .timeOfDay("6:00 AM")
                .activityType("    -Run: Long Run")
                .workoutName(faker.name().name())
                .workoutDescription(faker.toString())
                .plannedDistance("2")
                .pDistType("km")
                .plannedDuration("1:00:00")
                .distance("10")
                .distType("km")
                .duration("65:15:43")
                .pace("10:20")
                .paceType("min/100m")
                .howIFelt("Good")
                .perceivedEffort("4 (Moderate)")
                .postWorkoutNotesResults("Next time I run better")
                .overallPlace("3")
                .ageGroupPlace("2")
                .build();


    }
}
