package bankpackage;

import java.util.Scanner;

/**
 * Created by yst865 on 4/6/17.
 */
public class Application {

    public static void main(String[] args) {

        Dao dao = new Dao();
        Customer c1 = dao.read();


        Scanner scan = new Scanner(System.in);

        int selection = 1;

        while (selection != 6) {
            System.out.println("Please enter what you want: \n" +
                    "1) Name \n" +
                    "2) Account Number \n" +
                    "3) Balance \n" +
                    "4) Deposit Money \n" +
                    "5) Withdraw Money \n" +
                    "6) Exit\n");
            selection = scan.nextInt();
            if (selection < 1 || selection > 6) {
                System.out.println("Please enter a valid number (1-6): ");
                selection = scan.nextInt();
            }

            switch (selection) {
                case 1:
                    if (c1.getName() == null) {
                        System.out.println("Please enter your name:");
                        scan.nextLine();
                        c1.setName(scan.nextLine());
                        System.out.println("Thank you " + c1.getName()+ "\n");
                    }
                    else {
                        System.out.println("We already have your name " + c1.getName()+ "\n");
                    }
                    break;
                case 2:
                    if (c1.getAccount() == null) {
                        System.out.println("Please enter your account:");
                        scan.nextLine();
                        c1.setAccount(scan.nextLine());
                        System.out.println("Your account number is: " + c1.getAccount() + "\n");
                    }
                    else {
                        System.out.println("We already have your account " + c1.getAccount() +"\n");
                    }
                    break;
                case 3:
                    if (c1.getBalance() == 0) {
                        System.out.println("Please enter your balance: ");
                        c1.setBalance(scan.nextDouble());
                        System.out.println("Your current balance is: "+ c1.getBalance()+"\n");
                    }
                    else {
                        System.out.println("Your current balance is: "+ c1.getBalance());
                    }
                    break;
                case 4:

                    double deposit;
                    System.out.println("How much do you want to deposit? \n");
                    deposit = (scan.nextDouble());

                    while (deposit > 10000) {
                        System.out.println("The maximum deposit is 10,000! Please enter a number equal to or less than 10,000!");
                        deposit = (scan.nextDouble());
                    }

                    c1.changeBalanceD(deposit);
                    System.out.println("Your new balance is: " + c1.getBalance());
                    break;

                case 5:

                    double withdraw;
                    System.out.println("How much do you want to withdraw? \n");
                    withdraw = (scan.nextDouble());

                  if (withdraw>c1.getBalance()) {
                        System.out.println("You have insufficient funds!  Please enter a new amount!");
                        withdraw = (scan.nextDouble());
                    }
                    c1.changeBalanceW(withdraw);
                    System.out.println("Your new balance is: " + c1.getBalance());
                    break;

                case 6:
                    break;

            }

        }

        dao.write(c1);
    }
}
