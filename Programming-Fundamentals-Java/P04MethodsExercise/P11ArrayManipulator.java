package P04MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(data[1]);

                    if (index < 0 || index >= array.length) {
                        System.out.println("Invalid index");
                    } else {
                        exchange(array, index);
                    }
                    break;

                case "max":
                    if (data[1].equals("even")) {
                        printEvenMax(array);
                    } else {
                        printOddMax(array);
                    }
                    break;

                case "min":
                    if (data[1].equals("even")) {
                        printEvenMin(array);
                    } else {
                        printOddMin(array);
                    }
                    break;

                case "first":
                    int countFirst = Integer.parseInt(data[1]);

                    if (countFirst > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (data[2].equals("even")) {
                            printFirstEven(array, countFirst);
                        } else {
                            printFirstOdd(array, countFirst);
                        }
                    }
                    break;

                case "last":
                    int countLast = Integer.parseInt(data[1]);

                    if (countLast > array.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (data[2].equals("even")) {
                            printLastEven(array, countLast);
                        } else {
                            printLastOdd(array, countLast);
                        }
                        break;
                    }
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(array));
    }

    private static void printLastOdd(int[] array, int countLast) {
        int currentCount = 0;

        int[] countArr = new int[countLast];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0) {
                countArr[currentCount] = array[i];
                currentCount++;
                if (currentCount == countLast) {
                    break;
                }
            }
        }

        int countZeros = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 0) {
                countZeros++;
            }
        }

        int[] finalArr = new int[countArr.length - countZeros];
        for (int i = 0; i < finalArr.length; i++) {
            finalArr[i] = countArr[i];
        }

        if (currentCount == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(finalArr));
        }
    }

    private static void printLastEven(int[] array, int countLast) {
        int currentCount = 0;

        int[] countArr = new int[countLast];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                countArr[currentCount] = array[i];
                currentCount++;
                if (currentCount == countLast) {
                    break;
                }
            }
        }

        int countZeros = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 0) {
                countZeros++;
            }
        }

        int[] finalArr = new int[countArr.length - countZeros];
        for (int i = 0; i < finalArr.length; i++) {
            finalArr[i] = countArr[i];
        }

        if (currentCount == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(finalArr));
        }
    }

    private static void printFirstOdd(int[] array, int countFirst) {
        int currentCount = 0;

        int[] countArr = new int[countFirst];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                countArr[currentCount] = array[i];
                currentCount++;
                if (currentCount == countFirst) {
                    break;
                }
            }
        }

        int countZeros = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 0) {
                countZeros++;
            }
        }

        int[] finalArr = new int[countArr.length - countZeros];
        for (int i = 0; i < finalArr.length; i++) {
            finalArr[i] = countArr[i];
        }

        if (currentCount == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(finalArr));
        }
    }

    private static void printFirstEven(int[] array, int countFirst) {
        int currentCount = 0;

        int[] countArr = new int[countFirst];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                countArr[currentCount] = array[i];
                currentCount++;
                if (currentCount == countFirst) {
                    break;
                }
            }
        }

        int countZeros = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 0) {
                countZeros++;
            }
        }

        int[] finalArr = new int[countArr.length - countZeros];
        for (int i = 0; i < finalArr.length; i++) {
            finalArr[i] = countArr[i];
        }

        if (currentCount == 0) {
            System.out.println("[]");
        } else {
            System.out.println(Arrays.toString(finalArr));
        }
    }

    private static void printOddMin(int[] array) {
        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = 0;
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array[i] <= minOdd) {
                    minOdd = array[i];
                    minOddIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(minOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void printEvenMin(int[] array) {
        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = 0;
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] <= minEven) {
                    minEven = array[i];
                    minEvenIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(minEvenIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void printOddMax(int[] array) {
        int maxOdd = Integer.MIN_VALUE;
        int maxOddIndex = 0;
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                if (array[i] >= maxOdd) {
                    maxOdd = array[i];
                    maxOddIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(maxOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void printEvenMax(int[] array) {
        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = 0;
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] >= maxEven) {
                    maxEven = array[i];
                    maxEvenIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(maxEvenIndex);
        } else {
            System.out.println("No matches");
        }
    }

    private static void exchange(int[] array, int index) {
        int[] first = new int[index + 1];
        int[] second = new int[array.length - index - 1];

        for (int i = 0; i < first.length; i++) {
            first[i] = array[i];
        }

        for (int i = 0; i < second.length; i++) {
            second[i] = array[index + 1 + i];
        }

        for (int i = 0; i < array.length; i++) {
            if (i < second.length) {
                array[i] = second[i];
            } else {
                array[i] = first[i - second.length];
            }
        }
    }

}
//package Methods;
//
//        import java.util.Arrays;
//        import java.util.Scanner;
//
//public class ArrayManipulator {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        String line = scanner.nextLine();
//        while (!line.equals("end")) {
//            String[] data = line.split(" ");
//            String command = data[0];
//
//            switch (command) {
//                case "exchange":
//                    int index = Integer.parseInt(data[1]);
//                    if (isValidIndex(index, arr.length)) {
//                        exchange(arr, index);
//                    } else {
//                        System.out.println("Invalid index");
//                    }
//                    break;
//                case "max":
//                    if (data[1].equals("even")) {
//                        printEvenMax(arr);
//                    } else {
//                        printOddMax(arr);
//                    }
//                    break;
//                case "min":
//                    if (data[1].equals("even")) {
//                        printEvenMin(arr);
//                    } else {
//                        printOddMin(arr);
//                    }
//                    break;
//                case "first":
//                    int count = Integer.parseInt(data[1]);
//                    if (count > arr.length) {
//                        System.out.println("Invalid count");
//                    } else {
//                        if (data[2].equals("even")) {
//                            printFirstEven(arr, count);
//                        } else {
//                            printFirstOdd(arr, count);
//                        }
//                    }
//
//                    break;
//                case "last":
//                    count = Integer.parseInt(data[1]);
//                    if (count > arr.length) {
//                        System.out.println("Invalid count");
//                    } else {
//                        if (data[2].equals("even")) {
//                            printLastEven(arr, count);
//                        } else {
//                            printLastOdd(arr, count);
//                        }
//                    }
//            }
//
//            line = scanner.nextLine();
//        }
//        System.out.println(Arrays.toString(arr));
//    }
//
//    public static boolean isValidIndex(int index, int length) {
//        return index >= 0 && index < length;
//    }
//
//    public static void exchange(int[] array, int index) {
//        // [1, 2, 3, 4, 5]
//        int[] first = new int[index + 1];
//        int[] second = new int[array.length - index - 1];
//        for (int i = 0; i <= index; i++) {
//            first[i] = array[i];
//        }
//        for (int i = 0; i < second.length; i++) {
//            second[i] = array[index + 1 + i];
//        }
//        // [1, 2, 3, 4, 5]
//        // [1,2,3]   [4,5]
//        for (int i = 0; i < array.length; i++) {
//            // start filling from second array
//            if (i < second.length) {
//                array[i] = second[i];
//            } else {
//                // continue with second array
//                array[i] = first[i - second.length];
//            }
//        }
//    }
//
//    public static void printEvenMin(int[] array) {
//        int minNumber = Integer.MAX_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (minNumber >= array[i] && array[i] % 2 == 0) {
//                minNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    public static void printOddMin(int[] array) {
//        int minNumber = Integer.MAX_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (minNumber >= array[i] && array[i] % 2 != 0) {
//                minNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    public static void printEvenMax(int[] array) {
//        int maxNumber = Integer.MIN_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (maxNumber <= array[i] && array[i] % 2 == 0) {
//                maxNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    public static void printOddMax(int[] array) {
//        int maxNumber = Integer.MIN_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (maxNumber <= array[i] && array[i] % 2 != 0) {
//                maxNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    public static void printFirstEven(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    public static void printFirstOdd(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 != 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    public static void printLastEven(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (array[i] % 2 == 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    public static void printLastOdd(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (array[i] % 2 != 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    private static void printArr(int[] array) {
//        System.out.print("[");
//        boolean printFirst = true;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != -1) {
//                if (printFirst) {
//
//                    System.out.print(array[i]);
//                    printFirst = false;
//                } else {
//                    System.out.print(", " + array[i]);
//                }
//            }
//        }
//        System.out.println("]");
//    }
//}
