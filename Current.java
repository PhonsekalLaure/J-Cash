public class Current extends accounts {
    public Current(){
        super();
    }

    @Override
    public boolean withdraw(int amount){
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
