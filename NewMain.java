import java.util.Scanner;

public class NewMain {
    private static final int adminPin = 1234;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0, choice3 = 0;
        String finalans = "", accNo;
        boolean found;
        Accounts acc[] = new Accounts[5];//array of accounts with a maximum of 5 accounts

        do{
            clearScreen();
            JCASH();
            System.out.println("1. Login\n2. Exit\n");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                    clearScreen();
                    JCASH();
                    System.out.println("LOGIN");
                    System.out.print("Enter account number\t: ");
                    accNo = input.nextLine();
                    found = false;

                    if(accNo.equalsIgnoreCase("admin")){
                        found = true;
                        
                        System.out.print("Enter Admin Pin \t: ");
                        if(adminAuth(input)){
                            do{
                                clearScreen();
                                JCASH();
                                System.out.println("ADMIN MENU");
                                System.out.println("1. Create Account\n2. Delete Account\n3. View Accounts\n4. Exit\n");
                                System.out.print("Enter choice: ");
                                choice2 = input.nextInt();

                                switch(choice2){
                                    case 1://creates an account
                                        if(count == 5){
                                            clearScreen();
                                            JCASH();
                                            System.out.println("Maximum number of accounts reached.");
                                            System.out.print("Press Enter to Continue...");
                                            input.nextLine();//waits for the user to press enter
                                            break;
                                        }
                                        else{
                                            clearScreen();
                                            JCASH();
                                            System.out.println("ACCOUNT CREATION");
                                            System.out.println("1. Savings\n2. Current\n3. Go Back");
                                            System.out.print("\nEnter choice: ");
                                            choice3 = input.nextInt();

                                            switch(choice3){
                                                case 1:
                                                    clearScreen();
                                                    JCASH();
                                                    acc[count] = new Savings();
                                                    createAccount(acc[count], input);
                                                    count++;
                                                    break;

                                                case 2:
                                                    clearScreen();
                                                    JCASH();
                                                    acc[count] = new Current();
                                                    createAccount(acc[count], input);
                                                    count++;
                                                    break;

                                                case 3:
                                                    break;

                                                default:
                                                    System.out.println("Invalid choice.");
                                                    System.out.print("\nPress Enter to Continue...");
                                                    input.nextLine();
                                            }
                                            if (choice3 < 3) {//if the user chose to create an account
                                                clearScreen();
                                                JCASH();
                                                System.out.println("Success!");
                                                System.out.println("Account with Account Number " + acc[count - 1].getAccountNo() + " Created!\n");
                                                input.nextLine();
                                                System.out.print("Press Enter to Continue...");
                                                input.nextLine();
                                            }
                                        }
                                        break;

                                    case 2://deletes an account

                                    case 3://display all accounts
                                        clearScreen();
                                        JCASH();
                                        if(count == 0){//checks if there are accounts to display
                                            System.out.println("No accounts to display.\n");
                                        }
                                        else{//if there are accounts
                                            System.out.println("DISPLAY USERS");
                                            Display(acc, count);//calls the Display method
                                        }
                                        input.nextLine();
                                        System.out.print("Press Enter to Continue...");
                                        input.nextLine();
                                        break;

                                    case 4://exits the admin menu
                                        break;
                                }
                                        
                            }while(choice2 != 4);
                        }
                        else{
                            System.out.println("\nAll attempts used. Going back to main menu.");
                            input.nextLine();
                            System.out.print("Press Enter to Continue...");
                            input.nextLine();
                            break;
                        }
                    }
                    else{
                        found = false;
                        for(int i = 0; i < count; i++){
                            if(Integer.parseInt(accNo) == acc[i].getAccountNo()){
                                found = true;

                                System.out.print("Enter Pin \t\t: ");
                                if(acc[i].verify(input.nextInt())){
                                    do { 
                                        clearScreen();
                                        JCASH();
                                        System.out.println("Welcome " + acc[i].getName().toUpperCase() + "!");
                                        System.out.println("1. Deposit\n2. Withdraw\n3. View Balance\n4. Currency Converter\n5. Account Details\n6. Exit\n");
                                        System.out.print("Enter choice: ");
                                        choice2 = input.nextInt();

                                        switch(choice2){
                                            case 1://deposits money to the account
                                            case 2://withdraws money from the account
                                            case 3://displays the account balance
                                            case 4://converts the currency
                                            case 5://displays the account details
                                                clearScreen();
                                                JCASH();
                                                acc[i].getDetails();//calls the getDetails method
                                                input.nextLine();
                                                System.out.print("\nPress Enter to Continue...");
                                                input.nextLine();
                                                break;

                                            case 6:
                                                break;
                                            
                                            default:
                                                System.out.println("Invalid choice.");
                                                input.nextLine();
                                                System.out.print("Press Enter to Continue...");
                                                input.nextLine();
                                        }
                                    } while (choice2 != 6);
                                }

                            }
                        }
                    }
                    if(!found){
                        System.out.println("\nAccount not found.");
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("Are you sure you want to exit? Y|N: ");
                    finalans = input.nextLine();
                    break;

                default:
                    System.out.println("Invalid choice.");
                    System.out.print("Press Enter to Continue...");
                    input.nextLine();
            }
        }while(!finalans.equalsIgnoreCase("Y"));

    }
    public static void JCASH(){//displays the Bank name
        System.out.println("------------------------------");
        System.out.println("\tJ-CASH BANKING");
        System.out.println("------------------------------");
    }

    public static void clearScreen() {//clears the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean adminAuth(Scanner input){//method to verify the pin
        int attempts = 0, pin;
        pin = input.nextInt();       // Number of attempts
        while (attempts < 3){ 
            if(adminPin == pin){//checks if the pin is correct
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

    public static void createAccount(Accounts account, Scanner input) {//creates an account
        account.setAccountNo();
        System.out.println("Account Number \t\t: " + account.getAccountNo());
        System.out.print("Enter Year of Birth \t: ");
        account.setYoB(input.nextInt());
        input.nextLine();
        System.out.print("Enter Name \t\t: ");
        account.setName(input.nextLine());
        System.out.print("Enter Address \t\t: ");
        account.setAddress(input.nextLine());
        System.out.print("Initial Deposit (PHP) \t: ");
        account.setInitialDepo(input.nextInt());
        System.out.print("Set Pin \t\t: ");
        account.setPin(input.nextInt());
    }

    public static void Display(Accounts[] acc, int count){//displays the accounts
        for(int i = 0; i < count; i++){
            System.out.println("Account Number\t: " + acc[i].getAccountNo());
            System.out.println("Account Type\t: " + acc[i].getClass().getSimpleName().toUpperCase());
            System.out.println();
        }
    }

    public static void authors(){//mga pogi
        System.out.println("Thank you for using J-CASH Banking.");
        System.out.println("Have a Nice Day!\n");
        System.out.println("Created by:");
        System.out.println("Marlo Veluz");
        System.out.println("Dominic Madlangbayan");
        System.out.println("Mark Gamboa");
        System.out.println("Ronn Rosarito\n");
    }

    public static void currencyConvert(int php){//converts PHP to other currencies
        System.out.printf("Your current balance is PHP%, .2f%n",(double) php);
        System.out.printf("Converted Balance:\n");
        
        double usd = php/50.0; //PHP to USD
        System.out.printf("\nUS Dollar \t:\t%, .2f%n",usd);
        
        //PHP to EURO
        System.out.printf("Euro\t\t:\t%, .2f%n",usd*0.734719);
        
        //PHP to YUAN
        System.out.printf("Yuan\t\t:\t%, .2f%n",usd*6.346934);
        
        //PHP to KORUNA
        System.out.printf("Koruna\t\t:\t%, .2f%n",usd*18.77263);
        
        //PHP to KRONE
        System.out.printf("Krone\t\t:\t%, .2f%n",usd*5.449007);
        
        //PHP to SHEGEL
        System.out.printf("Shegel\t\t:\t%, .2f%n",usd*3.726334);
        
        //PHP to DINAR
        System.out.printf("Dinar\t\t:\t%, .2f%n",usd*0.274588);
    }

    public static boolean confirmation(int accNo, Scanner input){//asks for confirmation before deleting an account
        System.out.print("Are you sure you want to delete your account " + accNo + "? (Y/N): ");
        String confirmation = input.nextLine().trim().toUpperCase();
        return confirmation.equals("Y");
    }
    
    public static void deleteAccount(Accounts[] acc, int index, int count) {//deletes an account
        for (int i = index; i < count - 1; i++) {
            acc[i] = acc[i + 1];
        }
        acc[count - 1] = null;
    }
}
