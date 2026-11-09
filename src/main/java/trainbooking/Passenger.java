package trainbooking;

/** Passenger details captured for a booking. */
public class Passenger {
    private final String name;
    private final int age;
    private final String phone;

    public Passenger(String name, int age, String phone) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Passenger name is required.");
        if (age < 1 || age > 120) throw new IllegalArgumentException("Enter a valid age between 1 and 120.");
        if (phone == null || phone.trim().isEmpty()) throw new IllegalArgumentException("Phone number is required.");
        this.name = name.trim();
        this.age = age;
        this.phone = phone.trim();
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
}
