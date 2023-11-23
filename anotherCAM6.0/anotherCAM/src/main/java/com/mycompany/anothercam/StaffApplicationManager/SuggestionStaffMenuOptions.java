/**
 Represents the Menu that the Staff can use
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-11
 */


package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.Suggestions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Runs the Staff Menu Application which allow the staff to view ,set the status of the suggestion
 */



class SuggestionStaffMenuOptions {
    private ArrayList<Suggestions> suggestionList;
    SuggestionList suggestionlist = new SuggestionList();


    /**
     * Contructor to constructor for the staff menu
     */

    public SuggestionStaffMenuOptions() {
        this.suggestionList = SuggestionList.suggestionsList;
    }


    /**
     * View the all the suggestions that has been created
     */

    public void view() {
        showSuggestionsForStaff();
    }

    /**
     * View the all the suggestions that has been created but with fewer details
     */

    private void showSuggestionsForStaff() {
        System.out.println("You selected Show Suggestions:");
        suggestionlist.viewSuggestionsStaff();
    }


    /**
     * View the all the suggestions that has been created but with fewer details
     */

    public Boolean showsuggestionsmini (){ //show a small portion of the things the student can edit
        return suggestionlist.viewSuggestionsStaffmini();
    }

    /**
     * choose which suggestion to approve / reject  and also allow the staff to approve and reject
     */

    public String setStatus( ){
        int thechosenone;
        int choice;
        Scanner scanner = new Scanner(System.in);
        if (showsuggestionsmini() == true){
            System.out.println("Which Suggestion do you want to approve/reject");
            thechosenone = scanner.nextInt();
            System.out.println("do you want to approve/reject");
            System.out.println("Select 1 to approve");
            System.out.println("Select 2 to reject");

            choice = scanner.nextInt();
            if(choice == 1){
                String studentname;
                studentname = suggestionlist.approve(thechosenone);
                System.out.println("Suggestion: Approved");
                return studentname;
            }else if(choice == 2){
                suggestionlist.reject(thechosenone);
                System.out.println("Suggestion: Rejected");
                return null;
            }else{
                System.out.println("Please try again");
                return null;
            }
        }
        return null;
    }
}


