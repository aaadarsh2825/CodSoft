package
        myatmproject;
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initialize with a balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
