package P04Methods;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String arithmeticOperation = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        if (arithmeticOperation.equals("add")) {
            add(a, b);
        } else if (arithmeticOperation.equals("multiply")) {
            multiply(a, b);
        } else if (arithmeticOperation.equals("subtract")) {
            subtract(a, b);
        } else {
            divide(a, b);
        }
    }

    static void add(int a, int b) {
        System.out.println(a + b);
    }

    static void multiply(int a, int b) {
        System.out.println(a * b);
    }

    static void subtract(int a, int b) {
        System.out.println(a - b);
    }

    static void divide(int a, int b) {
        System.out.println(a / b);
    }

//    static void operations(int a, int b, String arithmeticOperation){
//        if (arithmeticOperation.equals("add")) {
//            add(a, b);
//        } else if (arithmeticOperation.equals("multiply")) {
//            multiply(a, b);
//        } else if (arithmeticOperation.equals("subtract")) {
//            subtract(a, b);
//        } else {
//            divide(a, b);
       }


