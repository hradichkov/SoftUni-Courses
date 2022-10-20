package P03InheritanceExercises.P06Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!"Beast!".equals(animalType)) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];

            try {
                switch (animalType) {
                    case "Cat" -> {
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                    }
                    case "Dog" -> {
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                    }
                    case "Frog" -> {
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                    }
                    case "Kitten" -> {
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                    }
                    case "Tomcat" -> {
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animalType = scanner.nextLine();
        }
    }
}
