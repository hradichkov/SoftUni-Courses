package P02EncapsulationExercises.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", name, product.getName()));
        }
        products.add(product);
        money -= product.getCost();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ");

        List<String> productList = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());

//        String productData = products.stream()
//                .map(Product::getName)
//                .collect(Collectors.joining(", "));

        if (productList.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            sb.append(String.join(", ", productList));
        }

        return sb.toString();
    }
}
