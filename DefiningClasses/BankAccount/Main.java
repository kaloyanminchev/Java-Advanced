package DefiningClasses.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens.length) {
                case 1:
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    System.out.println(String.format("BankAccount ID%d created", bankAccount.getId()));
                    break;
                case 2:
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case 3:
                    int id = Integer.parseInt(tokens[1]);
                    if (!bankAccountMap.containsKey(id)) {
                        System.out.println("BankAccount does not exist");
                    } else {
                        if ("Deposit".equalsIgnoreCase(tokens[0])) {
                            double amount = Double.parseDouble(tokens[2]);
                            bankAccountMap.get(id).deposit(amount);
                            System.out.println(String.format("Deposited %.0f to ID%d", amount, id));
                        } else {
                            int years = Integer.parseInt(tokens[2]);
                            System.out.println(String.format("%.2f", bankAccountMap.get(id).getInterest(years)));
                        }
                    }
                    break;
            }

            input = reader.readLine();
        }
    }
}
