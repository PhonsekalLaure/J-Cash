public class Current extends Accounts {
    public Current(){
        super();
    }

    @Override//overridden method from accounts, this method is used to withdraw money from the account
    public boolean withdraw(int amount){
        while(amount < 500){ // Minimum withdrawal amount is 500
            System.out.println("Withdrawal amount must be at least PHP 500.");
            System.out.print("Enter a valid withdrawal amount: ");
            amount = input.nextInt();  // Prompt user for a new amount
        }
        
        if(this.getBalance() - amount < 0){// checks if the balance is enough to withdraw the amount
            System.out.println("Insufficient funds.");
            return false;
        }
        else if(amount <= 0){//checks if the amount is valid
            System.out.println("Invalid amount.");
            return false;
        }
        else{//if the amount is valid and the balance is enough, the amount is withdrawn
            this.setBalance(this.getBalance() - amount);
            return true;
        }
    }

    @Override//overridden method from accounts, this method is used to view balance and checking if account type has interest
    public void viewBalance(){
        System.out.println("BALANCE INQUIRY");
        System.out.println("Account type\t: Current");
        System.out.printf("Account Balance\t: PHP %, .2f%n",(double) this.getBalance());
        
    }
}
