package main;

import model.*;
import service.*;
import java.util.*;

// Driver class (Entry Point)
public class TaxiBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<User> users = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Booking> books = new ArrayList<>();

        // Default admin & vehicles
        Functions.signUp(users, 1, "ashwin", "admin", "hello");
        vehicles.add(new AcVehicle(1, "Toyota", "Diesel", 1200, "Yes"));
        vehicles.add(new NonAcVehicle(2, "Honda", "Diesel", 1600, "No"));

        while (true) {
            System.out.println("\n===== TAXI BOOKING SYSTEM =====");
            System.out.println("1. Sign Up\n2. Login\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Enter Name: ");
                String uname = sc.nextLine();
                System.out.print("Enter Role: ");
                String role = sc.nextLine();
                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                Functions.signUp(users, id, uname, role, pass);
                System.out.println("Sign Up Successful!");

            } else if (choice == 2) {
                System.out.print("Enter Username: ");
                String uname = sc.nextLine();
                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                User loggedIn = Functions.login(users, uname, pass);
                if (loggedIn == null) {
                    System.out.println("Invalid Login!");
                } else {
                    System.out.println("Login Successful! Welcome " + loggedIn.getUname());

                    int ch = 0;
                    while (ch != 6) {
                        System.out.println("\n--- MENU ---");
                        System.out.println("1. List Vehicles");
                        System.out.println("2. Book Vehicle");
                        System.out.println("3. Show Bookings");
                        System.out.println("4. Cancel Booking");
                        System.out.println("5. Logout");
                        System.out.println("6. Exit");
                        System.out.print("Enter choice: ");
                        ch = sc.nextInt();
                        sc.nextLine();

                        switch (ch) {
                            case 1:
                                for (String v : Functions.listVehicles(vehicles)) {
                                    System.out.println(v);
                                }
                                break;

                            case 2:
                                System.out.print("Enter Booking ID: ");
                                int bid = sc.nextInt(); sc.nextLine();
                                System.out.print("Enter From: ");
                                String from = sc.nextLine();
                                System.out.print("Enter To: ");
                                String to = sc.nextLine();
                                System.out.print("Pickup Time: ");
                                int ptime = sc.nextInt();
                                System.out.print("Drop Time: ");
                                int dtime = sc.nextInt();
                                System.out.print("Enter Vehicle ID: ");
                                int vid = sc.nextInt();

                                Functions.addBooking(books, bid, from, to, uname, ptime, dtime, vid, vehicles);
                                System.out.println("Booking Added!");
                                break;

                            case 3:
                                for (String b : Functions.listBookings(books)) {
                                    System.out.println(b);
                                }
                                break;

                            case 4:
                                System.out.print("Enter Booking ID to cancel: ");
                                int id = sc.nextInt();
                                if (Functions.cancelBooking(books, id, uname)) {
                                    System.out.println("Booking Canceled.");
                                } else {
                                    System.out.println("Booking Not Found.");
                                }
                                break;

                            case 5:
                                ch = 6; // logout
                                break;
                        }
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting System. Goodbye!");
                break;
            }
        }
    }
}
