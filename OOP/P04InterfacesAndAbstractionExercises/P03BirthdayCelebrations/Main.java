package P04InterfacesAndAbstractionExercises.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> thingsWithBirthday = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split(" ");
            String typeToCreate = data[0];

            switch (typeToCreate) {
                case "Citizen":
                    String citizenName = data[1];
                    int age = Integer.parseInt(data[2]);
                    String citizenId = data[3];
                    String citizenBirthDate = data[4];

                    Citizen citizen = new Citizen(citizenName, age, citizenId, citizenBirthDate);
                    thingsWithBirthday.add(citizen);
                    break;
                case "Pet":
                    String petName = data[1];
                    String petBirthDate = data[2];

                    Pet pet = new Pet(petName, petBirthDate);
                    thingsWithBirthday.add(pet);
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

//        for (Birthable birthable : thingsWithBirthday) {
//            if (birthable.getBirthDate().endsWith(year)) {
//                System.out.println(birthable.getBirthDate());
//            }
//        }

        thingsWithBirthday.stream()
                .filter(t -> t.getBirthDate().endsWith(year))
                .forEach(t -> System.out.println(t.getBirthDate()));
    }
}
