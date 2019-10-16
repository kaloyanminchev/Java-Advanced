package exams;

import java.util.*;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> line = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(line::push);

        ArrayDeque<String> halls = new ArrayDeque<>();
        Map<String, List<String>> fullHalls = new LinkedHashMap<>();

        while (!line.isEmpty()) {
            String currentElement = line.pop();

            if (Character.isLetter(currentElement.charAt(0))) {
                halls.offer(currentElement);
            } else {
                if (halls.size() > 0) {
                    String firstHall = halls.peek();
                    fullHalls.putIfAbsent(firstHall, new ArrayList<>());

                    if (Integer.parseInt(currentElement) + fullHalls.get(firstHall).stream()
                            .mapToInt(Integer::parseInt)
                            .sum() > capacity) {
                        System.out.println(firstHall + " -> " + String.join(", ", fullHalls.get(firstHall)));
                        fullHalls.remove(firstHall);
                        halls.poll();
                        line.push(currentElement);
                    } else {
                        fullHalls.get(firstHall).add(currentElement);
                    }
                }
            }
        }
    }
}
