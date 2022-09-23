package P06DefiningClasses.P04Constructors;

public class Car {
    String brand;
    String model;
    int horsePower;

    Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    Car(String brand) {
        this(brand, "unknown", -1);
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.",
                this.brand,
                this.model,
                this.horsePower);
    }
}
