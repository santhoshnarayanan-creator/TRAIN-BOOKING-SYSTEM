package trainbooking;

/** A ticket booking connecting one passenger to one train. */
public class Booking {
    private final String bookingId;
    private final Train train;
    private final Passenger passenger;
    private BookingStatus status;

    public Booking(String bookingId, Train train, Passenger passenger) {
        this.bookingId = bookingId;
        this.train = train;
        this.passenger = passenger;
        this.status = BookingStatus.CONFIRMED;
    }

    public String getBookingId() { return bookingId; }
    public Train getTrain() { return train; }
    public Passenger getPassenger() { return passenger; }
    public BookingStatus getStatus() { return status; }
    public void cancel() { status = BookingStatus.CANCELLED; }

    @Override
    public String toString() {
        return String.format("Booking: %s | %s (%d) | %s to %s | Train %s | Fare: Rs. %.2f | %s",
                bookingId, passenger.getName(), passenger.getAge(), train.getSource(),
                train.getDestination(), train.getTrainNumber(), train.getFare(), status);
    }
}
