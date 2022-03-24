import bookingrequests.models.BookingRequest;
import bookingrequests.models.TimeOffset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TimeOffsetTest {

    @Test
    public void testTimeOffsetScore() {
        TimeOffset smallTimeOffset = new TimeOffset(-10);
        TimeOffset largeTimeOffset = new TimeOffset(60);

        BookingRequest bookingRequest = new BookingRequest("BLUE", 0, 0);

        Double smallOffsetScore = smallTimeOffset.score(bookingRequest);
        Double largeOffsetScore = largeTimeOffset.score(bookingRequest);

        assertTrue(smallOffsetScore > largeOffsetScore,
                "Score of small time offset: " + smallOffsetScore +
                " should be higher than score of large time offset: " + largeOffsetScore);
    }
}
