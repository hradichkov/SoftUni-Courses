package P03Inheritance.P04RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {
    public Object getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(super.size());
        return remove(index);
    }
}
