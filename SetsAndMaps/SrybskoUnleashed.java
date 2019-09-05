package SetsAndMaps;

        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> outcome = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            Matcher matcher = Pattern
                    .compile("(?<singer>[a-zA-Z ]+)\\s@(?<venue>[a-zA-Z ]+)\\s(?<price>\\d+)\\s(?<count>\\d+)")
                    .matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                int totalAmount = price * count;

                if (!outcome.containsKey(venue)) {
                    outcome.put(venue, new LinkedHashMap<>(){{put(singer, totalAmount);}});
                } else {
                    if (!outcome.get(venue).containsKey(singer)) {
                        outcome.get(venue).put(singer, totalAmount);
                    } else {
                        outcome.get(venue).put(singer, outcome.get(venue).get(singer) + totalAmount);
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : outcome.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(kvp -> System.out.printf("#  %s -> %d%n", kvp.getKey(), kvp.getValue()));
        }
    }
}
