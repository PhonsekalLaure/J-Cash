public class Savings extends Accounts{
    private double interest;
    private int limit;

    public Savings(){
        super();
        interest = 0.0625;
        limit = 10000;
    }

    public void checkInterest(){
        int balance = this.getBalance();
        for(int i = 0; i < 10; i++){
            balance += balance * this.interest;
        }
        System.out.println("The balance after 10 years with an interest rate of 6.25% is: " + balance); //gagawing printf
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
    
}