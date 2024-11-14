import java.util.Scanner;
import java.util.jar.Attributes;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0;
        String finalans = " ";
        accounts acc[] = new accounts[5];


        do { 
            JCASH();
            Menu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.println();
                    JCASH();
                    System.out.println("ACCOUNT CREATION");
                    System.out.println("Choose Account Type: ");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    System.out.print("Enter choice: ");
                    choice2 = input.nextInt();
                    input.nextLine();

                    switch(choice2){
                        case 1:
                            System.out.println();
                            JCASH();
                            acc[count] = new Savings();
                            acc[count].setAccountNo();
                            System.out.println("Account Number: \t" + acc[count].getAccountNo());
                            System.out.print("Enter Name: \t\t");
                            acc[count].setName(input.nextLine());
                            System.out.print("Set Pin: \t\t");
                            acc[count].setPin(input.nextInt());
                            System.out.print("Enter Year of Birth: \t");
                            acc[count].setYoB(input.nextInt());
                            System.out.print("Enter Initial Deposit: \t");
                            acc[count].setInitialDepo(input.nextInt());
                            count++;
                            break;

                        case 2:
                            System.out.println();
                            JCASH();
                            acc[count] = new Current();
                            acc[count].setAccountNo();
                            System.out.println("Account Number: \t" + acc[count].getAccountNo());
                            System.out.print("Enter Name: \t\t");
                            acc[count].setName(input.nextLine());
                            System.out.print("Set Pin: \t\t");
                            acc[count].setPin(input.nextInt());
                            System.out.print("Enter Year of Birth: \t");
                            acc[count].setYoB(input.nextInt());
                            System.out.print("Enter Initial Deposit: \t");
                            acc[count].setInitialDepo(input.nextInt());
                            count++;
                            break;

                        default:
                            System.out.println("Invalid choice.");
                    }
                    System.out.println("Account Created!\n");
                    break;

                //case 2:
                //case 3:
                //case 4:
                case 5:
                    JCASH();
                    System.out.print("Are You Sure You Want To Exit? Y|N: ");
                    finalans = input.next();
            }
        } while (finalans != "Y" || finalans != "y");
        System.out.println("Have a Nice Day Nigger!");
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
}
