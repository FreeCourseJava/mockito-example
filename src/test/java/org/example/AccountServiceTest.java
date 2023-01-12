package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountServiceTest {
    
    private AccountService accountService;
    
    private CurrencyService currencyService;
    
    @BeforeEach
    public void setUp() {
        currencyService = mock(CurrencyService.class);
        accountService = new AccountService(currencyService);
    }

    @Test
    void sendMoneyBad() {
        when(currencyService.convertTo(anyString(), anyDouble())).thenReturn(500d);

        assertThrows(RuntimeException.class, () -> accountService.sendMoney());
    }

    @Test
    void sendMoneyOk() {
        when(currencyService.convertTo(anyString(), anyDouble())).thenReturn(50d);

        accountService.sendMoney();

    }
}