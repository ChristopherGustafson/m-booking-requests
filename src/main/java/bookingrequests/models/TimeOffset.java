package bookingrequests.models;

import java.awt.print.Book;
import java.sql.Time;

public class TimeOffset implements SuggestionAspect {
    private int timeOffset;

    public TimeOffset(int timeOffset) {
        this.timeOffset = timeOffset;
    }

    public void setTimeOffset(int timeOffset) {
        this.timeOffset = timeOffset;
    }

    public int getTimeOffset() {
        return timeOffset;
    }

    // TODO: Add timeOffsetCutoff as argument
    // Calculates the score of this TimeOffset compared to a given request
    // Score calculated as 1.0 - offset / offsetCutoff
    // This gives a score between 0-1, if the offset is larger than the
    // cutoff score is always 0.
    // Idea: calculate score differently depending on if offset is
    // negative (car available earlier) or positive (car available later)
    @Override
    public double score(BookingRequest bookingRequest) {
        TimeOffset requestOffset = bookingRequest.getTimeOffset();

        double offsetMagnitude = Math.abs(getTimeOffset() - requestOffset.getTimeOffset());
        double timeOffsetCutoff = 120.0;

        if (offsetMagnitude < timeOffsetCutoff) return 1.0 - offsetMagnitude / timeOffsetCutoff;
        else return 0.0;
    }

    @Override
    public String toString() {
        return String.valueOf(timeOffset);
    }
}
