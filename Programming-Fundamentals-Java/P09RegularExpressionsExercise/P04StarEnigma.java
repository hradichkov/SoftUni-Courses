package P09RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("@(?<planetName>[A-Za-z]+)[^-@!:>]*:(?<population>\\d+)[^-@!:>]*!(?<attackType>[AD])![^-@!:>]*->(?<soldierCount>\\d+)");

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage(encryptedMessage);

            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                //int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                //int soldierCount = Integer.parseInt(matcher.group("soldierCount"));

                if (attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else {
                    destroyedPlanets.add(planetName);
                }
            }
        }
        System.out.println("Attacked planets: " + attackedPlanets.size());
        Collections.sort(attackedPlanets);
        attackedPlanets.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));
    }

    private static String getDecryptedMessage(String encryptedMessage) {
        int countSpecialLetters = getSpecialLetters(encryptedMessage);
        StringBuilder decryptedMessage = new StringBuilder();

        for (char symbol : encryptedMessage.toCharArray()) {
            char newSymbol = (char) (symbol - countSpecialLetters);
            decryptedMessage.append(newSymbol);
        }
        return decryptedMessage.toString();
    }

    private static int getSpecialLetters(String encryptedMessage) {
        int count = 0;
        for (char symbol : encryptedMessage.toLowerCase().toCharArray()) {
            if (symbol == 's' || symbol == 't' || symbol == 'a' || symbol == 'r') {
                count++;
            }
        }
        return count;
    }
}
