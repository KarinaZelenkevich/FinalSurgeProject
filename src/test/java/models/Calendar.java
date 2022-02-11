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
    String workoutDescription;
    String plannedDistance;
    String pDistType;
    String plannedDuration;
    String distance;
    String distType;
    String duration;
    String pace;
    String paceType;
    String howIFelt;
    String perceivedEffort;
    String postWorkoutNotesResults;
    String overallPlace;
    String ageGroupPlace;
}
