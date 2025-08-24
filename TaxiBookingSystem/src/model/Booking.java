package model;

// Encapsulation: Booking hides its fields and provides public methods
public class Booking {
    private int bookingId;
    private String from;
    private String to;
    private String uname;
    private int pickupTime;
    private int dropTime;
    private int vehicleId;

    public Booking(int bookingId, String from, String to, String uname, int pickupTime, int dropTime, int vehicleId) {
        this.bookingId = bookingId;
        this.from = from;
        this.to = to;
        this.uname = uname;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.vehicleId = vehicleId;
    }

    // Getter methods (Encapsulation)
    public int getBookingId() { return bookingId; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getUname() { return uname; }
    public int getPickupTime() { return pickupTime; }
    public int getDropTime() { return dropTime; }
    public int getVehicleId() { return vehicleId; }

    @Override
    public String toString() {
        return "BookingID: " + bookingId + " | User: " + uname + " | From: " + from + " | To: " + to +
               " | Pickup: " + pickupTime + " | Drop: " + dropTime + " | VehicleID: " + vehicleId;
    }
}
