import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0, accNo;
        String finalans = "";
        boolean found;
        Accounts acc[] = new Accounts[5];


        do { 
            clearScreen();
            JCASH();
            Menu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    clearScreen();
                    JCASH();
                    if(count == 5){
                        System.out.println("Maximum number of accounts reached.\n");
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                        break;
                    }
                    else{
                    System.out.println("ACCOUNT CREATION");
                    System.out.println("Choose Account Type: ");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    System.out.println("3. Go Back");
                    System.out.print("\nEnter choice: ");
                    choice2 = input.nextInt();
                    input.nextLine();

                    switch(choice2){
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
                    }
                    if (choice2 != 3) {
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

                case 2:
                    clearScreen();
                    JCASH();
                    System.out.println("ACCOUNT SETTINGS");

                    if(count == 0){
                        System.out.println("No accounts to continue this action.\n");
                        input.nextLine();
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                        break;
                    }
                    else{
                        System.out.print("Enter Account Number \t: ");
                        accNo = input.nextInt();

                        found = false;
                        for(int i = 0; i < count; i++){
                        if(acc[i].getAccountNo() == accNo){
                            found = true;

                                System.out.print("Enter Pin \t\t: ");
                                if(acc[i].verify(input.nextInt())){
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
                                            acc[i].viewBalance();
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 2://Account Details
                                            clearScreen();
                                            JCASH();
                                            acc[i].getDetails();
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 3://Currency Converter
                                            clearScreen();
                                            JCASH();
                                            currencyConvert(acc[i].getBalance());
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 4:// 
                                            clearScreen();
                                            JCASH();
                                            break;

                                        case 5:
                                            break;

                                        default:
                                            System.out.println("Invalid choice.");
                                            input.nextLine();
                                            System.out.print("Press Enter to Continue...");
                                            input.nextLine();
                                    }
                                }
                                else{
                                    System.out.println("All attempts used. Going back to main menu.");
                                    input.nextLine();
                                    System.out.print("\nPress Enter to Continue...");
                                    input.nextLine();
                                    break;
                                }
                        }
                    }
                    if(!found){
                        System.out.println("Account not found.\n");
                        input.nextLine();
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                    }
                    }
                    break;
                    
                case 3:
                    clearScreen();
                    JCASH();
                    System.out.println("TRANSACTIONS");
                    if(count == 0){
                        System.out.println("No accounts to continue this action.\n");
                        System.out.print("Press Enter to Continue...");
                        input.nextLine();
                        input.nextLine();
                        break;
                    }
                    else{
                        System.out.print("Enter Account Number \t: ");
                        accNo = input.nextInt();
                        found = false;

                    for (int i = 0; i < count; i++) {
                        if (acc[i].getAccountNo() == accNo) {
                            found = true;

                            System.out.print("Enter Pin \t\t: ");
                            if (acc[i].verify(input.nextInt())) {
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
                                        acc[i].deposit(input.nextInt());
                                        input.nextLine();
                                        System.out.print("\nPress Enter to Continue...");
                                        input.nextLine();
                                        break;

                                    case 2: // Withdraw
                                        clearScreen();
                                        JCASH();
                                        System.out.println("WITHDRAW");
                                        System.out.print("Enter Withdrawal Amount : PHP ");
                                        if(acc[i].withdraw(input.nextInt())){
                                            clearScreen();
                                            System.out.println("Account Number \t: " + acc[i].getAccountNo());
                                            System.out.printf("Withdrawal successful! \nNew balance \t: PHP%, .2f%n", (double) acc[i].getBalance());
                                            input.nextLine();
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                        }
                                        else{
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
                            else {
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

                case 4:
                    clearScreen();
                    JCASH();
                    if(count == 0){
                        System.out.println("No accounts to display.\n");
                    }
                    else{
                        System.out.println("DISPLAY USERS");
                        Display(acc, count);
                    }
                    input.nextLine();
                    System.out.print("Press Enter to Continue...");
                    input.nextLine();
                    break;

                case 5:
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
        } while (!finalans.equalsIgnoreCase("Y"));
        clearScreen();
        JCASH();
        authors();
    }
    public static void Menu(){
        System.out.println("1. Create Account");
        System.out.println("2. Account Settings");
        System.out.println("3. Transactions");
        System.out.println("4. Display Users");
        System.out.println("5. Exit");
        System.out.print("\nEnter choice: ");
    }

    public static void JCASH(){
        System.out.println("------------------------------");
        System.out.println("\tJ-CASH BANKING");
        System.out.println("------------------------------");
    }

    public static void createAccount(Accounts account, Scanner input) {
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

    public static void Display(Accounts[] acc, int count){
        for(int i = 0; i < count; i++){
            System.out.println("Account Number\t: " + acc[i].getAccountNo());
            System.out.println("Account Type\t: " + acc[i].getClass().getSimpleName());
            System.out.println();
        }
    }

    public static void authors(){
        System.out.println("Thank you for using J-CASH Banking.");
        System.out.println("Have a Nice Day!\n");
        System.out.println("Created by:");
        System.out.println("Marlo Veluz");
        System.out.println("Dominic Madlangbayan");
        System.out.println("Mark Gamboa");
        System.out.println("Ronn Rosarito\n");
    }

    public static void currencyConvert(int php){
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
