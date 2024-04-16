/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.exchange.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class CurrencyResponse {
    private Map<String,Double> conversion_rates;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    // Método para obtener solo los nombres de las monedas
    public Set<String> getCurrencyNames() {
        return conversion_rates.keySet();
    }
}
