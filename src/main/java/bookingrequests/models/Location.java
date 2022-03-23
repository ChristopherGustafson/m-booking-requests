package bookingrequests.models;

public class Location implements SuggestionAspect{
    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Returns the distance to a given location l
    // Calculated as sqrt((x2-x1)^2 + (y2-y1)^2)
    public double distanceTo(Location l) {
        return Math.sqrt(Math.pow(l.x - this.x, 2) + Math.pow(l.y - this.y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // TODO: Throw proper exception SuggestionAspect is not location
    // TODO: Add distance cutoff as parameter

    // Calculates the score of the location compared to some requestLocation
    @Override
    public double score(SuggestionAspect requestAspect) {
        if(!(requestAspect instanceof Location))
            throw new IllegalArgumentException("Can only calculate score compared to other Location");
        Location requestLocation = (Location) requestAspect;

        double distanceCutoff = 50.0;
        double distance = distanceTo(requestLocation);

        // Calculate the score as (distanceCutoff - distance) / distanceCutoff
        // Which gives a score between 0-1 where smaller distance give higher scores
        // If the distance is larger or equal to the distance cutoff it always scores 0
        if(distance < distanceCutoff) return (distanceCutoff-distance)/distanceCutoff;
        else return 0.0;
    }
}
