package models;

import com.github.javafaker.Faker;

public class PaceCalculatorFactory {
    static Faker faker = new Faker();

    public static PaceCalculator getDataFromTheForm() {
        return  PaceCalculator.builder()
                .hours("1")
                .minutes("50")
                .seconds("00")
                .distance("10")
                .distance("Kilometers")
                .build();
    }
}
