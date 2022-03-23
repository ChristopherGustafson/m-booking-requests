package bookingrequests.models;

public class BookingRequest {
    private CarColor carColor;
    private TimeOffset timeOffset;
    private Location location;


    public BookingRequest(String carColor, int x, int y) {
        this.carColor = new CarColor(carColor);
        this.location = new Location(x, y);
        this.timeOffset = new TimeOffset(0);
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setTimeOffset(TimeOffset timeOffset) {
        this.timeOffset = timeOffset;
    }

    public TimeOffset getTimeOffset() {
        return timeOffset;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "carColor=" + carColor +
                ", location=" + location +
                '}';
    }
}
