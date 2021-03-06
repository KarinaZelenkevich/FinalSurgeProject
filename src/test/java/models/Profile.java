package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Profile {
    String name;
    String lastName;
    String gender;
    String birthday;
    String weight;
    String weightMeasure;
    String country;
    String state;
    String city;
    String zip;
}