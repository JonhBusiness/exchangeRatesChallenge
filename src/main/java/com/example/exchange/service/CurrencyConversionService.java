/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.example.exchange.service;

import com.example.exchange.model.CurrencyConversionResponse;
import com.example.exchange.model.CurrencyResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 *   //https://v6.exchangerate-api.com/v6/05999cd3c5e5696ed0ecc641/latest/USD
 */
@Service
public class CurrencyConversionService {

  //  private final String apiKey = "05999cd3c5e5696ed0ecc641";
  
    @Autowired
    private RestTemplate restTemplate;

    public CurrencyResponse getAllCurrencies() {
        String url = "https://v6.exchangerate-api.com/v6/05999cd3c5e5696ed0ecc641/latest/USD";
        return restTemplate.getForObject(url, CurrencyResponse.class);
    }
    
      public CurrencyConversionResponse convertCurrency(String fromCurrency, String toCurrency, double amount) {
        String url = "https://v6.exchangerate-api.com/v6/05999cd3c5e5696ed0ecc641/pair/" + fromCurrency + "/" + toCurrency + "/" + amount;
        return restTemplate.getForObject(url, CurrencyConversionResponse.class);
    }
}
