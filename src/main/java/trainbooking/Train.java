package trainbooking;

/** A train service offered for booking. */
public class Train {
    private final String trainNumber;
    private final String trainName;
    private final String source;
    private final String destination;
    private final String departureTime;
    private final double fare;
    private int availableSeats;

    public Train(String trainNumber, String trainName, String source, String destination,
                 String departureTime, double fare, int availableSeats) {
        if (trainNumber == null || trainNumber.trim().isEmpty()) throw new IllegalArgumentException("Train number is required.");
        if (trainName == null || trainName.trim().isEmpty()) throw new IllegalArgumentException("Train name is required.");
        if (source == null || source.trim().isEmpty() || destination == null || destination.trim().isEmpty()) throw new IllegalArgumentException("Route is required.");
        if (fare < 0 || availableSeats < 0) throw new IllegalArgumentException("Fare and seats cannot be negative.");
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.fare = fare;
        this.availableSeats = availableSeats;
    }

    public String getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public double getFare() { return fare; }
    public int getAvailableSeats() { return availableSeats; }

    public boolean reserveSeat() {
        if (availableSeats == 0) return false;
        availableSeats--;
        return true;
    }

    public void releaseSeat() { availableSeats++; }

    @Override
    public String toString() {
        return String.format("%-8s %-22s %-15s -> %-15s %-10s Rs. %-8.2f Seats: %d",
                trainNumber, trainName, source, destination, departureTime, fare, availableSeats);
    }
}
