import java.util.ArrayList;
import java.util.Random;


public class BankAccount {
    //instance variables
    private int accountNumber;
    private String name;
    private double balance;

    //static properties
    private static double interest = 0.3;
    private static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    //The first constructor receives a name and creates bank account with balance = 0
    public  BankAccount (String name) {
        //TODO 1.1
        accountNumber = getAccountNumber();
        this.name = name;
    }

    //The second constructor receives name and balance, creates a bank amount and updates balance
    public BankAccount (String name, double balance) {
        //TODO 1.2
        accountNumber = getAccountNumber();
        this.name = name;
        this.balance = balance;
    }

    //This method performs deposit operation
    public double deposit(double money) {
        //TODO 2
        if (money >= 0){
            balance += money;
            return balance;
        }else {
            return -1;
        }
    }

    //This method performs withdraw operation
    public double withdrawMoney(double money) {
        //TODO 3
        if (balance >= money){
            balance -= money;
            return money;
        }else if (money < 0){
            return -1;
        }else return -1;
    }

    //This method returns account number
    public int getAccountNumber() {
        //TODO 4
        Random random = new Random();
        accountNumber = random.nextInt(999999);
        return accountNumber;
    }

    //This method returns interest rate
    public static double getInterestRate() {
        //TODO 5
        if (accounts.size() % 5 == 0 ){
            int fiveNum = accounts.size() / 5;
//            System.out.println(interest - fiveNum*0.02);
            interest = interest - fiveNum * 0.02;
            interest = Math.round(interest * 100) * 0.01;
//            System.out.println(interest);
            return interest;
        }else {
            int fiveNum2 = (accounts.size() - accounts.size() % 5) / 5;
            if (fiveNum2 >= 1){
                interest = 0.3 - fiveNum2 * 0.02;
                interest = Math.round(interest * 100) * 0.01;
                return interest;
            }else {
                return 0.3;
            }
        }
    }

    //This method performs a transfer operation to a single bank account
    public double transfer(BankAccount destinationBankAccount, double amount) {
        //TODO 6
        if (this.balance < amount) {
            return -1;
        } else if (destinationBankAccount == null){
            return -1;
        }else if (amount < 0){
            return -1;
        }else {
            this.balance -= amount;
            destinationBankAccount.deposit(amount);
            return amount;
        }
    }

    //This method performs a transfer operation to multiple accounts
    public double transfer(BankAccount[] destinationBankAccount, double amount) {
        //TODO 7
        if (this.balance < amount) {
            return -1;
        } else if (destinationBankAccount == null){
            return -1;
        }else if (amount < 0) {
            return -1;
        }else if (destinationBankAccount.length == 0){
            return -1;
        }else {
            this.balance -= amount * destinationBankAccount.length;
            for (int i = 0; i < destinationBankAccount.length; i++){
                destinationBankAccount[i].deposit(amount);
            }
            return amount;
        }
    }

    public static void main(String args[]) {
        //Feel free to add code that will help you test your methods
        BankAccount bankAccount = new BankAccount("Sion", 100);
        BankAccount bankAccount1 = new BankAccount("Jearl", 80);
        BankAccount bankAccount2 = new BankAccount("Nelly", 100);
        BankAccount bankAccount3 = new BankAccount("Andrew", 100);
        BankAccount bankAccount4 = new BankAccount("Johnathan", 100);
        BankAccount bankAccount5 = new BankAccount("Larry", 200);
        BankAccount bankAccount6 = new BankAccount("Joe", 150);
        BankAccount bankAccount7 = new BankAccount("Josh", 135);
        BankAccount bankAccount8 = new BankAccount("Matt", 250);
        BankAccount bankAccount9 = new BankAccount("Tom", 213.4);
        BankAccount bankAccount10 = new BankAccount("May", 1000);

        accounts.add(bankAccount);
        accounts.add(bankAccount1);
        accounts.add(bankAccount2);
        accounts.add(bankAccount3);
        accounts.add(bankAccount4);

        accounts.add(bankAccount5);
        accounts.add(bankAccount6);
        accounts.add(bankAccount7);
        accounts.add(bankAccount8);
        accounts.add(bankAccount9);

        accounts.add(bankAccount10);

//        System.out.println(accounts.size());
//        System.out.println(getInterestRate());
//
//        System.out.println(bankAccount.deposit(20));
//        System.out.println(bankAccount1.deposit(52.55));

        BankAccount[] multTransferTest = new BankAccount[5];
        multTransferTest[0] = bankAccount;
        multTransferTest[1] = bankAccount;
        multTransferTest[2] = bankAccount2;
        multTransferTest[3] = bankAccount3;
        multTransferTest[4] = bankAccount4;

        bankAccount10.transfer(multTransferTest, 100);
        System.out.println(bankAccount10.balance);
        System.out.println(bankAccount.balance);
    }
}