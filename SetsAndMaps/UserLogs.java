package SetsAndMaps;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> usernames = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {

            List<String> elements = new ArrayList<>();

            String[] tokens = input.split("\\s+");
            for (String token : tokens) {
                String[] insideToken = token.split("=");
                elements.add(insideToken[1]);
            }

            String IP = elements.get(0);
            String user = elements.get(2);

            if (!usernames.containsKey(user)) {
                usernames.put(user, new LinkedHashMap<>());
                usernames.get(user).put(IP, 1);
            } else {
                if (!usernames.get(user).containsKey(IP)) {
                    usernames.get(user).put(IP, 1);
                } else {
                    usernames.get(user).put(IP, usernames.get(user).get(IP) + 1);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : usernames.entrySet()) {
            System.out.println(entry.getKey() + ":");
            StringBuilder output = new StringBuilder();
            for (Map.Entry<String, Integer> innerMap : entry.getValue().entrySet()) {
                output.append(innerMap.getKey()).append(" => ").append(innerMap.getValue()).append(", ");
            }
            output = new StringBuilder(output.substring(0, output.length() - 2));
            output.append(".");
            System.out.println(output);
        }
    }
}
