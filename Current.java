public class Current extends accounts {
    public Current(){
        super();
    }

    @Override
    public void withdraw(int amount){
        if(this.getBalance() - amount < 0){
            System.out.println("Insufficient funds.");
        }
        else if(amount <= 0){
            System.out.println("Invalid amount.");
        }
        else{
            this.setBalance(this.getBalance() - amount);
        }
    }
}
