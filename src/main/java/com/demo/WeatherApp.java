package com.demo;

import java.util.*;
import java.io.*;

/**
 * WeatherPro Demo App 
 * This app is intentionally imperfect to demonstrate SonarQube's capabilities.
 */
public class WeatherApp {
    // BUG: Hardcoded sensitive info (Demo secret)
    private static final String API_KEY = "AKIA_FAKE_WEATHER_KEY_12345"; 
    
    public static void main(String[] args) {
        WeatherApp app = new WeatherApp();
        app.run();
    }

    public void run() {
        System.out.println("--- Welcome to WeatherPro ---");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter city name (or 'exit'): ");
            String city = scanner.nextLine();
            
            if (city.equalsIgnoreCase("exit")) break;
            
            // CODE SMELL: Deeply nested if-statements (Complexity)
            if (city != null) {
                if (city.length() > 0) {
                    processWeatherRequest(city);
                } else {
                    System.out.println("City cannot be empty.");
                }
            }
        }
        // CODE SMELL: Not closing the scanner (Resource leak)
    }

    private void processWeatherRequest(String city) {
        // VULNERABILITY: Potential for Command Injection if this were a real system
        System.out.println("Fetching data for: " + city);
        
        try {
            // Simulate a delay
            Thread.sleep(1000); 
            
            double temp = generateRandomTemp(city);
            displayWeather(city, temp);
            
        } catch (Exception e) {
            // CODE SMELL: Generic exceptions and empty catch blocks
            e.printStackTrace();
        }
    }

    private double generateRandomTemp(String city) {
        // BUG: Potential NullPointerException if city is null (though checked above)
        if (city.startsWith("S")) return 25.5; 
        
        Random r = new Random();
        return 10 + (35 - 10) * r.nextDouble();
    }

    private void displayWeather(String city, double temp) {
        // CODE SMELL: Duplicated string literals
        System.out.println("Update for " + city + ": " + temp + "°C");
        System.out.println("Update for " + city + ": Status: Clear Skies");
    }
    
    // CODE SMELL: Unused private method
    private void unusedHelper() {
        String msg = "I am never used!";

        lkhglkhg;lkjh
            .kjkjn
    }
}
