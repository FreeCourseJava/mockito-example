package org.example;

public class AccountService {
    
    private final CurrencyService currencyService;


    public AccountService(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }
    
    public void sendMoney() {
        Account account1 = new Account("RUB", 100);
        Account account2 = new Account("USD", 500d);
        
        double sum = 200;
        
        account1.setBalance(account1.getBalance() - currencyService.convertTo(account2.getCurrency(), sum));
        account2.setBalance(account2.getBalance() + currencyService.convertTo(account1.getCurrency(), sum));
        
        if (account1.getBalance() < 0) {
            throw new RuntimeException("BAD BALANCE!");
        }
    }
}
