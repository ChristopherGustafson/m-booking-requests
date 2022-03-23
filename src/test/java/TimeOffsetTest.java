import bookingrequests.models.TimeOffset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TimeOffsetTest {

    @Test
    public void testTimeOffsetScore() {
        TimeOffset smallTimeOffset = new TimeOffset(-10);
        TimeOffset largeTimeOffset = new TimeOffset(60);

        Double smallOffsetScore = smallTimeOffset.score(new TimeOffset(0));
        Double largeOffsetScore = largeTimeOffset.score(new TimeOffset(0));

        assertTrue(smallOffsetScore > largeOffsetScore,
                "Score of small time offset: " + smallOffsetScore +
                " should be higher than score of large time offset: " + largeOffsetScore);
    }
}
