/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.darray;

/**
 *
 * @author Raphael Villareal
 */
public class TemperatureArray {
    public static void main(String[] args) {
        
        double[][] temperatures = {
            {25.8, 31.4, 28.3, 22.5, 30.1}, 
            {24.2, 29.8, 26.9, 23.1, 31.8}, 
            {26.5, 30.6, 27.4, 21.8, 29.3}, 
            {27.9, 32.1, 29.5, 24.4, 31.2}, 
            {23.9, 29.2, 26.3, 22.9, 30.5}, 
            {25.4, 31.9, 28.8, 23.6, 32.0}, 
            {24.8, 30.3, 27.1, 21.4, 29.9}  
        };

       
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        
        System.out.println("Temperature Data for the Week:");
        System.out.printf("%-12s%-10s%-10s%-10s%-10s%-10s%n", "Day", "City 1", "City 2", "City 3", "City 4", "City 5");
        
        for (int i = 0; i < 7; i++) {
            System.out.printf("%-12s", days[i]); 
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-10.1f", temperatures[i][j]); 
            }
            System.out.println();
        }

       
        averageTemperaturePerCity(temperatures);

        
        hottestDay(temperatures, days);

       
        coldestDay(temperatures, days);
    }

   
    public static void averageTemperaturePerCity(double[][] temperatures) {
        System.out.println("\nAverage Temperature per City:");
        
        for (int j = 0; j < 5; j++) {  
            double sum = 0;
            for (int i = 0; i < 7; i++) {  
                sum += temperatures[i][j];
            }
            double average = sum / 7;
            System.out.println("City " + (j + 1) + ": " + String.format("%.1f", average)); 
        }
    }

    // Method to find and display the hottest day
    public static void hottestDay(double[][] temperatures, String[] days) {
        double highest = -Double.MAX_VALUE;
        int hottestDayIndex = -1;
        int hottestCityIndex = -1;

        for (int i = 0; i < 7; i++) {  
            for (int j = 0; j < 5; j++) {  
                if (temperatures[i][j] > highest) {
                    highest = temperatures[i][j];
                    hottestDayIndex = i;
                    hottestCityIndex = j;
                }
            }
        }
        System.out.println("\nHottest Day of the Week:");
        System.out.println("Day: " + days[hottestDayIndex] + " | City " + (hottestCityIndex + 1) + " | Temperature: " + String.format("%.1f", highest));
    }

    
    public static void coldestDay(double[][] temperatures, String[] days) {
        double lowest = Double.MAX_VALUE;
        int coldestDayIndex = -1;
        int coldestCityIndex = -1;

        for (int i = 0; i < 7; i++) { 
            for (int j = 0; j < 5; j++) {  
                if (temperatures[i][j] < lowest) {
                    lowest = temperatures[i][j];
                    coldestDayIndex = i;
                    coldestCityIndex = j;
                }
            }
        }
        System.out.println("\nColdest Day of the Week:");
        System.out.println("Day: " + days[coldestDayIndex] + " | City " + (coldestCityIndex + 1) + " | Temperature: " + String.format("%.1f", lowest));
    }
}

