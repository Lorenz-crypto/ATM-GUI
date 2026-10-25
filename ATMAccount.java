public class ATMAccount {
    private String accountNumber;
    private String accountName;
    private String pin;
    private double balance;

    public ATMAccount(String accountNumber, String accountName, String pin, double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.pin = pin;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

     public String getAccountName(){
        return accountName;
    }

    public String Deposit(double amount){
        if (amount <= 0){
            return "Deposit amount must be greater than zero";
        }
        balance += amount;
        return "Deposit successful!";
    }

    public String Withdraw(String enteredPin, double amount){
        if (!pin.equals(enteredPin)) {
            return "Incorrect PIN";
        }
        if (amount % 50 != 0){
            return "WIthdrawal must be multiple of 50";
        }
        if (amount > balance - 100){
            return "Insufficient funds You must maintain a balance of 100";
        }
        balance -= amount;
        return "Withdrawal successful";
    }

    public String changePin(String oldPin, String newPin){
        if (!pin.equals(oldPin)){
            return "Incorrect old PIN";
        }
        if (pin.equals(newPin)){
            return "New PIN ust be different from old PIN";
        }
        pin = newPin;
        return "PIN changed successfully!";
    }
}
