package P04InterfacesAndAbstraction.P01CarShop;

import java.io.Serializable;

public interface Car extends Serializable {
    int TIRE = 4;
    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
