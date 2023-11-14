package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.Suggestions;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.implementActions.ViewEditDelete;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


class SuggestionStaffMenuOptions implements ViewEditDelete {
    private ArrayList<Suggestions> suggestionList;
    SuggestionList sugList = new SuggestionList();

    public SuggestionStaffMenuOptions() {
        this.suggestionList = SuggestionList.suggestionslist;
    }

    public void view() {
        showSuggestionsForStaff();
    }



    private void showSuggestionsForStaff() {
        System.out.println("You selected Show Suggestions:"); 
        SuggestionList.viewSuggestionsStaff();
    }

    public void showsuggestionsmini (){ //show a small portion of the things the student can edit
        
        suggestionList.viewSuggestionsStaffmini();  
        
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
            suggestionList.approve(thechosenone);
            System.out.println("Suggestion: Approved");
        }else if(Objects.equals(choice, "reject")){
            suggestionList.reject(thechosenone);
            System.out.println("Suggestion: Rejected");
        }else{
                System.out.println("Please try again");
        }
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


