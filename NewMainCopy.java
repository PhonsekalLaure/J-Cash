import java.util.Scanner;

public class NewMainCopy {
    private static final int adminPin = 1234;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0, choice3 = 0;
        String finalans = "", accNo;
        boolean found;
        Accounts acc[] = new Accounts[5];//array of accounts with a maximum of 5 accounts

        do{
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
                                System.out.println("1. Create Account\n2. Delete Account\n3.View Accounts\n4. Exit\n");
                                System.out.print("Enter choice: ");
                                choice2 = input.nextInt();

                                switch(choice2){
                                    case 1://creates an account
                                        if(count == 5){
                                            System.out.println("Maximum number of accounts reached.");
                                            System.out.print("Press Enter to Continue...");
                                            input.nextLine();//waits for the user to press enter
                                            break;
                                        }
                                        else{
                                            System.out.println("1. Savings\n2. Current\n3. Go Back");
                                            System.out.print("Enter account type: ");
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

                                    case 2://deletes an account

                                    case 3://display all accounts

                                    case 4://exits the admin menu
                                        break;
                                }
                                        
                            }while(choice2 != 4);
                        }
                        else{
                            System.out.println("All attempts used. Going back to main menu.");
                            input.nextLine();
                            System.out.print("\nPress Enter to Continue...");
                            input.nextLine();
                            break;
                        }
                    }
                    else{
                        found = false;
                        for(int i = 0; i < count; i++){
                            if(Integer.parseInt(accNo) == acc[i].getAccountNo()){
                                found = true;

                                System.out.println("Enter Pin \t: ");
                                if(acc[i].verify(input.nextInt())){
                                    clearScreen();
                                    JCASH();
                                    System.out.println("Welcome " + acc[i].getName() + "!");
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
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                            break;

                                        case 6:
                                            break;
                                    }
                                }

                            }
                        }
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
        int attempts = 0, pin = 0;       // Number of attempts
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
}
