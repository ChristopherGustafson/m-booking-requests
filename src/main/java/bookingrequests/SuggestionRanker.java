package bookingrequests;

import bookingrequests.models.BookingRequest;
import bookingrequests.models.Suggestion;
import bookingrequests.models.TimeOffset;

import java.util.*;

// TODO: Make Suggestion Ranker use a map of weight -> SuggestionAspect

public class SuggestionRanker {

    private double carColorWeight;
    private double timeOffsetWeight;
    private double locationOffsetWeight;

    public SuggestionRanker() {
        this.carColorWeight = 1.0;
        this.timeOffsetWeight = 1.0;
        this.locationOffsetWeight = 1.0;
    }

    public SuggestionRanker(double carColorWeight, double timeOffsetWeight, double locationOffsetWeight) {
        this.carColorWeight = carColorWeight;
        this.timeOffsetWeight = timeOffsetWeight;
        this.locationOffsetWeight = locationOffsetWeight;
    }

    // Return a TreeSet of ranked suggestions where the first element in the TreeSet is the highest ranked
    public TreeSet<Suggestion> rankSuggestions(List<Suggestion> suggestions, BookingRequest request) {

        // Use a TreeSet to order added Suggestions on insertion.
        TreeSet<Suggestion> ranked = new TreeSet<>(Collections.reverseOrder());

        for(Suggestion s : suggestions){
            double carColorScore = s.carColor.score(request.getCarColor());
            double timeOffsetScore = s.timeOffset.score(request.getTimeOffset());
            double locationScore = s.location.score(request.getLocation());

            // Final Score of a suggestions is a weighted sum of all SuggestionAspects
            double finalScore =
                    carColorScore * carColorWeight +
                    timeOffsetScore * timeOffsetWeight +
                    locationScore + locationOffsetWeight;

            // Set the calculated score of the Suggestion and add to order set
            s.setScore(finalScore);
            ranked.add(s);
        }

        return ranked;
    }
}
