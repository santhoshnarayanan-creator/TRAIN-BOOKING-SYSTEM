package trainbooking;

import java.util.List;
import java.util.Scanner;

/** Console application entry point. */
public class TrainBookingApp {
    private final TrainBookingService service = new TrainBookingService();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TrainBookingApp().run();
    }

    private void run() {
        System.out.println("=== TRAIN BOOKING SYSTEM ===");
        boolean running = true;
        while (running) {
            System.out.println("\n1. View all trains\n2. Search trains\n3. Book a ticket\n4. View bookings\n5. Cancel a booking\n0. Exit");
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1: showTrains(service.getAllTrains()); break;
                case 2: searchTrains(); break;
                case 3: bookTicket(); break;
                case 4: showBookings(); break;
                case 5: cancelBooking(); break;
                case 0: running = false; System.out.println("Thank you for using the Train Booking System."); break;
                default: System.out.println("Please choose a valid menu option.");
            }
        }
        scanner.close();
    }

    private void searchTrains() {
        String source = readText("From: ");
        String destination = readText("To: ");
        List<Train> results = service.searchTrains(source, destination);
        if (results.isEmpty()) System.out.println("No trains found for that route.");
        else showTrains(results);
    }

    private void showTrains(List<Train> trains) {
        if (trains.isEmpty()) { System.out.println("No trains available."); return; }
        System.out.println("Train    Name                   From            Route            Departure  Fare       Availability");
        for (Train train : trains) System.out.println(train);
    }

    private void bookTicket() {
        String trainNumber = readText("Train number: ");
        String name = readText("Passenger name: ");
        int age = readInt("Passenger age: ");
        String phone = readText("Phone number: ");
        try {
            Booking booking = service.book(trainNumber, new Passenger(name, age, phone));
            System.out.println("Booking confirmed. Your booking ID is " + booking.getBookingId());
            System.out.println(booking);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println("Booking failed: " + ex.getMessage());
        }
    }

    private void showBookings() {
        if (service.getBookings().isEmpty()) { System.out.println("No bookings have been made."); return; }
        for (Booking booking : service.getBookings()) System.out.println(booking);
    }

    private void cancelBooking() {
        String id = readText("Booking ID: ");
        if (service.cancel(id)) System.out.println("Booking " + id + " cancelled. The seat is available again.");
        else System.out.println("Booking not found or it has already been cancelled.");
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try { return Integer.parseInt(value); }
            catch (NumberFormatException ex) { System.out.println("Enter a whole number."); }
        }
    }
}
