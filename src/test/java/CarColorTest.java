import bookingrequests.models.CarColor;
import bookingrequests.models.TimeOffset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarColorTest {
    @Test
    @DisplayName("CarColor scores should be higher for cars of same colors")
    public void testCarColorScore() {
        CarColor blueColor = new CarColor("BLUE");
        CarColor greenColor = new CarColor("GREEN");

        CarColor requestColor = new CarColor("BLUE");

        double blueScore = blueColor.score(requestColor);
        double greenScore = greenColor.score(requestColor);

        assertTrue(blueScore > greenScore,
                "Score of same color car: " + blueScore +
                        " should be higher than score of car of different color: " + greenScore);
    }

}
