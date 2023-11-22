/**
 Represents the Menus and the following assistance methods.
 Menus navigate to the different things the user can do
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.*;
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
     *
     * @param cookie     the User Object
     * @param camp_array the User Object
     */

    public void Addsuggestions(ArrayList<Camp> camp_array, User cookie) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Submit suggestions.");
        Student cookStud = (Student) cookie;
        if(cookStud.getCampCommitteeName() == null){
            System.out.println("Not a Committee Member");
            return;
        }
        Suggestions suggestion = new Suggestions(cookie, scanner);
        suggestionList.addSuggestion(suggestion);
    }

    /**
     * Show the suggestions that the student created
     *
     * @param student the User Object
     */


    private void showSuggestionsForStudent(User student) {
        System.out.println("You selected Show Suggestions:");
        suggestionList.viewSuggestionsStudent(student);
    }

    /**
     * Show the suggestions that the student created with less detail
     *
     * @param student the User Object
     */


    public Boolean showsuggestionsmini(User student) {

        //System.out.println("You selected Show Suggestions:");
        return suggestionList.viewSuggestionsStudentmini(student);
    }


    /**
     * Show the suggestions that the student created with less detail
     *
     * @param camp_array the CampArray which the camp object is stored at
     * @param cookie     the User Object (A Student) and their details
     * @param scanObj    takes in the scanner Object for automated testing.
     */

    @Override
    public boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        showSuggestionsForStudent(cookie);
        return false;
    }


    /**
     * Edit the Suggestions menu
     *
     * @param camp_array the CampArray which the camp object is stored at
     * @param cookie     the User Object (A Student) and their details
     * @param scanObj    takes in the scanner Object for automated testing.
     */


    public boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Edit Suggestions.");
        if(showsuggestionsmini(cookie) == false){
            return false;
        }
        System.out.println("=== Suggestion EDIT UI ===");
        System.out.println("1. Edit Description");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = 0;
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                int suggestionID;
                System.out.println("=====================================");
                System.out.println("Which Suggestion do you want to edit");
                System.out.println("=====================================");
                suggestionID = scanner.nextInt();
                suggestionList.editSuggestionsDescription(suggestionID, cookie.getUserID());
                System.out.println("description edit successfully");
            case 0:
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
                return false;
        }
    }

        /**
         Delete the suggestions
         * @param camp_array the CampArray which the camp object is stored at
         * @param cookie the User Object (A Student) and their details
         * @param scanObj takes in the scanner Object for automated testing.
         */

        @Override
        public boolean runDelete (ArrayList < Camp > camp_array, User cookie, Scanner scanObj){
            int thechosenone;
            if(showsuggestionsmini(cookie) == false){
                return false;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("You selected Delete Suggestions:");
            System.out.println("Which Suggestion do you want to delete");
            thechosenone = scanner.nextInt();
            suggestionList.deleteSuggestionByID(thechosenone, cookie);
            return false;
        }
    }



