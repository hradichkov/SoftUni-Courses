package P09RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)%[^|$.]*?<(?<product>\\w+)>[^|$.]*?\\|(?<quantity>\\d+)\\|[^|$.]*?(?<price>\\d+\\.?\\d+)\\$");
        double totalIncome = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                double income = Double.parseDouble(matcher.group("price")) * Double.parseDouble(matcher.group("quantity"));
                totalIncome += income;
                System.out.printf("%s: %s - %.2f%n", matcher.group("name"), matcher.group("product"), income);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
