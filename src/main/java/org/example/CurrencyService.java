package org.example;

import java.util.Map;

public class CurrencyService {
    
    private static final Map<String, Double> rates = Map.of("RUB", 70d, "USD", 1d);
    public double convertTo(String currency, double sum) {
        // get currency from db or bank 
        return rates.get(currency) * sum;
    }
    
}
