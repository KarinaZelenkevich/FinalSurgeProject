package models;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WorkoutCalculatorFactory {
    static Faker faker = new Faker();

    public static WorkoutCalculator get() {
        return WorkoutCalculator.builder()
                .selectEvent("10Km")
                .hoursIntensity("1")
                .minutesIntensity("43")
                .secondsIntensity("12")

                .raceDist("5k")
                .distanceHansons("12")
                .distType("km")
                .hoursHansons("1")
                .minutesHansons("45")
                .secondsHansons("22")
                .temperature("36")
                .tempType("°C")
                .humidity("80")
                .windSpeed("1")
                .speedType("kph")

                .distanceMillan("200m")
                .hoursMillan("1")
                .minutesMillan("462")
                .secondsMillan("552")

                .raceDistance("5820 meters")
                .hoursTinman("2")
                .minutesTinman("32")
                .secondsTinman("5")
                .gender(" Female")

                .CP("10")
                .RWC("30")
                .build();
    }
}