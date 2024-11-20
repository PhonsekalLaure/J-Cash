import java.util.Random;
import java.util.Scanner;
public abstract class Accounts {
    private int accountNo;  //randomly assigned 3 digit number
    private String name;    //name of the account holder
    private String address; //address of the account holder
    private int pin;    //write only 4 digit pin
    private int YoB;    // year of birth
    private int balance;    //current balance in the account
    
    
    Scanner input = new Scanner(System.in);

    public Accounts() {
        name = null;
        pin = 0;
        address = null;
        accountNo = 0;
        YoB = 0;
    }

    public void setAccountNo() {
        Random accountNo = new Random();
        this.accountNo = accountNo.nextInt(900) + 100; // Generates a random number between 100 and 999
    }

    public void setName(String name) {//a setter method for name
        this.name = name;
    }

    public void setAddress(String address) {//a setter method for address
        this.address = address;
    }

    public void setPin(int pin) {//a setter method for pin
        while(true){//loops until the pin is a 4 digit number
            if(pin < 1000 || pin > 9999){//checks if the pin is a 4 digit number
                System.out.println("PIN must contain 4 digits.");
                System.out.print("Enter Again \t\t: ");
                pin = input.nextInt();
            }
            else{
                this.pin = pin;
                break;
            }
        }
    }

    public void setYoB(int yob){//a setter method for year of birth
        while(true){//loops until the year of birth is valid
            if(2024 - yob < 18){//checks if the account holder is 18 years old or older
                System.out.println("You must be 18 years old or older to create an account.");
                System.out.print("Enter Again \t\t: ");
                yob = input.nextInt();
            }
            else if(yob < 1900){//checks if the year of birth is valid
                System.out.println("Invalid year of birth.");
                System.out.print("Enter Again \t\t: ");
                yob = input.nextInt();
            }
            else{
                this.YoB = yob;
                break;
            }
        }
    }

    public void setInitialDepo(int initialDepo) {//a setter method for initial deposit
        while(true){//loops until the initial deposit is valid
            if(initialDepo < 3000){//checks if the initial deposit is at least 3000
                System.out.println("Initial deposit must be at least PHP 3000.");
                System.out.print("Enter Again \t\t: ");
                initialDepo = input.nextInt();
            }
            else{
                this.balance = initialDepo;
                break;
            }
        }
    }

    public void setBalance(int balance) {//a setter method for balance
        this.balance = balance;
    }

    public int getAccountNo(){//a getter method for account number
        return this.accountNo;
    }

    public String getName(){//a getter method for name
        return this.name;
    }

    public String getAddress(){//a getter method for address
        return this.address;
    }

    public int getAge(){//a getter method for age
        return 2024 - this.YoB;
    }

    public int getBalance(){//a getter method for balance
        return this.balance;
    }

    public void deposit(int amount){//method to deposit money to the account
        while(amount < 500){ // Minimum deposit amount is 500
            System.out.println("Deposit amount must be at least PHP 500.");
            System.out.print("Enter a valid deposit amount : ");
            amount = input.nextInt();  // Prompt user for a new amount
        }
        
        this.setBalance(this.getBalance() + amount);
        System.out.println("Account Number \t: " + this.getAccountNo());
        System.out.printf("Deposit successful! \nNew balance \t: PHP%, .2f%n", (double) this.getBalance());
    }

    public void getDetails(){//method to display the account details
        System.out.println("Account Number \t: " + this.getAccountNo());
        System.out.println("Account Type \t: " + this.getClass().getSimpleName());
        System.out.println("Name \t\t: " + this.getName());
        System.out.println("Age \t\t: " + this.getAge());
        System.out.println("Address \t: " + this.getAddress());
    }

    public boolean verify(int pin){//method to verify the pin
        int attempts = 0;       // Number of attempts
        while (attempts < 3){ 
            if(this.pin == pin){//checks if the pin is correct
                return true;
            }
            else{//if the pin is incorrect, the user is given 3 attempts to enter the correct pin
                if (attempts == 2) {//forcefully ends the loop when the user has used all 3 attempts
                    return false;
                }
                else{//if the user has not used all 3 attempts, the user is prompted to enter the pin again
                    System.out.println("INCORRECT PIN. " + (2 - attempts) + " attempts left.");
                    System.out.print("Enter Again \t\t: ");
                    pin = input.nextInt();
                    attempts++;
                }   
            }
        }
        return false;
    }

    public abstract boolean withdraw(int amount);//abstract method to withdraw money from the account

    public abstract void viewBalance();//abstract method to view the balance in the account
}