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

    public SuggestionStudentMenuOptions(SuggestionList suggestionList) {
        this.suggestionList = suggestionList;
    }


    public void edit(User student) {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Edit Suggestions.");
        boolean exitRequested = false;

        while (!exitRequested) {
            System.out.println("=== Suggestion EDIT UI ===");
            System.out.println("1. Edit Description");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1 -> {
                    int suggestionID; //need to change to int but hey...
                    //String nameofstudent = "melon"; //set melon for now
                    showsuggestionsmini(student); // should alwalys be true
                    System.out.println("=====================================");
                    System.out.println("Which Suggestion do you want to edit");
                    System.out.println("=====================================");
                    suggestionID = scanner.nextInt();
                    suggestionList.editSuggestionsdescription(suggestionID, student.getUserID());
                }
                case 2 -> {
                }
                case 8 -> // System.out.println("Goodbye!"); // might need to change something else to edit back
                    // scanner.close();
                    // System.exit(0);
                    exitRequested = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
            //edit something else?
                    }
    }
    
    public void view(User student) {
            showSuggestionsForStudent(student);
    }


    public void delete(User student) {
        int thechosenone;
        //String nameofstudent = "melon"; // Replace with the actual student's name
        showsuggestionsmini(student);
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Delete Suggestions:");
        System.out.println("Which Suggestion do you want to delete");
        thechosenone = scanner.nextInt();
        suggestionList.deleteSuggestion(thechosenone, student);
    }

    public void Addsuggestions() { // sumbit suggestions
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Submit suggestions.");
        Suggestions suggestion = new Suggestions(scanner);
        suggestionList.addSuggestion(suggestion);
    }
    private void showSuggestionsForStudent(User student) {
        //String melon = "melon"; // student name (replace with actual name)
        System.out.println("You selected Show Suggestions:");
        suggestionList.viewSuggestionsStudent(student);
    }
    public void showsuggestionsmini (User student){ //show a small portion of the things the student can edit
               // String melon = "melon";
                //System.out.println("You selected Show Suggestions:");
                suggestionList.viewSuggestionsStudentmini(student);
    }

    @Override
    public boolean runView(ArrayList<Camp> camp_array, User cookie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean runEdit(ArrayList<Camp> camp_array, User cookie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean runDelete(ArrayList<Camp> camp_array, User cookie) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


