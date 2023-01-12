package org.example;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService(new CurrencyService());
        //accountService.sendMoney();
    }
}