package SetsAndMaps;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeSet<String>> logsData = new TreeMap<>();
        Map<String, Integer> dataDuration = new HashMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            String IP = inputLine[0];
            String user = inputLine[1];
            int duration = Integer.parseInt(inputLine[2]);

            if (!logsData.containsKey(user)) {
                logsData.put(user, new TreeSet<>() {{
                    add(IP);
                }});
                dataDuration.put(user, duration);
            } else {
                logsData.get(user).add(IP);
                dataDuration.put(user, dataDuration.get(user) + duration);
            }
        }

        for (Map.Entry<String, TreeSet<String>> entry : logsData.entrySet()) {
            System.out.println(String.format("%s: %d %s",
                    entry.getKey(),
                    dataDuration.get(entry.getKey()),
                    entry.getValue()));
        }
    }
}
