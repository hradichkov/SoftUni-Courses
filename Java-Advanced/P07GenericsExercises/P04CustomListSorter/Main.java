package P07GenericsExercises.P04CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();

        while (!input.equals("END")){
            String [] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "Add" -> {
                    String element = data[1];
                    customList.add(element);
                }
                case "Remove" -> {
                    int index = Integer.parseInt(data[1]);
                    customList.remove(index);
                }
                case "Contains" -> System.out.println(customList.contains(data[1]));
                case "Swap" -> {
                    int firstIndex = Integer.parseInt(data[1]);
                    int secondIndex = Integer.parseInt(data[2]);
                    customList.swap(firstIndex, secondIndex);
                }
                case "Greater" -> System.out.println(customList.countGreaterThan(data[1]));
                case "Max" -> System.out.println(customList.getMax());
                case "Min" -> System.out.println(customList.getMin());
                case "Print" -> System.out.println(customList);
                case "Sort" -> Sorter.sort(customList);
            }
            input = scanner.nextLine();
        }
    }
}
