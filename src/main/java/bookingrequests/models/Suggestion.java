package bookingrequests.models;

public class Suggestion implements Comparable<Suggestion>{
    public CarColor carColor;
    public TimeOffset timeOffset;
    public Location location;
    public double score;

    public Suggestion(String carColor, int timeOffset, Location location){
        this.carColor = new CarColor(carColor);
        this.timeOffset = new TimeOffset(timeOffset);
        this.location = location;
        this.score = 0.0;
    }

    public Suggestion(String carColor, int timeOffset, Location location, double score){
        this.carColor = new CarColor(carColor);
        this.timeOffset = new TimeOffset(timeOffset);
        this.location = location;
        this.score = score;
    }

    public Suggestion(String carColor, int timeOffset, int x, int y){
        this.carColor = new CarColor(carColor);
        this.timeOffset = new TimeOffset(timeOffset);
        this.location = new Location(x, y);
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "carColor='" + carColor + '\'' +
                ", timeOffset=" + timeOffset +
                ", location=" + location +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Suggestion suggestion) {
        if(this.score > suggestion.score){
            return 1;
        }
        else if(this.score < suggestion.score){
            return -1;
        }
        return 0;
    }
}
