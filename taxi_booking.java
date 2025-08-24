import java.util.*;


class User {
    private int uid;
    private String uname;
    private String role;
    private String pass;

    public User(int uid, String uname, String role, String pass) {
        this.uid = uid;
        this.uname = uname;
        this.role = role;
        this.pass = pass;
    }

    public String getUname() { return uname; }
    public String getRole() { return role; }
    public boolean validatePassword(String inputPass) { return this.pass.equals(inputPass); }
}


abstract class Vehicle {
    protected int vid;
    protected String vname;
    protected String vtype;
    protected int vcost;
    protected String acstatus;

    public Vehicle(int vid, String vname, String vtype, int vcost, String acstatus) {
        this.vid = vid;
        this.vname = vname;
        this.vtype = vtype;
        this.vcost = vcost;
        this.acstatus = acstatus;
    }

    public int getVid() { return vid; }
    public String getVname() { return vname; }
    public int getVcost() { return vcost; }

  
    public abstract String getDetails();
}


class AcVehicle extends Vehicle {
    public AcVehicle(int vid, String vname, String vtype, int vcost, String acstatus) {
        super(vid, vname, vtype, vcost, acstatus);
    }

    @Override
    public String getDetails() {
        return "AC Vehicle - ID: " + vid + ", Name: " + vname + ", Type: " + vtype + ", Cost: " + vcost + ", AC: " + acstatus;
    }
}

class NonAcVehicle extends Vehicle {
    public NonAcVehicle(int vid, String vname, String vtype, int vcost, String acstatus) {
        super(vid, vname, vtype, vcost, acstatus);
    }

    @Override
    public String getDetails() {
        return "Non-AC Vehicle - ID: " + vid + ", Name: " + vname + ", Type: " + vtype + ", Cost: " + vcost + ", AC: " + acstatus;
    }
}


class Booking {
    private int bookid;
    private String from;
    private String to;
    private int ptime;
    private int dtime;
    private int bcost;
    private String bookname;

    public Booking(int bookid, String from, String to, String bookname, int ptime, int dtime, Vehicle vehicle) {
        this.bookid = bookid;
        this.from = from;
        this.to = to;
        this.bookname = bookname;
        this.ptime = ptime;
        this.dtime = dtime;
        this.bcost = vehicle.getVcost();
    }

    public int getBookid() { return bookid; }
    public String getBookname() { return bookname; }

    public String getBookingDetails() {
        return "Booking ID: " + bookid + ", Booker: " + bookname + ", From: " + from + ", To: " + to +
                ", Pickup: " + ptime + ", Drop: " + dtime + ", Cost: " + bcost;
    }
}


class Functions {
    public static User login(List<User> users, String uname, String pass) {
        for (User u : users) {
            if (u.getUname().equals(uname) && u.validatePassword(pass)) {
                return u;
            }
        }
        return null;
    }

    public static void signUp(List<User> users, int id, String uname, String role, String pass) {
        users.add(new User(id, uname, role, pass));
    }

    public static List<String> listVehicles(List<Vehicle> vehicles) {
        List<String> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            result.add(v.getDetails());
        }
        return result;
    }

    public static void addBooking(List<Booking> books, int bid, String from, String to, String uname, int ptime, int dtime, int vid, List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            if (v.getVid() == vid) {
                books.add(new Booking(bid, from, to, uname, ptime, dtime, v));
                break;
            }
        }
    }

    public static List<String> listBookings(List<Booking> books) {
        List<String> result = new ArrayList<>();
        for (Booking b : books) {
            result.add(b.getBookingDetails());
        }
        return result;
    }

    public static boolean cancelBooking(List<Booking> books, int id, String uname) {
        for (int i = 0; i < books.size(); i++) {
            Booking b = books.get(i);
            if (b.getBookid() == id && b.getBookname().equals(uname)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
}


public class taxi_booking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Booking> books = new ArrayList<>();

        
        Functions.signUp(users, 1, "ashwin", "admin", "hello");
        vehicles.add(new AcVehicle(1, "Toyota", "Diesel", 1200, "Yes"));
        vehicles.add(new NonAcVehicle(2, "Honda", "Diesel", 1600, "No"));

        while (true) {
            System.out.println("1. Sign Up\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("Enter Name: "); String uname = sc.nextLine();
                System.out.print("Enter Role: "); String role = sc.nextLine();
                System.out.print("Enter Password: "); String pass = sc.nextLine();
                Functions.signUp(users, id, uname, role, pass);
                System.out.println("Sign Up Successful!");

            } else if (choice == 2) {
                System.out.print("Enter Username: "); String uname = sc.nextLine();
                System.out.print("Enter Password: "); String pass = sc.nextLine();

                User loggedIn = Functions.login(users, uname, pass);
                if (loggedIn == null) {
                    System.out.println("Invalid Login!");
                } else {
                    System.out.println("Login Successful! Welcome " + loggedIn.getUname());

                    int ch = 0;
                    while (ch != 6) {
                        System.out.println("1. List Vehicles\n2. Book Vehicle\n3. Show Bookings\n4. Cancel Booking\n5. Logout\n6. Exit");
                        ch = sc.nextInt();
                        sc.nextLine();

                        switch (ch) {
                            case 1:
                                for (String v : Functions.listVehicles(vehicles)) {
                                    System.out.println(v);
                                }
                                break;
                            case 2:
                                System.out.print("Enter Booking ID: "); int bid = sc.nextInt(); sc.nextLine();
                                System.out.print("Enter From: "); String from = sc.nextLine();
                                System.out.print("Enter To: "); String to = sc.nextLine();
                                System.out.print("Pickup Time: "); int ptime = sc.nextInt();
                                System.out.print("Drop Time: "); int dtime = sc.nextInt();
                                System.out.print("Enter Vehicle ID: "); int vid = sc.nextInt();
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
                                ch = 6;
                                break;
                        }
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
        
    }
}
