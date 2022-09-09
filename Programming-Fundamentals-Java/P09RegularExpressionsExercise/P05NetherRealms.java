package P09RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split("\\s*,+\\s*");
        Pattern damagePattern = Pattern.compile("([\\-+]?\\d+\\.\\d+|[\\-+]?\\d+)");
        Pattern healthPattern = Pattern.compile("[^0-9+\\-*/.]");
        Pattern multiplyOrDividePattern = Pattern.compile("[*/]");

        for (String demon : demons) {
            Matcher healthMatcher = healthPattern.matcher(demon);
            int health = 0;

            while (healthMatcher.find()) {
                char symbol = healthMatcher.group().charAt(0);
                health += symbol;
            }

            Matcher damageMatcher = damagePattern.matcher(demon);
            double damage = 0;

            while (damageMatcher.find()) {
                damage += Double.parseDouble(damageMatcher.group());
            }

            Matcher multiplyOrDivideMatcher = multiplyOrDividePattern.matcher(demon);
            List<String> actions = new ArrayList<>();

            while (multiplyOrDivideMatcher.find()) {
                actions.add(multiplyOrDivideMatcher.group());
            }
            for (String action : actions) {
                switch (action) {
                    case "*":
                        damage *= 2;
                        break;
                    case "/":
                        damage /= 2;
                        break;
                }
            }
            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }
}
