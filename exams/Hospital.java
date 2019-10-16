package exams;

import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> doctorsWithPatients = new HashMap<>();
        Map<String, Map<Integer, List<String>>> departmentsWithRoomsAndPatients = new HashMap<>();
        Map<String, Integer> roomIDs = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Output".equals(input)) {
            String department = input.substring(0, input.indexOf(" "));
            String doctor = input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" "));
            String patient = input.substring(input.lastIndexOf(" ") + 1);

            doctorsWithPatients.putIfAbsent(doctor, new ArrayList<>());
            doctorsWithPatients.get(doctor).add(patient);

            if (!departmentsWithRoomsAndPatients.containsKey(department)) {
                departmentsWithRoomsAndPatients.put(department, new HashMap<>());
                roomIDs.putIfAbsent(department, 0);
                roomIDs.put(department, roomIDs.get(department) + 1);
                departmentsWithRoomsAndPatients.get(department).put(roomIDs.get(department), new ArrayList<>());
                departmentsWithRoomsAndPatients.get(department).get(roomIDs.get(department)).add(patient);

            } else {
                if (departmentsWithRoomsAndPatients.get(department).get(roomIDs.get(department)).size() == 3) {
                    if (roomIDs.get(department) < 20) {
                        roomIDs.put(department, roomIDs.get(department) + 1);
                        departmentsWithRoomsAndPatients.get(department).put(roomIDs.get(department), new ArrayList<>());
                        departmentsWithRoomsAndPatients.get(department).get(roomIDs.get(department)).add(patient);
                    }
                } else {
                    departmentsWithRoomsAndPatients.get(department).get(roomIDs.get(department)).add(patient);
                }
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] command = input.split("\\s+");
            if (departmentsWithRoomsAndPatients.containsKey(command[0])) {
                if (command.length > 1) {
                    departmentsWithRoomsAndPatients.get(command[0]).
                            forEach((room, patients) -> {
                                if (room == Integer.parseInt(command[1])) {
                                    patients.stream()
                                            .sorted(String::compareTo)
                                            .forEach(System.out::println);
                                }
                            });
                } else {
                    departmentsWithRoomsAndPatients.get(command[0])
                            .forEach((room, patients) -> patients.forEach(System.out::println));
                }
            } else if (doctorsWithPatients.containsKey(input)) {
                doctorsWithPatients.get(input)
                        .stream()
                        .sorted(String::compareTo)
                        .forEach(System.out::println);
            }

            input = scanner.nextLine();
        }
    }
}
