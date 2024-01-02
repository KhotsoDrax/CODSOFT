package org.CurrencyConverter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CurrencyConverterGUI {

    private static String API_KEY = "38c23884ff23455039726d26";

    private static final String[] CURRENCY_EXAMPLES = {"USD", "EUR", "JPY", "ZAR", "GBP", "AUD", "CAD", "INR", "CNY"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JTextField amountField = new JTextField();
        JComboBox<String> baseCurrencyComboBox = new JComboBox<>(CURRENCY_EXAMPLES);
        JComboBox<String> targetCurrencyComboBox = new JComboBox<>(CURRENCY_EXAMPLES);
        JLabel resultLabel = new JLabel();

        JButton convertButton = new JButton("Convert");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double zarAmount = Double.parseDouble(amountField.getText());
                String baseCurrency = baseCurrencyComboBox.getSelectedItem().toString().toUpperCase();
                String targetCurrency = targetCurrencyComboBox.getSelectedItem().toString().toUpperCase();

                BigDecimal exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
                double convertedAmount = zarAmount * exchangeRate.doubleValue();
                convertedAmount = roundToNearest100(convertedAmount); // Round off to the nearest 100
                String currencySymbol = getCurrencySymbol(targetCurrency);

                resultLabel.setText(zarAmount + " " + baseCurrency + " is approximately " + convertedAmount + " " + targetCurrency + " " + currencySymbol);
            }
        });

        panel.add(new JLabel("Amount to convert: "));
        panel.add(amountField);
        panel.add(new JLabel("Base currency code: "));
        panel.add(baseCurrencyComboBox);
        panel.add(new JLabel("Target currency code: "));
        panel.add(targetCurrencyComboBox);
        panel.add(new JLabel("Result: "));
        panel.add(resultLabel);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, convertButton);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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

    public static double roundToNearest100(double amount) {
        return Math.round(amount / 100) * 100;
    }
}
