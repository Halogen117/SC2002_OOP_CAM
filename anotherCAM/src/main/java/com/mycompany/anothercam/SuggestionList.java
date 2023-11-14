package com.mycompany.anothercam;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static com.mycompany.anothercam.Status.*;

public class SuggestionList {
    public static ArrayList<Suggestions> suggestionsList = new ArrayList<>();

    public void addSuggestion(Suggestions suggestion) {
        Objects.requireNonNull(suggestionsList, "suggestionsList must be initialized");
        suggestionsList.add(suggestion);
    }

    public void viewSuggestionsStaff() {
        System.out.println("=== Suggestions List ===");
        for (Suggestions suggestion : suggestionsList) {
            System.out.println("================================");
            suggestion.viewSuggestions();
        }
    }

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

    public void viewSuggestionsStaffmini() {
        System.out.println("=== Suggestions List IDs ===");
        for (Suggestions suggestion : suggestionsList) {
            System.out.println("================================");
            suggestion.viewSuggestionsmini();
        }
    }

    public void editSuggestionsDescription(int suggestionID, String Nameofstudent) {
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getSuggestionID() == suggestionID) {
                if (suggestion.getStatus() == REJECTED || suggestion.getStatus() == APPROVED) {
                    System.out.println("Suggestions cannot be edited because it has been approved / rejected");
                    return;
                } else {
                    if (suggestion.getNameofStudent().equals(Nameofstudent)) {
                        String description;
                        try (Scanner scanner = new Scanner(System.in)) {
                            System.out.println("What is your input:");
                            description = scanner.next();
                        }
                        suggestion.setDescription(description);
                        return;
                    }
                }
            }
        }
        System.out.println("Suggestions not found, please try again");
    }

    public void approve(int chosenone) {
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getSuggestionID() == chosenone) {
                suggestion.setStatus(APPROVED);
            }
        }
    }

    public void reject(int chosenone) {
        for (Suggestions suggestion : suggestionsList) {
            if (suggestion.getSuggestionID() == chosenone) {
                suggestion.setStatus(REJECTED);
            }
        }
    }

    public void deleteSuggestionByID(int suggestionID, User nameofstudent) {
        Suggestions.deleteSuggestion(suggestionsList, suggestionID, nameofstudent.getUserID());
    }
}
