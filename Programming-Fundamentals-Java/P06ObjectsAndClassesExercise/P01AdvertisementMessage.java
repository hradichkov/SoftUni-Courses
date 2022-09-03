package P06ObjectsAndClassesExercise;

import java.util.Random;
import java.util.Scanner;

public class P01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Random randomGenerator = new Random();

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        for (int i = 0; i < n; i++) {
            int randomPhrase = randomGenerator.nextInt(phrases.length);
            int randomEvent = randomGenerator.nextInt(events.length);
            int randomAuthor = randomGenerator.nextInt(authors.length);
            int randomCity = randomGenerator.nextInt(cities.length);

            System.out.printf("%s %s %s - %s%n", phrases[randomPhrase], events[randomEvent], authors[randomAuthor], cities[randomCity]);
        }
    }
}
