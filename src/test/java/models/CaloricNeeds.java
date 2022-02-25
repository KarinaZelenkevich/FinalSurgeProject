package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CaloricNeeds {

        String weight;
        String height;
        String age;
        String gender;
        String distance;

}
