import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0;
        String finalans = "n";
        accounts acc[] = new accounts[5];


        do { 
            JCASH();
            Menu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    clearScreen();
                    JCASH();
                    if(count == 5){
                        System.out.println("Maximum number of accounts reached.\n");
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
                            acc[count].setAccountNo();
                            System.out.println("Account Number: \t" + acc[count].getAccountNo());
                            System.out.print("Enter Year of Birth: \t");
                            acc[count].setYoB(input.nextInt());
                            input.nextLine();
                            System.out.print("Enter Name: \t\t");
                            acc[count].setName(input.nextLine());
                            System.out.print("Initial Deposit (PHP): \t");
                            acc[count].setInitialDepo(input.nextInt());
                            System.out.print("Set Pin: \t\t");
                            acc[count].setPin(input.nextInt());
                            count++;
                            break;

                        case 2:
                            clearScreen();
                            JCASH();
                            acc[count] = new Savings();
                            acc[count].setAccountNo();
                            System.out.println("Account Number: \t" + acc[count].getAccountNo());
                            System.out.print("Enter Year of Birth: \t");
                            acc[count].setYoB(input.nextInt());
                            input.nextLine();
                            System.out.print("Enter Name: \t\t");
                            acc[count].setName(input.nextLine());
                            System.out.print("Initial Deposit (PHP): \t");
                            acc[count].setInitialDepo(input.nextInt());
                            System.out.print("Set Pin: \t\t");
                            acc[count].setPin(input.nextInt());
                            count++;
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                    if(choice2 == 3){
                        clearScreen();
                        break;
                    }
                    else{
                    clearScreen();
                    JCASH();
                    System.out.println("Account with Account Number " + acc[count-1].getAccountNo() + " Created!\n");
                    }
                }
                    break;
                    

                case 2:
                    clearScreen();
                    JCASH();
                    System.out.println("ACCOUNT SETTINGS");
                    System.out.print("Enter Account Number: \t");
                    int accNo = input.nextInt();

                    boolean found = false;
                    for(int i = 0; i < count; i++){
                        if(acc[i].getAccountNo() == accNo){
                            found = true;

                                System.out.print("Enter Pin: \t\t");
                                if(acc[i].verify(input.nextInt())){
                                    System.out.println("1. Balance Inquiry");
                                    System.out.println("2. Account Details");
                                    System.out.println("3. Delete Account");
                                    System.out.print("Enter choice: ");
                                    choice2 = input.nextInt();
                                    input.nextLine();

                                    switch(choice2){
                                        case 1:
                                            break;

                                        case 2:
                                            acc[i].getDetails();
                                            break;

                                        case 3:
                                            break;

                                        default:
                                            System.out.println("Invalid choice.");
                                    }
                                }
                                else{
                                    System.out.println("All attempts used. Going back to main menu.");
                                    break;
                                }
                        }
                        else if(!found){
                            System.out.println("Account not found.\n");
                        }
                    }
                    break;
                    
                case 3:
                    break;

                case 4:
                    clearScreen();
                    JCASH();
                    if(count == 0){
                        System.out.println("No accounts to display.\n");
                        break;
                    }
                    else{
                        System.out.println("DISPLAY USERS");
                        Display(acc, count);
                    }
                    System.out.println("Press Enter to Continue...");
                    input.nextLine();
                    break;

                case 5:
                    clearScreen();
                    JCASH();
                    input.nextLine();
                    System.out.print("Are You Sure You Want To Exit? Y|N: ");
                    finalans = input.nextLine();
            }
        } while (finalans == "N" || finalans == "n");
        System.out.println("Have a Nice Day Nigger!");
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

    public static void authors(){
        System.out.println("Thank you for using J-CASH Banking.");
        System.out.println("Marlo Veluz");
        System.out.println("Dominic Madlangbayan");
        System.out.println("Mark Gamboa");
        System.out.println("Ronn Rosarito");
    }

    public static void Display(accounts[] acc, int count){
        for(int i = 0; i < count; i++){
            System.out.println("Account Number: " + acc[i].getAccountNo());
            System.out.println();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
