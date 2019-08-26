package StacksAndQueues;

        import java.util.ArrayDeque;
        import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printJobs = new ArrayDeque<>();

        String fileName = scanner.nextLine();
        while (!"print".equals(fileName)) {
            if (!"cancel".equals(fileName)) {
                printJobs.offer(fileName);
            } else {
                if (printJobs.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printJobs.poll());
                }
            }
            fileName = scanner.nextLine();
        }

        while (!printJobs.isEmpty()) {
            System.out.println(printJobs.poll());
        }
    }
}
