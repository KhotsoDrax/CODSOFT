package org.CurrencyConverter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.math.BigDecimal;
import java.util.Scanner;

public class CurrencyConverter {

    static String API_KEY = "38c23884ff23455039726d26";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exchange rates (as of the current date)

        System.out.println("Enter the amount to convert: ");
        double zarAmount = scanner.nextDouble();

        System.out.println("Enter the base code for the currency conversion (e.g., USD, EUR, JPY, RUB, MUR, JMD, NAD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.println("Enter the target code for the currency conversion (e.g., USD, EUR, JPY, RUB, MUR, JMD, NAD): ");
        String targetCurrency = scanner.next().toUpperCase();

        BigDecimal exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = zarAmount * exchangeRate.doubleValue();
        String currencySymbol = getCurrencySymbol(targetCurrency);


        System.out.println(zarAmount +" "+baseCurrency + " is approximately " + convertedAmount + " " + targetCurrency);
        scanner.close();
    }

    public static BigDecimal fetchExchangeRate(String baseCurrency, String targetCurrency) {
        String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency;
        HttpResponse<JsonNode> response = Unirest.get(apiUrl)
                .header("Accept", "application/json")
                .queryString("apikey", API_KEY)
                .asJson();

        JsonObject rates = JsonParser.parseString(response.getBody().toString()).getAsJsonObject().getAsJsonObject("rates");
        BigDecimal exchangeRate = rates.getAsJsonPrimitive(targetCurrency).getAsBigDecimal();

        System.out.println("Exchange Rate: 1 " + baseCurrency + " = " + exchangeRate + " " + targetCurrency);

        return exchangeRate;
    }

    public static String getCurrencySymbol(String currencyCode) {
        // You can expand this method to include more currency symbols
        switch (currencyCode) {
            case "USD":
                return "$";
            case "EUR":
                return "€";
            case "JPY":
                return "¥";
            case "ZAR":
                return "R";
            default:
                return currencyCode; // Return code if symbol is not found
        }
    }
}
