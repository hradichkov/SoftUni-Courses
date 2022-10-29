package P07ReflectionAndAnnotationsExercises.P01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        while (!"HARVEST".equals(input)) {
            switch (input) {
                case "private" -> printFilteredFields("private", fields);
                case "protected" -> printFilteredFields("protected", fields);
                case "public" -> printFilteredFields("public", fields);
                case "all" -> Arrays.stream(fields)
                        .forEach(m -> System.out.printf("%s %s %s%n", Modifier.toString(m.getModifiers()), m.getType().getSimpleName(), m.getName()));
            }

            input = scanner.nextLine();
        }
    }

    private static void printFilteredFields(String modifier, Field[] fields) {
        Arrays.stream(fields)
                .filter(field -> Modifier.toString(field.getModifiers()).equals(modifier))
                .forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
    }
}
