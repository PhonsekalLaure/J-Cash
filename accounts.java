import java.util.Random;

public abstract class accounts {
    private int accountNo;  //randomly assigned 3 digit number
    private String name;    //name of the account holder
    private int pin;    //write only 4 digit pin
    private int YoB;    // year of birth
    private int initialDepo;    //initial deposit for account creation
    private int balance;    //current balance in the account
    

    public accounts() {
        name = " ";
        pin = 0;
        accountNo = 0;
        initialDepo = 0;
        YoB = 0;
    }

    private int setAccountNo() {
        Random accountNo = new Random();
        this.accountNo = accountNo.nextInt(900) + 100; // Generates a random number between 100 and 999
        return this.accountNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPin(int pin) {
        this.pin = pin; //lalagyan ng if else sa main
    }

    public void setYoB(int yob){
        if(2024 - yob < 18){
            System.out.println("You must be 18 years or older to open an account."); //ito pwede sa main na ilagay
        }
        else{
            this.YoB = yob;
        }
    }

    public void setInitialDepo(int initialDepo) {
        if(initialDepo < 3000){
            System.out.println("Initial deposit must be greater than 3000.");//ito din sa main nalang
        }
        else{
            this.initialDepo = initialDepo;
        }
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNo(){
        return this.accountNo;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.YoB - 2024;
    }

    public int getInitialDepo(){
        return this.initialDepo;
    }

    public int getBalance(){
        return this.balance;
    }

    public void deposit(int amount){
        boolean firstDepo = false;
        if(!firstDepo){
            this.balance += amount + this.initialDepo;
            firstDepo = true;
        }
        else{
            this.balance += amount;
        }
    }

    public abstract void withdraw(int amount);
}