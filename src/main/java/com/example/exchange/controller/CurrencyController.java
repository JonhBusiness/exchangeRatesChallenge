/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.exchange.controller;

import com.example.exchange.model.CurrencyConversionResponse;
import com.example.exchange.model.CurrencyResponse;
import com.example.exchange.service.CurrencyConversionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PC
 */
@Controller
public class CurrencyController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @GetMapping("/exchange")
    public String showCurrencyConverter(Model model) {

        CurrencyResponse currencies = currencyConversionService.getAllCurrencies();
       // System.out.println("Lista:"+currencies.getConversion_rates());
       // System.out.println("Lista:"+currencies.getCurrencyNames());
        model.addAttribute("currencies", currencies.getCurrencyNames());
        return "converterBootstrap";
    }
    @PostMapping("/convert")
    public String convertCurrency(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam double amount, Model model) {
        CurrencyConversionResponse response = currencyConversionService.convertCurrency(fromCurrency, toCurrency, amount);
        model.addAttribute("result", response.getConversion_result());
        CurrencyResponse currencies = currencyConversionService.getAllCurrencies();
        model.addAttribute("currencies", currencies.getCurrencyNames());
        return "converterBootstrap";
    }
    @GetMapping("/exchange2")
    public String showCurrencyConverter2(Model model) {

        //  CurrencyResponse currencies = currencyConversionService.getAllCurrencies();
        // System.out.println("Lista:"+currencies.getConversion_rates());
        // System.out.println("Lista:"+currencies.getCurrencyNames());
        // model.addAttribute("currencies", currencies.getCurrencyNames());
        return "converterTailwind";
    }
 @PostMapping("/convert2")
    public String convertCurrency2(@RequestParam String fromCurrency, @RequestParam String toCurrency, @RequestParam double amount, Model model) {
        CurrencyConversionResponse response = currencyConversionService.convertCurrency(fromCurrency, toCurrency, amount);
        model.addAttribute("result", response.getConversion_result());
     CurrencyResponse currencies = currencyConversionService.getAllCurrencies();
     model.addAttribute("currencies", currencies.getCurrencyNames());
        return "currencyConverter";
    }
}
