package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaceCalculator extends CaloricNeedsFactory {
    String distance;
    String hours;
    String minutes;
    String seconds;

}
