package model;

// Abstraction: Vehicle is an abstract class with abstract method getDetails()
public abstract class Vehicle {
    protected int id;
    protected String name;
    protected String fuelType;
    protected double price;

    public Vehicle(int id, String name, String fuelType, double price) {
        this.id = id;
        this.name = name;
        this.fuelType = fuelType;
        this.price = price;
    }

    // Getter methods (Encapsulation)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getFuelType() { return fuelType; }
    public double getPrice() { return price; }

    // Abstraction: implemented differently in child classes
    public abstract String getDetails();
}
