package P02DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());

        int originalPowerN = powerN;

        int pokeCount = 0;

        while (powerN >= distanceM) {
            powerN -= distanceM;
            pokeCount++;

            if (powerN == originalPowerN / 2 && exhaustionFactorY != 0) {
                powerN /= exhaustionFactorY;
            }
        }
        System.out.println(powerN);
        System.out.println(pokeCount);
    }
}