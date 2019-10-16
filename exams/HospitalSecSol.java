package exams;

import java.util.*;

public class HospitalSecSol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> departmentsAndPatients = new HashMap<>();
        Map<String, List<String>> doctorsAndPatients = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Output".equals(input)) {
            String[] tokens = input.split("\\s+");
            String department = tokens[0];
            String doctor = tokens[1] + " " + tokens[2];
            String patient = tokens[3];

            departmentsAndPatients.putIfAbsent(department, new ArrayList<>());
            departmentsAndPatients.get(department).add(patient);

            doctorsAndPatients.putIfAbsent(doctor, new ArrayList<>());
            doctorsAndPatients.get(doctor).add(patient);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] command = input.split("\\s+");
            if (command.length == 1) {
                if (departmentsAndPatients.containsKey(command[0])) {
                    departmentsAndPatients.get(command[0]).forEach(System.out::println);
                }
            } else {
                String doctor = command[0] + " " + command[1];

                if (doctorsAndPatients.containsKey(doctor)) {
                    doctorsAndPatients.get(doctor).stream().sorted(String::compareTo).forEach(System.out::println);
                } else {
                    int room = Integer.parseInt(command[1]);
                    if (room > 20 || room < 0) {
                        continue;
                    }

                    int numberOfPatientInDepartment = (room - 1) * 3;
                    Set<String> patientsOfGivenRoom = new TreeSet<>();
                    for (int i = numberOfPatientInDepartment; i < numberOfPatientInDepartment + 3; i++) {
                        if (i + 1 <= departmentsAndPatients.get(command[0]).size()) {
                            patientsOfGivenRoom.add(departmentsAndPatients.get(command[0]).get(i));
                        }
                    }
                    patientsOfGivenRoom.forEach(System.out::println);
                }
            }

            input = scanner.nextLine();
        }
    }
}
