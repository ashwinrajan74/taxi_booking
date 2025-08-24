package model;

// Inheritance: AcVehicle extends Vehicle
// Polymorphism: Overrides getDetails()
public class AcVehicle extends Vehicle {
    private String acAvailable;

    public AcVehicle(int id, String name, String fuelType, double price, String acAvailable) {
        super(id, name, fuelType, price);
        this.acAvailable = acAvailable;
    }

    @Override // Polymorphism: different implementation of getDetails()
    public String getDetails() {
        return "ID: " + id + " | " + name + " | Fuel: " + fuelType + " | Price: " + price + " | AC: " + acAvailable;
    }
}
