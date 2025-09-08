package ZohoPractice;
import java.util.*;

class Booking {
    int bookingId, customerId;
    char from, to;
    int pickupTime, dropTime, amount;

    Booking(int bookingId, int customerId, char from, char to, int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return bookingId + "\t" + customerId + "\t" + from + "\t" + to + "\t" +
               pickupTime + "\t" + dropTime + "\t" + amount;
    }
}

class Taxi {
    int id;
    char currentPoint = 'A';
    int freeTime = 0; // available from this time onwards
    int totalEarnings = 0;
    List<Booking> bookings = new ArrayList<>();

    Taxi(int id) { this.id = id; }

    void addBooking(Booking b, char dropPoint, int newFreeTime) {
        bookings.add(b);
        totalEarnings += b.amount;
        currentPoint = dropPoint;
        freeTime = newFreeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Taxi-").append(id).append("    Total Earnings: Rs. ").append(totalEarnings).append("\n");
        sb.append("BookingID\tCustomerID\tFrom\tTo\tPickupTime\tDropTime\tAmount\n");
        for (Booking b : bookings) sb.append(b).append("\n");
        return sb.toString();
    }
}

class TaxiBookingSystem {
    List<Taxi> taxis = new ArrayList<>();
    int bookingCounter = 1;

    TaxiBookingSystem(int n) {
        for (int i = 1; i <= n; i++) taxis.add(new Taxi(i));
    }

    // convert A-F -> 0-5
    private int pointToIndex(char p) { return p - 'A'; }

    private int calculateFare(int distance) {
        int fare = 100; // first 5 km
        int remaining = distance - 5;
        if (remaining > 0) fare += remaining * 10;
        return fare;
    }

    public void bookTaxi(int customerId, char from, char to, int pickupTime) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxis) {
            if (t.freeTime <= pickupTime) freeTaxis.add(t);
        }

        if (freeTaxis.isEmpty()) {
            System.out.println("Booking rejected. No taxis free.");
            return;
        }

        // choose taxi based on distance + earnings
        int fromIdx = pointToIndex(from);
        Taxi chosen = freeTaxis.stream()
            .min(Comparator.comparingInt((Taxi t) -> Math.abs(pointToIndex(t.currentPoint) - fromIdx))
                 .thenComparingInt(t -> t.totalEarnings)
                 .thenComparingInt(t -> t.id))
            .get();

        int toIdx = pointToIndex(to);
        int distance = Math.abs(toIdx - fromIdx) * 15; // each segment 15 km
        int travelTime = Math.abs(toIdx - fromIdx) * 1; // 60 min = 1 hr per segment
        int dropTime = pickupTime + travelTime;
        int fare = calculateFare(distance);

        Booking b = new Booking(bookingCounter++, customerId, from, to, pickupTime, dropTime, fare);
        chosen.addBooking(b, to, dropTime);

        System.out.println("Taxi can be allotted.\nTaxi-" + chosen.id + " is allotted");
    }

    public void displayDetails() {
        for (Taxi t : taxis) {
            if (!t.bookings.isEmpty()) {
                System.out.println(t);
            }
        }
    }
}

public class CallTaxiApp {
    public static void main(String[] args) {
        TaxiBookingSystem system = new TaxiBookingSystem(4);

        // Input 1
        system.bookTaxi(1, 'A', 'B', 9);

        // Input 2
        system.bookTaxi(2, 'B', 'D', 9);

        // Input 3
        system.bookTaxi(3, 'B', 'C', 12);

        // Display
        System.out.println("\n--- Taxi Details ---");
        system.displayDetails();
    }
}
