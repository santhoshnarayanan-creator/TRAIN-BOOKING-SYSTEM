package trainbooking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Handles train search and booking operations. */
public class TrainBookingService {
    private final List<Train> trains = new ArrayList<Train>();
    private final List<Booking> bookings = new ArrayList<Booking>();
    private int nextBookingNumber = 1001;

    public TrainBookingService() {
        trains.add(new Train("12001", "Shatabdi Express", "Delhi", "Jaipur", "06:10", 850.00, 5));
        trains.add(new Train("12627", "Karnataka Express", "Bengaluru", "Delhi", "19:20", 1450.00, 4));
        trains.add(new Train("12951", "Mumbai Rajdhani", "Mumbai", "Delhi", "16:35", 2100.00, 3));
        trains.add(new Train("12839", "Chennai Mail", "Chennai", "Bengaluru", "22:00", 620.00, 6));
    }

    public List<Train> getAllTrains() { return Collections.unmodifiableList(trains); }

    public List<Train> searchTrains(String source, String destination) {
        List<Train> matches = new ArrayList<Train>();
        for (Train train : trains) {
            if (train.getSource().equalsIgnoreCase(source.trim())
                    && train.getDestination().equalsIgnoreCase(destination.trim())) matches.add(train);
        }
        return matches;
    }

    public Train findTrain(String trainNumber) {
        for (Train train : trains) if (train.getTrainNumber().equalsIgnoreCase(trainNumber.trim())) return train;
        return null;
    }

    public Booking book(String trainNumber, Passenger passenger) {
        Train train = findTrain(trainNumber);
        if (train == null) throw new IllegalArgumentException("Train not found.");
        if (!train.reserveSeat()) throw new IllegalStateException("No seats are available on this train.");
        Booking booking = new Booking("TB" + nextBookingNumber++, train, passenger);
        bookings.add(booking);
        return booking;
    }

    public Booking findBooking(String bookingId) {
        for (Booking booking : bookings) if (booking.getBookingId().equalsIgnoreCase(bookingId.trim())) return booking;
        return null;
    }

    public boolean cancel(String bookingId) {
        Booking booking = findBooking(bookingId);
        if (booking == null || booking.getStatus() == BookingStatus.CANCELLED) return false;
        booking.cancel();
        booking.getTrain().releaseSeat();
        return true;
    }

    public List<Booking> getBookings() { return Collections.unmodifiableList(bookings); }
}
