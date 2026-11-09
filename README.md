# Train Booking System

A console-based Java application for viewing train services, searching routes, booking a seat, listing bookings, and cancelling a booking. It is designed as a small Software Engineering/OOP assignment project and runs on Java 8 or later.

## Features

- View sample train services and their remaining seat counts
- Search using a source and destination
- Book a seat and receive a booking ID
- View confirmed and cancelled bookings
- Cancel a booking and return its seat to availability
- Validate passenger details and handle unavailable trains/seats

## OOP design

- `Train` encapsulates route, fare, and seat availability.
- `Passenger` encapsulates validated passenger details.
- `Booking` associates one passenger with one train and tracks its status.
- `BookingStatus` is an enum for confirmed and cancelled states.
- `TrainBookingService` owns the booking rules and data operations.
- `TrainBookingApp` provides the console interface and `main` application method.

## Run

From the project root, compile and run with a JDK:

```sh
javac -d out src/main/java/trainbooking/*.java
java -cp out trainbooking.TrainBookingApp
```

The included train and booking data is held in memory and resets when the application exits.

## GitHub repository

[View the Train Booking System repository](https://github.com/santhoshnarayanan-creator/TRAIN-BOOKING-SYSTEM)
