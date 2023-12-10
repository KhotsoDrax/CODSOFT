package org.CurrencyConverter;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exchange rates (as of the current date)
        double usdToZarRate = 15.25;   // Example exchange rate: 1 USD = 15.25 ZAR
        double eurToZarRate = 17.80;   // Example exchange rate: 1 EUR = 17.80 ZAR
        double jpyToZarRate = 0.14;    // Example exchange rate: 1 JPY = 0.14 ZAR
        double rubToZarRate = 0.21;    // Example exchange rate: 1 RUB = 0.21 ZAR
        double murToZarRate = 3.75;    // Example exchange rate: 1 MUR = 3.75 ZAR
        double jmdToZarRate = 0.12;    // Example exchange rate: 1 JMD = 0.12 ZAR
        double nadToZarRate = 1.00;    // Example exchange rate: 1 NAD = 1.00 ZAR

        System.out.println("Enter the amount in ZAR to convert: ");
        double zarAmount = scanner.nextDouble();

        System.out.println("Enter the country code for the currency conversion (e.g., USD, EUR, JPY, RUB, MUR, JMD, NAD): ");
        String countryCode = scanner.next().toUpperCase();

        double convertedAmount = 0.0;
        String currencySymbol = "";

        switch (countryCode) {
            case "USD":
                convertedAmount = Math.round(zarAmount / usdToZarRate / 100) * 100;
                currencySymbol = "$";
                break;
            case "EUR":
                convertedAmount = Math.round(zarAmount / eurToZarRate / 100) * 100;
                currencySymbol = "€";
                break;
            case "JPY":
                convertedAmount = Math.round(zarAmount / jpyToZarRate / 100) * 100;
                currencySymbol = "¥";
                break;
            case "RUB":
                convertedAmount = Math.round(zarAmount / rubToZarRate / 100) * 100;
                currencySymbol = "₽";
                break;
            case "MUR":
                convertedAmount = Math.round(zarAmount / murToZarRate / 100) * 100;
                currencySymbol = "₨";
                break;
            case "JMD":
                convertedAmount = Math.round(zarAmount / jmdToZarRate / 100) * 100;
                currencySymbol = "J$";
                break;
            case "NAD":
                convertedAmount = Math.round(zarAmount / nadToZarRate / 100) * 100;
                currencySymbol = "N$";
                break;
            default:
                System.out.println("Invalid country code. Please enter a valid code from the specified list.");
                scanner.close();
                return;
        }

        System.out.println(zarAmount + " ZAR is approximately " + currencySymbol + " " + convertedAmount + " " + countryCode);

        scanner.close();
    }
}
