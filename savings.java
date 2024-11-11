public class savings extends accounts{
    private double interest;
    private int limit;

    public savings(){
        super();
        interest = 0.0625;
        limit = 10000;
    }

    public void checkInterest(){
        int balance = this.getBalance();
        for(int i = 0; i < 10; i++){
            balance += balance * this.interest;
        }
        System.out.println("The balance after 10 years with an interest rate of 6.25% is: " + balance);
    }

    @Override
    public void withdraw(int amount){
        if(amount > limit){
            System.out.println("You have exceeded the limit of withdrawal.");
        }
        else if(this.getBalance() - amount < 0){
            System.out.println("Insufficient funds.");
        }
        else{
            this.setBalance(this.getBalance() - amount);
        }
    }
}