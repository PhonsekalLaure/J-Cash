import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Hmain {
    private static final int adminPin = 1234;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0, choice3 = 0;
        String finalans = "", accNo;
        boolean found;
        Accounts acc[] = new Accounts[5]; // array of accounts with a maximum of 5 accounts
        count = loadAccounts(acc);
    
        do {
            clearScreen();
            JCASH();
            System.out.println("1. Login\n2. Exit\n"); // Main menu, login as an admin first to create accounts
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();
    
            switch (choice) {
                case 1:
                    clearScreen();
                    JCASH();
                    System.out.println("LOGIN");
                    System.out.print("Enter account number\t: "); // to login as an admin, enter "admin"
                    accNo = input.nextLine();
    
                    if (Login(accNo)) {
                        System.out.print("Enter Admin Pin \t: "); // Admin pin is 1234 with 3 attempts, it can be changed above
                        if (adminAuth(input)) {
                            do {
                                clearScreen();
                                JCASH();
                                System.out.println("ADMIN MENU");
                                System.out.println("1. Create Account\n2. Delete Account\n3. View Accounts\n4. Exit\n");
                                System.out.print("Enter choice: ");
                                choice2 = input.nextInt();
    
                                switch (choice2) {
                                    case 1: // creates an account
                                        if (count == 5) {
                                            clearScreen();
                                            JCASH();
                                            System.out.println("Maximum number of accounts reached.");
                                            input.nextLine();
                                            System.out.print("Press Enter to Continue...");
                                            input.nextLine(); // waits for the user to press enter
                                            break;
                                        } else {
                                            clearScreen();
                                            JCASH();
                                            System.out.println("ACCOUNT CREATION");
                                            System.out.println("1. Savings\n2. Current\n3. Go Back");
                                            System.out.print("\nEnter choice: ");
                                            choice3 = input.nextInt();
    
                                            switch (choice3) {
                                                case 1:
                                                    clearScreen();
                                                    JCASH();
                                                    acc[count] = new Savings();
                                                    createAccount(acc[count], input);
                                                    count++;
                                                    saveAccounts(acc, count);
                                                    break;
    
                                                case 2:
                                                    clearScreen();
                                                    JCASH();
                                                    acc[count] = new Current();
                                                    createAccount(acc[count], input);
                                                    count++;
                                                    saveAccounts(acc, count);
                                                    break;
    
                                                case 3:
                                                    break;
    
                                                default:
                                                    System.out.println("Invalid choice.");
                                                    System.out.print("\nPress Enter to Continue...");
                                                    input.nextLine();
                                            }
                                            if (choice3 < 3) { // if the user chose to create an account
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
    
                                    case 2: // deletes an account
                                        clearScreen();
                                        JCASH();
                                        input.nextLine();
                                        System.out.print("Enter account number to delete: ");
                                        accNo = input.nextLine();
    
                                        found = false;
                                        for (int i = 0; i < count; i++) {
                                            if (AccountLogin(accNo)) {
                                                found = true;
                                                if (confirmation(acc[i].getAccountNo(), input)) {
                                                    DeleteAccount(accNo);
                                                } else {
                                                    System.out.println("Account not deleted.");
                                                    System.out.print("\nPress Enter to Continue...");
                                                    input.nextLine();
                                                }
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("Account not found.");
                                            System.out.print("\nPress Enter to Continue...");
                                            input.nextLine();
                                        }
                                        break;
    
                                    case 3: // display all accounts
                                        clearScreen();
                                        JCASH();
                                        if (count == 0) { // checks if there are accounts to display
                                            System.out.println("No accounts to display.\n");
                                        } else { // if there are accounts
                                            System.out.println("DISPLAY USERS");
                                            Display(); // calls the Display method
                                        }
                                        input.nextLine();
                                        System.out.print("Press Enter to Continue...");
                                        input.nextLine();
                                        break;
    
                                    case 4: // exits the admin menu
                                        break;
                                }
    
                            } while (choice2 != 4);
                        } else {
                            System.out.println("\nAll attempts used. Going back to main menu.");
                            input.nextLine();
                            System.out.print("Press Enter to Continue...");
                            input.nextLine();
                            break;
                        }
                    }
                        else if (AccountLogin(accNo)) {
                            found = true;
                            System.out.print("Enter Pin \t\t: ");
                            int pin = input.nextInt();
                            input.nextLine(); // consume the newline character
        
                            if (PinLogin(pin, input)) {
                                for (int i = 0; i < count; i++) {
                                        do {
                                            clearScreen();
                                            JCASH();
                                            System.out.println("Welcome " + acc[i].getName().toUpperCase() + "!");
                                            System.out.println("1. Deposit\n2. Withdraw\n3. View Balance\n4. Currency Converter\n5. Account Details\n6. Exit\n");
                                            System.out.print("Enter choice: ");
                                            choice2 = input.nextInt();
                                            clearScreen();
        
                                            switch (choice2) {
                                                case 1:
                                                    clearScreen();
                                                    JCASH();
                                                    System.out.println("DEPOSIT");
                                                    System.out.println("Account Number \t\t: " + acc[i].getAccountNo());
                                                    System.out.print("Enter Deposit Amount \t: PHP ");
                                                    acc[i].deposit(input.nextInt()); // calls the deposit method
                                                    input.nextLine();
                                                    saveAccounts(acc, count);
                                                    System.out.print("\nPress Enter to Continue...");
                                                    input.nextLine();
                                                    break;
                                                case 2:
                                                    clearScreen();
                                                    JCASH();
                                                    System.out.println("WITHDRAW");
                                                    System.out.println("Account Number \t\t: " + acc[i].getAccountNo());
                                                    System.out.print("Enter Withdrawal Amount : PHP ");
                                                    if (acc[i].withdraw(input.nextInt())) {
                                                        saveAccounts(acc, count);
                                                        System.out.println("Withdrawal successful!");
                                                        System.out.printf("Withdrawal successful! \nNew balance \t\t: PHP%, .2f%n", (double) acc[i].getBalance());
                                                    } else {
                                                        System.out.println("Withdrawal failed.");
                                                    }
                                                    input.nextLine();
                                                    System.out.print("\nPress Enter to Continue...");
                                                    input.nextLine();
                                                    break;
                                                case 3:
                                                    clearScreen();
                                                    JCASH();
                                                    acc[i].viewBalance(); // calls the viewBalance method
                                                    System.out.print("\nPress Enter to Continue...");
                                                    input.nextLine();
                                                    input.nextLine();
                                                    break;
                                                case 4:
                                                    clearScreen();
                                                    JCASH();
                                                    currencyConvert(acc[i].getBalance()); // calls the currencyConvert method
                                                    System.out.print("\nPress Enter to Continue...");
                                                    input.nextLine();
                                                    input.nextLine();
                                                    break;
                                                case 5: // displays the account details
                                                    clearScreen();
                                                    JCASH();
                                                    System.out.println("ACCOUNT DETAILS");
                                                    AccountDetails(accNo);// calls the getDetails method
                                                    System.out.print("Press Enter to Continue...");
                                                    input.nextLine();
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
                                        break;
                                }
                            }
                        
                        else {
                            System.out.println("\nAll attempts used. Going back to main menu.");
                            System.out.print("Press Enter to Continue...");
                            input.nextLine();
                            break;
                                }
                            
                        
                    } else {
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
        } while (!finalans.equalsIgnoreCase("Y"));
    
        input.close();
        clearScreen();
        JCASH();
        authors();
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
        Random random = new Random();
        account.setAccountNo(random.nextInt(900) + 100);
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
    public static void AccountDetails(String accNo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[1].equals(accNo)) {
                    System.out.println("Account Number\t: " + details[1]);
                    System.out.println("Account Type\t: " + details[0]);
                    System.out.println("Name\t\t: " + details[2]);
                    System.out.println("Address\t\t: " + details[3]);
                    System.out.println("Age\t\t: " + (2024 - Integer.parseInt(details[4])));
                    System.out.println();
                    break; // Exit the loop once the account is found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Display(){//displays the accounts
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                System.out.println("\nAccount Number: " + details[1]);
                System.out.println("Account Type: " + details[0]);
            }
        } catch (IOException e) {
            
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
    public static void saveAccounts(Accounts[] acc, int count) {
        try (FileWriter writer = new FileWriter("accounts.txt")) {
            for (int i = 0; i < count; i++) {
                writer.write(acc[i].getClass().getSimpleName() + "," + acc[i].getAccountNo() + "," + acc[i].getName() + "," + acc[i].getAddress() + "," + acc[i].getAge() + "," + acc[i].getBalance() + "," + acc[i].getPin() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving accounts.");
            e.printStackTrace();
        }
    }

    public static int loadAccounts(Accounts[] acc) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[0].equals("Savings")) {
                    acc[count] = new Savings();
                } else if (details[0].equals("Current")) {
                    acc[count] = new Current();
                }
                acc[count].setAccountNo(Integer.parseInt(details[1])); // Directly assign the account number
                acc[count].setName(details[2]);
                acc[count].setAddress(details[3]);
                acc[count].setYoB(2024 - Integer.parseInt(details[4])); // Assuming the current year is 2024
                acc[count].setBalance(Integer.parseInt(details[5]));
                acc[count].setPin(Integer.parseInt(details[6])); // Default pin
                count++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading accounts.");
            e.printStackTrace();
        }
        return count;
    }
    public static boolean AccountLogin(String accNo) {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details[1].equals(accNo)) {
                    return true;
                }
            }
        } catch (IOException e) {
            
        }
        return false;
    }
    public static boolean PinLogin(int pin, Scanner input) {
    int attempts = 0;
    while (attempts < 3) {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[6]) == pin) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        attempts++;
        if (attempts < 3) {
            System.out.println("Incorrect PIN. Please try again.");
            System.out.print("Enter Pin \t\t: ");
            pin = input.nextInt();
            input.nextLine(); // consume the newline character
        }
    }
    return false;
}
    public static boolean DeleteAccount(String accNo) {
    boolean accountDeleted = false;
    File inputFile = new File("accounts.txt");
    File tempFile = new File("accounts_temp.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            if (!details[1].equals(accNo)) {
                writer.write(line);
                writer.newLine();
            } else {
                accountDeleted = true;
            }
        }
    } catch (IOException e) {
        System.out.println("An error occurred while deleting the account.");
        e.printStackTrace();
    }

    // Replace the original file with the updated file
    if (accountDeleted) {
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
            return false;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
            return false;
        }
    } else {
        tempFile.delete();
    }

    return accountDeleted;
}
    
    public static boolean Login(String accNo) {
        return accNo.equalsIgnoreCase("admin");
    }
}
