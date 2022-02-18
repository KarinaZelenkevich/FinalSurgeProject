package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Calendar {

    String workoutDate;
    String timeOfDay;
    String activityType;
    String workoutName;
    String Desc;
    String Distance;
    String DistType;
    String Duration;
    String distType;
    String pace;
    String paceType;
    String howIFelt;
    String perceivedEffort;
    String postDesc;
}
