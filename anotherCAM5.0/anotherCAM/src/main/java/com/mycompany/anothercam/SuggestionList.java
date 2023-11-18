package com.mycompany.anothercam;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.mycompany.anothercam.Status.*;

public class SuggestionList {
    public static ArrayList<Suggestions> suggestionsList = new ArrayList<>();

    /**
     * Add suggestion into the Array
     * @param suggestion is the Suggestion to be deleted
     *
     */

    public void addSuggestion(Suggestions suggestion) {
        Objects.requireNonNull(suggestionsList, "suggestionsList must be initialized");
        suggestionsList.add(suggestion);
    }



    /**
     * Print out all the suggestions for the staff to see
     */

    public void viewSuggestionsStaff() {
        System.out.println("=== Suggestions List ===");
        for (Suggestions suggestion : suggestionsList) {
            System.out.println("================================");
            suggestion.viewSuggestions();
        }
    }

    /**
     * Print out the suggestions that are made only by the student
     * validation is checked to see if the student and the suggestions are created by the student , it also checks if the suggestions have been deleted or approved such that it will not show is the suggestions are in any of those two states KILL ME PELASE OWOWOWOWOW
     */


    public void viewSuggestionsStudent(User student) {
        System.out.println("=== Suggestions List ===");
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getStatus() == REJECTED || suggestion.getStatus() == APPROVED) {
                // System.out.println("Suggestion: cannot be viewed");
            } else {
                if (Objects.equals(suggestion.getNameofStudent(), student.getUserID())) {
                    System.out.println("================================");
                    suggestion.viewSuggestions();
                }
            }
        }
    }


    /**
     *  Do the same thing as viewSuggestionsStudent except it print out lesser things  based on different usage.
     * @param student The User Object which holds the student cookie.
     */
    public void viewSuggestionsStudentmini(User student) {
        System.out.println("=== Suggestions List IDs ===");
        for (Suggestions suggestion : suggestionsList) {
            if (Objects.equals(suggestion.getNameofStudent(), student.getUserID())) {
                if (suggestion.getStatus() == PENDING) {
                    System.out.println("================================");
                    suggestion.viewSuggestionsmini();
                } else { // suggestion.getStatus() == REJECTED || suggestion.getStatus() == APPROVED
                    System.out.println("Suggestion: cannot be viewed");
                }
            }
        }
    }



    /**
     *  Do the same thing as viewSuggestionsStaff except it print out lesser things  based on different usage.
     */

    public void viewSuggestionsStaffmini() {
        System.out.println("=== Suggestions List IDs ===");
        for (Suggestions suggestion : suggestionsList) {
            System.out.println("================================");
            suggestion.viewSuggestionsmini();
        }
    }


    /**
     *  Allow the student to edit Description of the Suggestion
     *  Valid is checked to see if the suggestion matches the studentID as well as if the suggestion has been approved or rejected
     * @param suggestionID
     * @param NameofStudent
     */

    public void editSuggestionsDescription(int suggestionID, String Nameofstudent) {
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getSuggestionID() == suggestionID) {
                if (suggestion.getStatus() == Status.REJECTED || suggestion.getStatus() == Status.APPROVED) {
                    System.out.println("Suggestions cannot be edited because it has been approved / rejected");
                    return;
                } else {
                    if (suggestion.getNameofStudent().equals(Nameofstudent)) {
                        String description;
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter the new description:");
                        description = scanner.nextLine();
                        suggestion.setDescription(description);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        System.out.println("Suggestions not found, please try again");
    }



    /**
     * Find the specific  Suggestion to be APPROVED
     * @param chosenone is the Suggestion to be changed to APPROVED
     *
     */



    public void approve(int chosenone) {
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getSuggestionID() == chosenone) {
                suggestion.setStatus(APPROVED);
            }
        }
    }



    /**
     * Find the specific  Suggestion to be REJECTED
     * @param chosenone is the Suggestion to be changed to REJECTED
     *
     */

    public void reject(int chosenone) {
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getSuggestionID() == chosenone) {
                suggestion.setStatus(REJECTED);
            }
        }
    }

    /**
     * Deleted function to moved to Individual Suggestions to de-couple it from the main Suggestion List
     * @param suggestionID is the Suggestion to be deleted
     * @param nameofstudent is name of the student that will be checked
     *
     */




    public void deleteSuggestionByID(int suggestionID, User nameofstudent) {
        Suggestions.deleteSuggestion(suggestionsList, suggestionID, nameofstudent.getUserID());
    }
}
