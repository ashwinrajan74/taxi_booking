package service;

import model.*;
import java.util.*;

// Utility class demonstrating methods for user management, vehicle listing, booking etc.
public class Functions {

    // SignUp method - adds new user
    public static void signUp(List<User> users, int id, String uname, String role, String password) {
        users.add(new User(id, uname, role, password));
    }

    // Login method - validates user
    public static User login(List<User> users, String uname, String password) {
        for (User u : users) {
            if (u.getUname().equals(uname) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    // List all vehicles
    public static List<String> listVehicles(List<Vehicle> vehicles) {
        List<String> list = new ArrayList<>();
        for (Vehicle v : vehicles) {
            list.add(v.getDetails()); // Polymorphism: calls AC or NonAC getDetails()
        }
        return list;
    }

    // Add booking
    public static void addBooking(List<Booking> books, int bookingId, String from, String to, String uname,
                                  int pickupTime, int dropTime, int vehicleId, List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            if (v.getId() == vehicleId) {
                books.add(new Booking(bookingId, from, to, uname, pickupTime, dropTime, vehicleId));
                return;
            }
        }
    }

    // List all bookings
    public static List<String> listBookings(List<Booking> books) {
        List<String> list = new ArrayList<>();
        for (Booking b : books) {
            list.add(b.toString());
        }
        return list;
    }

    // Cancel booking
    public static boolean cancelBooking(List<Booking> books, int bookingId, String uname) {
        Iterator<Booking> it = books.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.getBookingId() == bookingId && b.getUname().equals(uname)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
