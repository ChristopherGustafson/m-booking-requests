package bookingrequests.models;

public interface SuggestionAspect {
    // Should return a value between 0.0 and 1.0 that indicates the score of this aspect compare to
    // the requestAspect where a 1.0 means a high score, and 0.0 means a low score
    public double score(SuggestionAspect requestAspect);
}
