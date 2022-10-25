package P05PolymorphismExercises.P01Vehicles;

public class Truck extends Vehicle {
    private final static double ADDITIONAL_AC_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        liters = liters * 0.95;
        super.refuel(liters);

        //super.setFuelQuantity(super.getFuelQuantity() + liters);
    }
}
