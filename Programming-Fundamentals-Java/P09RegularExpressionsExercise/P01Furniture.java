package P09RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile(">>(?<furniture>\\w+)<<(?<price>\\d+.?\\d*)!(?<quantity>\\d+)");
        double totalSum = 0;

        List<String> items = new ArrayList<>();

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                items.add(matcher.group("furniture"));
                totalSum += Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");

//        for (String item : items) {
//            System.out.println(item);
//        }
        items.forEach(System.out::println);

        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
