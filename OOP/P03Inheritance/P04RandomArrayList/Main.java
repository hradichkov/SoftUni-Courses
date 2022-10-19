package P03Inheritance.P04RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add(15);
        randomArrayList.add(20);
        randomArrayList.add(30);
        randomArrayList.add(40);

        System.out.println(randomArrayList.getRandomElement());
    }
}
