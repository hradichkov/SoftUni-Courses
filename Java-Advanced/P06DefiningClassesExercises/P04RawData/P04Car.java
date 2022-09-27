package P06DefiningClassesExercises.P04RawData;

import java.util.ArrayList;
import java.util.List;

public class P04Car {
    private String model;
    private P04Engine engine;
    private P04Cargo cargo;
    private List<P04Tire> tires;

    public P04Car(String model, P04Engine engine, P04Cargo cargo, List<P04Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = new ArrayList<>(tires);
//        this.tires = new ArrayList<>();
//        this.tires.addAll(tires);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public P04Engine getEngine() {
        return engine;
    }

    public void setEngine(P04Engine engine) {
        this.engine = engine;
    }

    public P04Cargo getCargo() {
        return cargo;
    }

    public void setCargo(P04Cargo cargo) {
        this.cargo = cargo;
    }

    public List<P04Tire> getTires() {
        return tires;
    }

    public void setTires(List<P04Tire> tires) {
        this.tires = tires;
    }
}
