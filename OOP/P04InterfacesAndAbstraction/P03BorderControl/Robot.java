package P04InterfacesAndAbstraction.P03BorderControl;

public class Robot implements Identifiable{

    private String id;
    private String model;

    public Robot(String id, String model) {
        this.model = model;
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return id;
    }
}
