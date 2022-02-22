package models;

import com.github.javafaker.Faker;

public class ProfileFactory {
    static Faker faker = new Faker();

    public static Profile getFillingProfileForm() {
        return Profile.builder()
                .name(faker.funnyName().name())
                .lastName(faker.funnyName().name())
                .gender("Female")
                .birthday(faker.date().birthday().toString())
                .weight("60")
                .country("Belarus")
                .state("Minskaya voblasts")
                .city("Minsk")
                .zip("222301")
                .build();

    }
}
