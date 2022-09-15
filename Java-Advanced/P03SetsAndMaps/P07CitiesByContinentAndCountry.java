package P03SetsAndMaps;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

        map.entrySet()
                .forEach(entry -> {
                    String continent = entry.getKey();
                    Map<String, List<String>> countriesWithCities = entry.getValue();

                    System.out.println(continent + ":");

                    countriesWithCities.entrySet()
                            .forEach(e -> {
                                System.out.println("  " + e.getKey() + " -> " + String.join(", ", e.getValue()));
                            });
                });
    }
}
