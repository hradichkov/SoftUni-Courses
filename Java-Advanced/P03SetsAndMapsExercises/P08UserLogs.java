package P03SetsAndMapsExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();

        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String ipAddressParts = data[0];
            String usernameParts = data[2];
            String ipAddress = ipAddressParts.substring(3);
            String username = usernameParts.substring(5);

            if (!usersMap.containsKey(username)) {
                usersMap.put(username, new LinkedHashMap<>());
            }
            if (!usersMap.get(username).containsKey(ipAddress)) {
                usersMap.get(username).put(ipAddress, 1);
            } else {
                usersMap.get(username).put(ipAddress, usersMap.get(username).get(ipAddress) + 1);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : usersMap.entrySet()) {
            System.out.println(user.getKey() + ":");
            LinkedHashMap<String, Integer> ipAddresses = user.getValue();
            StringBuilder sb = new StringBuilder();

            for (Map.Entry<String, Integer> ipAddress : ipAddresses.entrySet()) {
                String currentIpAddress = String.format("%s => %d, ", ipAddress.getKey(), ipAddress.getValue());
                sb.append(currentIpAddress);
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";
            System.out.println(finalOutput);
        }
    }
}
