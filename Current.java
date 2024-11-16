public class Current extends accounts {
    public Current(){
        super();
    }

    @Override
    public boolean withdraw(int amount){
        while(amount < 500){ // Minimum withdrawal amount is 500
            System.out.println("Withdrawal amount must be at least PHP 500.");
            System.out.print("Enter a valid withdrawal amount: ");
            amount = input.nextInt();  // Prompt user for a new amount
        }
        
        if(this.getBalance() - amount < 0){
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
