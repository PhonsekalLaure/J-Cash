import java.lang.Math;

public class Savings extends Accounts{
    private double interest;
    private int limit;

    public Savings(){
        super();
        interest = 0.0625;
        limit = 10000;
    }

    @Override
    public boolean withdraw(int amount){
        while(amount < 500){ // Minimum withdrawal amount is 500
            System.out.println("Withdrawal amount must be at least PHP 500.");
            System.out.print("Enter a valid withdrawal amount: ");
            amount = input.nextInt();  // Prompt user for a new amount
        }

        while(true){
            if(amount > this.limit){
                System.out.println("You have exceeded the limit of withdrawal.");
                return false;
            }
            else if(this.getBalance() - amount < 0){
                System.out.println("Insufficient funds.");
                return false;
            }
            else if(amount <= 0){
                System.out.println("Invalid amount.");
                return false;
            }
            else{
                this.setBalance(this.getBalance() - amount);
                return true;
            }
        }
    }

    @Override//overridden method from accounts, this method is used to view balance and checking if account type has interest
    public void viewBalance(){
        int principal = this.getBalance();
        System.out.println("BALANCE INQUIRY");
        System.out.println("Account type\t\t: Savings");
        System.out.printf("Account Balance\t\t: PHP %, .2f%n",(double) this.getBalance());
        System.out.printf("Current Interest\t: 6.25%%") ;
        System.out.printf("\n\nTotal balance with interest after 1 year\t\t: PHP %, .2f%n",(double) principal * Math.pow(1 + this.interest, 1));
        System.out.printf("Total balance with interest after 5 years\t\t: PHP %, .2f%n",(double) principal * Math.pow(1 + this.interest, 5));
        System.out.printf("Total balance with interest after 10 years\t\t: PHP %, .2f%n",(double) principal * Math.pow(1 + this.interest, 10));
        }
    
}