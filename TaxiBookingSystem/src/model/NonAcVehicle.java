package model;

// Inheritance: NonAcVehicle extends Vehicle
// Polymorphism: Overrides getDetails()
public class NonAcVehicle extends Vehicle {
    private String acAvailable;

    public NonAcVehicle(int id, String name, String fuelType, double price, String acAvailable) {
        super(id, name, fuelType, price);
        this.acAvailable = acAvailable;
    }

    @Override // Polymorphism
    public String getDetails() {
        return "ID: " + id + " | " + name + " | Fuel: " + fuelType + " | Price: " + price + " | AC: " + acAvailable;
    }
}
