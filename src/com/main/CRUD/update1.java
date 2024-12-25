package com.main.CRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class update1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		        String[] choices = {"A", "B", "C", "D"};
		        int totalChoices = choices.length;
		        
		        System.out.println("Available choices are: ");
		        for (String choice : choices) {
		            System.out.print(choice + " ");
		        }
		        System.out.println("\n\nEnter your choices separated by space (e.g., A B):");

		        // Read user input
		        String input = scanner.nextLine();
		        String[] selectedChoices = input.trim().split("\\s+");

		        // Check validity of input
		        if (selectedChoices.length == 1 || selectedChoices.length == 2 || selectedChoices.length == 3 || selectedChoices.length == totalChoices) {
		            // Validate that input contains valid choices
		            boolean isValid = true;
		            for (String selected : selectedChoices) {
		                boolean found = false;
		                for (String choice : choices) {
		                    if (selected.equalsIgnoreCase(choice)) {
		                        found = true;
		                        break;
		                    }
		                }
		                if (!found) {
		                    isValid = false;
		                    break;
		                }
		            }

		            if (isValid) {
		                System.out.println("Input accepted: " + String.join(", ", selectedChoices));
		            } else {
		                System.out.println("Invalid choices entered. Please enter valid choices.");
		            }
		        } else {
		            System.out.println("Input rejected. Please select exactly one choice or all choices.");
		        }
		        
		        scanner.close();
		    
		
	}

}
