package bookingrequests.models;

public class CarColor implements SuggestionAspect {
    private String carColor;

    public CarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarColor() {
        return carColor;
    }

    // Returns the score of the color compared to some requested color
    // Will return a score of 0.7 if it is the same, otherwise 0.3
    // Idea: could give larger scores than 0.3 if it is not same but
    // a similar color
    @Override
    public double score(SuggestionAspect requestAspect) {
        if(!(requestAspect instanceof CarColor))
            throw new IllegalArgumentException("Can only calculate score compared to other CarColor");

        CarColor requestColor = (CarColor) requestAspect;
        if(requestColor.getCarColor().equals(getCarColor())){
            return 0.7;
        }
        else {
            return 0.3;
        }
    }

    @Override
    public String toString() {
        return carColor;
    }
}
