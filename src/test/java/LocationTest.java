import bookingrequests.models.Location;
import bookingrequests.models.TimeOffset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationTest {

    @Test
    public void testTimeOffsetScore() {

        Location closeLocation = new Location(5, 5);
        Location distantLocation = new Location(15, 15);

        Location requestLocation = new Location(6, 6);

        double closeLocationScore = closeLocation.score(requestLocation);
        double distantLocationScore = distantLocation.score(requestLocation);
        assertTrue(closeLocationScore > distantLocationScore,
                "Score of close location: " + closeLocationScore +
                        " should be higher than score of distant location: " + distantLocationScore);
    }
}
