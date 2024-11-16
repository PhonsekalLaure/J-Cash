import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0, accNo;
        String finalans = "";
        boolean found;
        accounts acc[] = new accounts[5];


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
                    System.out.print("Enter choice: ");
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
                        System.out.print("Enter Account Number: \t");
                        accNo = input.nextInt();

                        found = false;
                        for(int i = 0; i < count; i++){
                        if(acc[i].getAccountNo() == accNo){
                            found = true;

                                System.out.print("Enter Pin: \t\t");
                                if(acc[i].verify(input.nextInt())){
                                    clearScreen();
                                    JCASH();
                                    System.out.println("ACCOUNT SETTINGS");
                                    System.out.println("1. Balance Inquiry");
                                    System.out.println("2. Account Details");
                                    System.out.println("3. Currency Converter");
                                    System.out.println("4. Delete Account");
                                    System.out.println("5. Go Back");
                                    System.out.print("Enter choice: ");
                                    choice2 = input.nextInt();
                                    input.nextLine();

                                    switch(choice2){
                                        case 1:// Balance Inquiry
                                            clearScreen();
                                            JCASH();
                                            break;

                                        case 2://Account Details
                                            clearScreen();
                                            JCASH();
                                            acc[i].getDetails();
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 3://Currency Converter

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
                                    System.out.print("Press Enter to Continue...");
                                    input.nextLine();
                                    break;
                                }
                        }
                        else if(!found){
                            System.out.println("Account not found.\n");
                            input.nextLine();
                            System.out.print("Press Enter to Continue...");
                            input.nextLine();
                        }
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
                        System.out.print("Enter Account Number: \t");
                        accNo = input.nextInt();
                        found = false;

                    for (int i = 0; i < count; i++) {
                        if (acc[i].getAccountNo() == accNo) {
                            found = true;

                            System.out.print("Enter Pin: \t\t");
                            if (acc[i].verify(input.nextInt())) {
                                clearScreen();
                                JCASH();
                                System.out.println("TRANSACTIONS");
                                System.out.println("1. Deposit");
                                System.out.println("2. Withdraw");
                                System.out.println("3. Go Back");
                                System.out.print("Enter choice: ");
                                choice2 = input.nextInt();

                                switch (choice2) {
                                    case 1: // Deposit
                                        clearScreen();
                                        JCASH();
                                        System.out.println("DEPOSIT");
                                        System.out.print("Enter Deposit Amount: \t");
                                        acc[i].deposit(input.nextInt());
                                        System.out.println("Deposit successful! \nNew balance: PHP " + acc[i].getBalance());
                                        input.nextLine();
                                        System.out.print("Press Enter to Continue...");
                                        input.nextLine();
                                        break;

                                    case 2: // Withdraw
                                        clearScreen();
                                        JCASH();
                                        System.out.println("WITHDRAW");
                                        System.out.print("Enter Withdrawal Amount: \t");
                                        if(acc[i].withdraw(input.nextInt())){
                                            System.out.println("Withdrawal successful! \nNew balance: PHP " + acc[i].getBalance());
                                            input.nextLine();
                                            System.out.print("Press Enter to Continue...");
                                            input.nextLine();
                                        }
                                        else{
                                            System.out.println("Withdrawal failed.");
                                            input.nextLine();
                                            System.out.print("Press Enter to Continue...");
                                            input.nextLine();
                                        }
                                        break;

                                    case 3: // Go Back
                                        break;

                                    default:
                                        System.out.println("Invalid choice.");
                                        input.nextLine();
                                        System.out.print("Press Enter to Continue...");
                                        input.nextLine();
                                }
                            }
                            else {
                                System.out.println("All attempts used. Going back to main menu.");
                                input.nextLine();
                                System.out.print("Press Enter to Continue...");
                                input.nextLine();
                            }
                            break;
                        }
                        if (!found) {
                            System.out.println("Account not found.");
                            input.nextLine();
                            System.out.print("\nPress Enter to Continue...");
                            input.nextLine();
                        }
                        break;
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
        System.out.print("Enter choice: ");
    }

    public static void JCASH(){
        System.out.println("------------------------------");
        System.out.println("\tJ-CASH BANKING");
        System.out.println("------------------------------");
    }

    public static void createAccount(accounts account, Scanner input) {
        account.setAccountNo();
        System.out.println("Account Number: \t" + account.getAccountNo());
        System.out.print("Enter Year of Birth: \t");
        account.setYoB(input.nextInt());
        input.nextLine();
        System.out.print("Enter Name: \t\t");
        account.setName(input.nextLine());
        System.out.print("Enter Address: \t\t");
        account.setAddress(input.nextLine());
        System.out.print("Initial Deposit (PHP): \t");
        account.setInitialDepo(input.nextInt());
        System.out.print("Set Pin: \t\t");
        account.setPin(input.nextInt());
    }

    public static void Display(accounts[] acc, int count){
        for(int i = 0; i < count; i++){
            System.out.println("Account Number: " + acc[i].getAccountNo());
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
