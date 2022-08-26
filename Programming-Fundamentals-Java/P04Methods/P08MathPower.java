package P04Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());

        raisedNum(number, power);
    }

    static void raisedNum(double number, double power) {
        System.out.println(new DecimalFormat("0.####").format(Math.pow(number, power)));
    }
}
