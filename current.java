public class current extends accounts {
    public current(){
        super();
    }

    @Override
    public void withdraw(int amount){
        if(this.getBalance() - amount < 0){
            System.out.println("Insufficient funds.");
        }
        else{
            this.setBalance(this.getBalance() - amount);
        }
    }
}
