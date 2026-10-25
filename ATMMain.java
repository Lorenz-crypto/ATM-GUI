import javax.swing.*;
public class ATMMain {
    public static void main(String[] args){
        ATMAccount account = new ATMAccount(
        "1001",
        "Mark Ingalla",
        "1234",
        10000);

        JFrame frame = new JFrame("ATM SYSTEM");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcome = new JLabel("Welcome, " +account.getAccountName() +"!");
        welcome.setBounds(100,30,250,30);

        JButton balanceButton = new JButton("Check Balance");
        balanceButton.setBounds(100,80,200,40);

         JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(100,130,200,40);

         JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(100,180,200,40);

         JButton changePinButton = new JButton("Change PIN");
        changePinButton.setBounds(100,230,200,40);

        balanceButton.addActionListener(e -> {
             JOptionPane.showMessageDialog(frame, "Current balance: " + account.getBalance());
        });

         depositButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(frame, "Enter deposit amount:");
            if (input != null){
                double amount = Double.parseDouble(input);

                String result = account.Deposit(amount);
                    JOptionPane.showMessageDialog(frame, result);
            }
        });

        withdrawButton.addActionListener(e -> {
            String pin = JOptionPane.showInputDialog(frame, "Enter PIN:");
            if (pin == null){
                return;
            }
            String input = JOptionPane.showInputDialog(frame, "Enter withdrawal amount:");
            if (input != null){
                double amount = Double.parseDouble(input);
                String result = account.Withdraw(pin, amount);
                
                JOptionPane.showMessageDialog(frame, result);
            }           
        });

         changePinButton.addActionListener(e -> {
            String oldpin = JOptionPane.showInputDialog(frame, "Enter old PIN:");
            if (oldpin == null){
                return;
            }
            String newpin = JOptionPane.showInputDialog(frame, "Enter new PIN:");
            if (newpin == null){
               return;
            }           
            String result = account.changePin(oldpin, newpin);
            JOptionPane.showMessageDialog(frame, result);
        });

        frame.add(welcome);
        frame.add(balanceButton);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(changePinButton);

        frame.setVisible(true);
    }
}
