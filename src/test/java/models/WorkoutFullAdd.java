package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class WorkoutFullAdd {
    String date;
    String time;
    String workoutName;
    String description;
    String Distance;
    String Duration;
    String Pace;
    String howIFelt;
    String perceivedEffort;
    String minHR;
    String avgHR;
    String maxHR;
    String caloriesBurned;
}
