package models;

import com.github.javafaker.Faker;

public class CaloricNeedsFactory {
    static Faker faker = new Faker();

    public static CaloricNeeds getDataFromTheForm() {
        return CaloricNeeds.builder()
                .weight("60")
                .height("170")
                .age("25")
                .gender("female")
                .distance("10")
                .build();
    }
}
