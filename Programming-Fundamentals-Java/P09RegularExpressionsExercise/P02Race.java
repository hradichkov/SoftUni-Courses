package P09RegularExpressionsExercise;

import com.sun.jdi.Value;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).toList();
        Map<String, Integer> racersMap = new LinkedHashMap<>();
        racers.forEach(racer -> racersMap.put(racer, 0)); // записва състезателите от листа в мапа с 0 измината дистанция

        Pattern patternLetters = Pattern.compile("[A-Za-z]+");
        Pattern patternDigits = Pattern.compile("\\d");

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            StringBuilder sbName = new StringBuilder();
            int distance = 0;

            Matcher matcherLetters = patternLetters.matcher(input);
            Matcher matcherDigits = patternDigits.matcher(input);

            while (matcherLetters.find()) {
                sbName.append(matcherLetters.group());
            }

            while (matcherDigits.find()) {
                distance += Integer.parseInt(matcherDigits.group());
            }

            String name = sbName.toString();

            if (racersMap.containsKey(name)) {
                int currentDistance = racersMap.get(name);
                racersMap.put(name, currentDistance + distance);
            }

            input = scanner.nextLine();
        }

        List<String> firstThreeNames = racersMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // подражда ги в намаляващ ред
                .limit(3) // получавам map с 3 записа, които са първите 3ма с най-голяма дистанция
                .map(Map.Entry::getKey) // за всеки един от тези 3 записа ми вземи техните ключове
                .collect(Collectors.toList()); // направи го на list

        System.out.printf("1st place: %s%n", firstThreeNames.get(0));
        System.out.printf("2nd place: %s%n", firstThreeNames.get(1));
        System.out.printf("3rd place: %s%n", firstThreeNames.get(2));
    }
}
//package Regex;
//
//        import java.util.*;
//        import java.util.regex.Matcher;
//        import java.util.regex.Pattern;
//        import java.util.stream.Collectors;
//
//
//public class Race {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String nameRegex = "[A-Za-z]+";
//        String distanceRegex = "[\\d]{1}";
//        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
//        Map<String, Integer> racers = new LinkedHashMap<>();
//        for (String name : names) {
//            racers.putIfAbsent(name, 0);
//        }
//        Pattern namePattern = Pattern.compile(nameRegex);
//        Pattern distancePattern = Pattern.compile(distanceRegex);
//
//        String line = scanner.nextLine();
//        while (!line.equals("end of race")) {
//            Matcher nameMatcher = namePattern.matcher(line);
//            StringBuilder sb = new StringBuilder();
//            while (nameMatcher.find()) {
//                sb.append(nameMatcher.group());
//            }
//            if (racers.containsKey(sb.toString())) {
//                Matcher distanceMatcher = distancePattern.matcher(line);
//
//                while (distanceMatcher.find()) {
//                    int digit = Integer.parseInt(distanceMatcher.group());
//                    racers.put(sb.toString(), racers.get(sb.toString()) + digit);
//                }
//            }
//
//
//            line = scanner.nextLine();
//        }
//        List<String> sorted = racers.entrySet().stream()
//                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
//                .map(Map.Entry::getKey).collect(Collectors.toList());
//        String text = "";
//        for (int i = 0; i < sorted.size(); i++) {
//            if (i == 3) {
//                break;
//            }
//            text = i == 0 ? "st" : i == 1 ? "nd" : i == 2 ? "rd" : "";
////            if (i == 0) {
////                text = "st";
////            } else if (i == 1) {
////                text = "nd";
////            } else if (i == 2) {
////                text = "rd";
////            }
//            System.out.printf("%d%s place: %s%n", i + 1, text, sorted.get(i));
//        }
//
//    }
//}