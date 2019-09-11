package Practice.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {

            String name = scanner.next();
            int age = scanner.nextInt();

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(String.format("%s - %d", p.getName(), p.getAge())));
    }
}
