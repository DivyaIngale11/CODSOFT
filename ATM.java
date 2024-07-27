import java.util.Scanner;
//Project on ATM Machine interface using java
public class ATM {
    private static final int INITIAL_PIN = 1234;
    private static final String INITIAL_PASSWORD = "password123";
    private static final double INITIAL_BALANCE = 1000.00;

    private int pin;
    private String password;
    private double balance;

    public ATM() {
        this.pin = INITIAL_PIN;
        this.password = INITIAL_PASSWORD;
        this.balance = INITIAL_BALANCE;
    }

    public boolean authenticate(int enteredPin, String enteredPassword) {
        return enteredPin == pin && enteredPassword.equals(password);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: $%.2f%n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew: $%.2f%n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        if (atm.authenticate(enteredPin, enteredPassword)) {
            boolean running = true;

            while (running) {
                atm.displayMenu();
                int option = scanner.nextInt();
                scanner.nextLine(); 
                switch (option) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); 
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); 
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid PIN or password.");
        }

        scanner.close();
    }
}
