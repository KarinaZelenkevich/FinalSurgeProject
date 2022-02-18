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
                .Desc(faker.toString())
                .Distance("10")
                .DistType("km")
                .Duration("1:00:00")
                .distType("km")
                .pace("10:20")
                .paceType("min/100m")
                .howIFelt("Good")
                .perceivedEffort("4 (Moderate)")
                .postDesc("Next time I run better")
                .build();


    }
}
