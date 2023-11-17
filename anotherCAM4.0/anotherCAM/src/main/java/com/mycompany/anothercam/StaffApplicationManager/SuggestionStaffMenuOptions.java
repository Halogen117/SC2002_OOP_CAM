package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.Suggestions;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.implementActions.ViewEditDelete;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


class SuggestionStaffMenuOptions {
    private ArrayList<Suggestions> suggestionList;
    SuggestionList suggestionlist = new SuggestionList();

    public SuggestionStaffMenuOptions() {
        this.suggestionList = SuggestionList.suggestionsList;
    }


    public void view() {
        showSuggestionsForStaff();
    }



    private void showSuggestionsForStaff() {
        System.out.println("You selected Show Suggestions:");
        suggestionlist.viewSuggestionsStaff();
    }

    public void showsuggestionsmini (){ //show a small portion of the things the student can edit

        suggestionlist.viewSuggestionsStaffmini();
        
    }

    public void setStatus( ){
        int thechosenone;
        String choice;
        Scanner scanner = new Scanner(System.in);
        showsuggestionsmini();
        System.out.println("Which Suggestion do you want to approve/reject");
        thechosenone = scanner.nextInt();
        System.out.println("do you want to approve/reject");
        choice = scanner.next();
        if(Objects.equals(choice, "approve")){
            suggestionlist.approve(thechosenone);
            System.out.println("Suggestion: Approved");
        }else if(Objects.equals(choice, "reject")){
            suggestionlist.reject(thechosenone);
            System.out.println("Suggestion: Rejected");
        }else{
                System.out.println("Please try again");
        }
    }

}


