import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0, accNo;
        String finalans = "";
        boolean found;
        Accounts acc[] = new Accounts[5];//array of accounts with a maximum of 5 accounts


        do { 
            clearScreen();//clears the screen
            JCASH();
            Menu();//displays the menu
            choice = input.nextInt();

            switch(choice){//switch case for the main menu
                case 1://create account
                    clearScreen();
                    JCASH();
                    if(count == 5){//checks if the maximum number of accounts is reached
                        System.out.println("Maximum number of accounts reached.\n");
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();//waits for the user to press enter
                        break;
                    }
                    else{//if the maximum number of accounts is not reached
                    System.out.println("ACCOUNT CREATION");
                    System.out.println("Choose Account Type: ");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    System.out.println("3. Go Back");
                    System.out.print("\nEnter choice: ");
                    choice2 = input.nextInt();
                    input.nextLine();

                    switch(choice2){
                        case 1://savings account
                            clearScreen();
                            JCASH();
                            acc[count] = new Savings();//instantiates a new savings account
                            createAccount(acc[count], input);//a static method to create an account
                            count++;//increments the count of accounts
                            break;

                        case 2://  current account
                            clearScreen();
                            JCASH();
                            acc[count] = new Current();//instantiates a new current account
                            createAccount(acc[count], input);//a static method to create an account
                            count++;//increments the count of accounts
                            break;

                        case 3://go back
                            break;//breaks the switch case

                        default:
                            System.out.println("Invalid choice.");
                            System.out.print("\nPress Enter to Continue...");
                            input.nextLine();
                    }
                    if (choice2 < 3) {//if the user chose to create an account
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

                case 2://account settings
                    clearScreen();
                    JCASH();
                    System.out.println("ACCOUNT SETTINGS");

                    if(count == 0){//checks if there are accounts to continue this action
                        System.out.println("No accounts to continue this action.\n");
                        input.nextLine();
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                        break;
                    }
                    else{//if there are accounts
                        System.out.print("Enter Account Number \t: ");
                        accNo = input.nextInt();

                        found = false;
                        for(int i = 0; i < count; i++){//searches for the account number
                        if(acc[i].getAccountNo() == accNo){//if the account number is found
                            found = true;

                                System.out.print("Enter Pin \t\t: ");
                                if(acc[i].verify(input.nextInt())){//verifies the pin
                                    clearScreen();
                                    JCASH();
                                    System.out.println("ACCOUNT SETTINGS");
                                    System.out.println("1. Balance Inquiry");
                                    System.out.println("2. Account Details");
                                    System.out.println("3. Currency Converter");
                                    System.out.println("4. Delete Account");
                                    System.out.println("5. Go Back");
                                    System.out.print("\nEnter choice: ");
                                    choice2 = input.nextInt();
                                    input.nextLine();

                                    switch(choice2){
                                        case 1:// Balance Inquiry
                                            clearScreen();
                                            JCASH();
                                            acc[i].viewBalance();//calls the viewBalance method
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 2://Account Details
                                            clearScreen();
                                            JCASH();
                                            acc[i].getDetails();//calls the getDetails method
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 3://Currency Converter
                                            clearScreen();
                                            JCASH();
                                            currencyConvert(acc[i].getBalance());//calls the currencyConvert method
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 4://delete account
                                            clearScreen();
                                            JCASH();
                                            if(confirmation(accNo, input)){//calls the confirmation method
                                                deleteAccount(acc, i, count);//calls the deleteAccount method
                                                count--;//decrements the count of accounts
                                                System.out.println("Account Deleted.");
                                                System.out.print("\nPress Enter to Continue...");
                                                input.nextLine();
                                            } else {//if the user does not confirm the deletion
                                                System.out.println("Account not deleted.");
                                                System.out.print("\nPress Enter to Continue...");
                                                input.nextLine();
                                            }
                                            break;

                                        case 5://go back
                                            break;

                                        default:
                                            System.out.println("Invalid choice.");
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                    }
                                }
                                else{//if the user has used all 3 attempts
                                    System.out.println("All attempts used. Going back to main menu.");
                                    input.nextLine();
                                    System.out.print("\nPress Enter to Continue...");
                                    input.nextLine();
                                    break;
                                }
                        }
                    }
                    if(!found){//if the account number is not found
                        System.out.println("Account not found.\n");
                        input.nextLine();
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                    }
                    }
                    break;
                    
                case 3://transactions
                    clearScreen();
                    JCASH();
                    System.out.println("TRANSACTIONS");
                    if(count == 0){//checks if there are accounts to continue this action
                        System.out.println("No accounts to continue this action.\n");
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                        input.nextLine();
                        break;
                    }
                    else{//if there are accounts
                        System.out.print("Enter Account Number \t: ");
                        accNo = input.nextInt();
                        found = false;

                    for (int i = 0; i < count; i++) {//searches for the account number
                        if (acc[i].getAccountNo() == accNo) {//if the account number is found
                            found = true;

                            System.out.print("Enter Pin \t\t: ");
                            if (acc[i].verify(input.nextInt())) {//verifies the pin
                                clearScreen();
                                JCASH();
                                System.out.println("TRANSACTIONS");
                                System.out.println("1. Deposit");
                                System.out.println("2. Withdraw");
                                System.out.println("3. Go Back");
                                System.out.print("\nEnter choice: ");
                                choice2 = input.nextInt();

                                switch (choice2) {
                                    case 1: // Deposit
                                        clearScreen();
                                        JCASH();
                                        System.out.println("DEPOSIT");
                                        System.out.print("Enter Deposit Amount \t: PHP ");
                                        acc[i].deposit(input.nextInt());//calls the deposit method
                                        input.nextLine();
                                        System.out.print("\nPress Enter to Continue...");
                                        input.nextLine();
                                        break;

                                    case 2: // Withdraw
                                        clearScreen();
                                        JCASH();
                                        System.out.println("WITHDRAW");
                                        System.out.print("Enter Withdrawal Amount : PHP ");
                                        if(acc[i].withdraw(input.nextInt())){//calls the withdraw method, if it returns true, withdrawal is successful
                                            clearScreen();
                                            System.out.println("Account Number \t: " + acc[i].getAccountNo());
                                            System.out.printf("Withdrawal successful! \nNew balance \t: PHP%, .2f%n", (double) acc[i].getBalance());
                                            input.nextLine();
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                        }
                                        else{//if the withdrawal is not successful
                                            System.out.println("Withdrawal failed.");
                                            input.nextLine();
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                        }
                                        break;

                                    case 3: // Go Back
                                        break;

                                    default:
                                        System.out.println("Invalid choice.");
                                        input.nextLine();
                                        System.out.print("\nPress Enter to Continue...");
                                        input.nextLine();
                                }
                            }
                            else {//if the user has used all 3 attempts
                                System.out.println("All attempts used. Going back to main menu.");
                                input.nextLine();
                                System.out.print("\nPress Enter to Continue...");
                                input.nextLine();
                            }
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                        input.nextLine();
                        System.out.print("\nPress Enter to Continue...");
                        input.nextLine();
                    }
                    }
                    break;

                case 4://display users
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

                case 5://exit
                    clearScreen();
                    JCASH();
                    input.nextLine();
                    System.out.print("Are You Sure You Want To Exit? Y|N: ");
                    finalans = input.nextLine();
                    break;

                default:
                    System.out.println("Invalid choice.");
                    input.nextLine();
                    System.out.print("Press Enter to Continue...");
                    input.nextLine();
            }
        } while (!finalans.equalsIgnoreCase("Y"));//loops until the user chooses to exit
        input.close();
        clearScreen();
        JCASH();
        authors();
    }
    public static void Menu(){//displays the menu
        System.out.println("1. Create Account");
        System.out.println("2. Account Settings");
        System.out.println("3. Transactions");
        System.out.println("4. Display Users");
        System.out.println("5. Exit");
        System.out.print("\nEnter choice: ");
    }

    public static void JCASH(){//displays the Bank name
        System.out.println("------------------------------");
        System.out.println("\tJ-CASH BANKING");
        System.out.println("------------------------------");
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
            System.out.println("Account Type\t: " + acc[i].getClass().getSimpleName());
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

    public static void clearScreen() {//clears the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
