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
    
    @Override
    public void deposit(int amount){
        while(amount < 500){ // Minimum deposit amount is 500
            System.out.println("Deposit amount must be at least PHP 500.");
            System.out.print("Enter a valid deposit amount: ");
            amount = input.nextInt();  // Prompt user for a new amount
        }
        
        this.setBalance(this.getBalance() + amount);
        System.out.println("Deposit successful! New balance: PHP " + this.getBalance());
    }
    
}
