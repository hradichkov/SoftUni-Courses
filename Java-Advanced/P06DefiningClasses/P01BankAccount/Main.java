package P06DefiningClasses.P01BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Integer, BankAccount> map = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String command = data[0];

            String output = "";

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                int id = bankAccount.getId();

                map.put(id, bankAccount);

                output = "Account ID" + id + " created";
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(data[1]);
                int amount = Integer.parseInt(data[2]);

                if (map.containsKey(id)) {
                    BankAccount bankAccount = map.get(id);
                    bankAccount.deposit(amount);

                    output = "Deposited " + amount + " to ID" + id;
                } else {
                    output = "Account does not exist";
                }
            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(data[1]);

                BankAccount.setInterestRate(interest);
            } else {
                int id = Integer.parseInt(data[1]);
                int years = Integer.parseInt(data[2]);

                if (map.containsKey(id)) {
                    BankAccount bankAccount = map.get(id);
                    double interest = bankAccount.getInterest(years);

                    output = String.format("%.2f", interest);
                } else {
                    output = "Account does not exist";
                }
            }

            if (!output.equals("")) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }
    }
}
