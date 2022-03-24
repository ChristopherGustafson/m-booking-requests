import bookingrequests.models.BookingRequest;
import bookingrequests.models.Location;
import bookingrequests.models.TimeOffset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationTest {

    @Test
    public void testTimeOffsetScore() {

        Location closeLocation = new Location(5, 5);
        Location distantLocation = new Location(15, 15);

        BookingRequest bookingRequest = new BookingRequest("BLUE", 6, 6);

        double closeLocationScore = closeLocation.score(bookingRequest);
        double distantLocationScore = distantLocation.score(bookingRequest);
        assertTrue(closeLocationScore > distantLocationScore,
                "Score of close location: " + closeLocationScore +
                        " should be higher than score of distant location: " + distantLocationScore);
    }
}
