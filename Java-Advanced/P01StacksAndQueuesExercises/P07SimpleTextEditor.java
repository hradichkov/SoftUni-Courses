package P01StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "1":
                    stack.push(input);

                    executeAdd(text, data[1]);
                    break;
                case "2":
                    stack.push(input);

                    int count = Integer.parseInt(data[1]);

                    StringBuilder elementsToBeDeleted = new StringBuilder();
                    for (int j = text.length() - count; j < text.length(); j++) {
                        elementsToBeDeleted.append(text.charAt(j));
                    }
                    removedElements.push(elementsToBeDeleted.toString());
                    executeDelete(text, count);

                    break;
                case "3":
                    int index = Integer.parseInt(data[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    String lastCommand = stack.pop();
                    String[] lastCommandData = lastCommand.split(" ");

                    switch (lastCommandData[0]) {
                        case "1":
                            executeDelete(text, lastCommandData[1].length());
                            break;
                        case "2":
                            String elementsToAddBack = removedElements.pop();
                            executeAdd(text, elementsToAddBack);
                            break;
                    }
                    break;
            }
        }
    }

    private static void executeDelete(StringBuilder text, int count) {
        text.delete(text.length() - count, text.length());
    }

    private static void executeAdd(StringBuilder sb, String textToAdd) {
        sb.append(textToAdd);
    }
}
