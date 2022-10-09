package com.crystal.atm.controller;

import com.crystal.atm.dao.DataAccess;
import com.crystal.atm.model.Account;
import com.crystal.atm.service.AccountService;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AtmMenu {
    private Scanner sc = new Scanner(System.in);
    private DataAccess dataAccess;
    private AccountService accountService;

    public AtmMenu(DataAccess dataAccess, AccountService accountService) throws IOException {
        this.dataAccess = dataAccess;
        this.accountService = accountService;
        logInUserMenu();
    }

    public void logInUserMenu() throws IOException {
        //1-get user's card number

        System.out.println("Please enter your card number: ");
        String cardNumber = sc.nextLine();

        if (accountService.isActiveCard(cardNumber)) {
            //3-enter pin
            System.out.println("Please put your PIN: ");
            String pin = sc.nextLine();
            if (accountService.isActiveCardPin(cardNumber, pin)) {
                Account loggedInAccount = accountService.getAccountByCardNr(cardNumber);
                showOperationMenu(loggedInAccount);
            } else {
                System.out.println("Invalid PIN.Try again!");
                logInUserMenu();
            }
        } else {
            System.out.println("Card number is not valid.Try again!");
            logInUserMenu();
        }


    }

    public void showOperationMenu(Account account) throws IOException {
        System.out.println("Hello userNr : " + account.getUserId() +
                "  Please select an option: \n ");

        System.out.println("1 - View Balance");
        System.out.println("2 - Deposit Funds");
        System.out.println("3 - Withdraw Funds");
        System.out.println("4 - Transfer between your  accounts");
        System.out.println("5 - Transfer to another User");
        System.out.println("0 - EXIT");
        int chose = sc.nextInt();
        handleAnswer(chose, account);
    }

    public void handleAnswer(int input, Account account) throws IOException {
        long amount;
        switch (input) {
            case 1:
                displayAccountInfo(account);
                goBack(account);
                break;
            case 2:
                System.out.println("Enter amount to deposit: ");
                amount = sc.nextLong();
                if (!accountService.deposit(account, amount)) {
                    System.out.println("Deposit failed !");
                    showOperationMenu(account);
                    break;
                }
                goBack(account);
                break;
            case 3:
                //Withdraw
                System.out.println("Enter amount to withdraw: ");
                amount = sc.nextLong();
                accountService.withdraw(account, amount);
                if (!accountService.withdraw(account, amount)) {
                    showOperationMenu(account);
                }
                goBack(account);
                break;
            case 4:
            case 5:
                transferFoundsInfo(account);
                goBack(account);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Enter a valid number");
                showOperationMenu(account);
                break;
        }

    }

    private void goBack(Account account) throws IOException {

        System.out.println("Do you want do another operation? Y/N y/n");
        String answer = sc.next();
        if (answer.toLowerCase().equals("y")) {
            showOperationMenu(account);
        } else {
            System.exit(0);
        }
    }

    public void transferFoundsInfo(Account account) throws IOException {
        System.out.println("Enter the amount you want to transfer:");
        long amount = sc.nextLong();
        System.out.println("Enter the account number where you want to transfer :");
        String accountNumber = sc.next();
        if (accountService.transferFounds(account, accountNumber, amount)) {
            System.out.println("Transfer done");
        } else System.out.println("Transfer failed");
        goBack(account);
    }

    public void displayAccountInfo(Account account) throws IOException {
        System.out.println(
                "User ID: " + account.getUserId()
                        + "\n User Name ; " + dataAccess.getUsers().stream().filter(user -> Objects.equals(user.getId(), account.getUserId())).collect(Collectors.toList()).get(0).getFirstName()
                        + "\n Balance : " + account.getBalance()
        );
    }

}
