package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.Suggestions;
import com.mycompany.anothercam.implementActions.ViewEditDelete;
import java.util.ArrayList;
import java.util.Scanner;

public class SuggestionStudentMenuOptions implements ViewEditDelete {
    private SuggestionList suggestionList;




    /**
     * Contructor to constructor for the Student menu
     */



    public SuggestionStudentMenuOptions(SuggestionList suggestionList) {
        this.suggestionList = suggestionList;
    }



    /**
     * Add the suggestions to the suggestion list
     @param cookie the User Object
     @param camp_array the User Object
     */

    public void Addsuggestions(ArrayList<Camp> camp_array, User cookie) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Submit suggestions.");
        Suggestions suggestion = new Suggestions(cookie,scanner);
        suggestionList.addSuggestion(suggestion);
    }

    /**
     Show the suggestions that the student created
     @param student the User Object
     */


    private void showSuggestionsForStudent(User student) {
        System.out.println("You selected Show Suggestions:");
        suggestionList.viewSuggestionsStudent(student);
    }

    /**
     Show the suggestions that the student created with less detail
     @param student the User Object
     */


    public void showsuggestionsmini(User student) {
        System.out.println("You selected Show Suggestions:");
        suggestionList.viewSuggestionsStudentmini(student);
    }


    /**
     Show the suggestions that the student created with less detail
     * @param camp_array the CampArray which the camp object is stored at
     * @param cookie the User Object (A Student) and their details
     * @param scanObj takes in the scanner Object for automated testing.
     */

    @Override
    public boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        showSuggestionsForStudent(cookie);
        return false;
    }



    /**
     Edit the Suggestions menu
     * @param camp_array the CampArray which the camp object is stored at
     * @param cookie the User Object (A Student) and their details
     * @param scanObj takes in the scanner Object for automated testing.
     */


    public boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Edit Suggestions.");

        boolean exitRequested = false;

        do {
            System.out.println("=== Suggestion EDIT UI ===");
            System.out.println("1. Edit Description");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    exitRequested = false;
                    int suggestionID;
                    showsuggestionsmini(cookie);
                    System.out.println("=====================================");
                    System.out.println("Which Suggestion do you want to edit");
                    System.out.println("=====================================");
                    suggestionID = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    suggestionList.editSuggestionsDescription(suggestionID, cookie.getUserID());
                    break;
                case 8:
                    exitRequested = true;  // Set the flag to exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!exitRequested);

        return false;
    }

    /**
     Delete the suggestions
     * @param camp_array the CampArray which the camp object is stored at
     * @param cookie the User Object (A Student) and their details
     * @param scanObj takes in the scanner Object for automated testing.
     */

    @Override
    public boolean runDelete(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        int thechosenone;
        showsuggestionsmini(cookie);
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Delete Suggestions:");
        System.out.println("Which Suggestion do you want to delete");
        thechosenone = scanner.nextInt();
        suggestionList.deleteSuggestionByID(thechosenone, cookie);
        return false;
    }
}


