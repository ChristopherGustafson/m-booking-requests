import bookingrequests.models.BookingRequest;
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

        BookingRequest request = new BookingRequest("BLUE", 0, 0);

        double blueScore = blueColor.score(request);
        double greenScore = greenColor.score(request);

        assertTrue(blueScore > greenScore,
                "Score of same color car: " + blueScore +
                        " should be higher than score of car of different color: " + greenScore);
    }

}
