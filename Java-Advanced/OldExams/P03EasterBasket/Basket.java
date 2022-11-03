package OldExams.P03EasterBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Egg> getData() {
        return data;
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        for (Egg egg : data) {
            if (egg.getColor().equals(color)) {
                data.remove(egg);
                return true;
            }
        }
        return false;

// 2       Egg egg = this.getEgg(color);
//        data.remove(egg);
//        return egg != null;

        //3 return data.removeIf(e -> e.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        Egg strongestEgg = data.get(0);

        for (Egg e : data) {
            if (e.getStrength() > strongestEgg.getStrength()) {
                strongestEgg = e;
            }
        }
        return strongestEgg;
        //return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color) {
        for (Egg e : data) {
            if (e.getColor().equals(color)) {
                return e;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
// 1       StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%s basket contains:%n", material));
//
//        for (Egg e : data) {
//            sb.append(String.format("%s%n", e.toString()));
//        }
//
//        return sb.toString().trim();

//   2     StringBuilder sb = new StringBuilder();
//        sb.append(String.format("%s basket contains:%n",material));
//
//        data.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));
//
//        return sb.toString().trim();

        return String.format("%s basket contains:%n", this.material) +
                data.stream()
                        .map(egg -> String.format("%s", egg.toString()))
                        .collect(Collectors.joining(System.lineSeparator()))
                        .trim();

    }
}
