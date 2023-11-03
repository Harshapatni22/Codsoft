import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("$" + amount + " has been deposited. Your new balance is: $" + account.getBalance());
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("$" + amount + " has been withdrawn. Your new balance is: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        int choice;
        double amount;

        do {
            atm.displayMenu();
            System.out.print("Enter your choice (1/2/3/4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}