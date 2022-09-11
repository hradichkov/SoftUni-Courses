package P01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String currentURL = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.equals("")) {
                    stack.push(currentURL);
                }
                currentURL = input;
            }
            System.out.println(currentURL);
            input = scanner.nextLine();
        }
    }
}
