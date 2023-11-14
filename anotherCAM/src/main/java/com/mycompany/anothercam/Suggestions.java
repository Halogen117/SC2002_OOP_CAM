package com.mycompany.anothercam;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

enum Status {
    APPROVED, PENDING, REJECTED;
}

public class Suggestions {
    private String CampID; //things to do change this to int
    private int SuggestionID; //things to do change this to int , auto increment the Suggestion ID
    private static int nextid = 1;

    private String Description;
    private Status status;
    private String nameofStudent;

    public Suggestions(String CampID, int nextid, String Description, String nameofStudent) {
        this.CampID = CampID;
        this.SuggestionID = nextid;
        this.Description = Description;
        this.status = Status.PENDING;
        this.nameofStudent = nameofStudent;
        nextid++;
    }

    public Suggestions(Scanner scanner) {
        System.out.print("Enter CampID: ");
        this.CampID = scanner.nextLine(); //will need to change to cookie.getcamp or something
        this.SuggestionID = nextid;
        System.out.print("Enter Description: ");
        this.Description = scanner.nextLine();
        this.status = Status.PENDING;
        System.out.print("Enter Name of Student: ");
        this.nameofStudent = scanner.nextLine();
        nextid++;
    }


    public void viewSuggestions() {
        System.out.println("Suggestion details:");
        System.out.println("CampID: " + getCampID());
        System.out.println("SuggestionID: " + getSuggestionID());
        System.out.println("Description: " + getDescription());
        System.out.println("Status: " + getStatus());
        System.out.println("Name of Student: " + getNameofStudent());
    }


    public void viewSuggestionsmini() {
        System.out.println("Suggestion details:");
        //System.out.println("CampID: " + getCampID());
        System.out.println("SuggestionID: " + getSuggestionID());
        System.out.println("Description: " + getDescription());
        System.out.println("Status: " + getStatus());
        //System.out.println("Name of Student: " + getNameofStudent());
    }

    public String getCampID() {
        return CampID;
    }

    public int getSuggestionID() {
        return SuggestionID;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNameofStudent() {
        return nameofStudent;
    }


    public static void deleteSuggestion(List<Suggestions> suggestionsList, int whichtodelete, String nameofstudent) {
        Iterator<Suggestions> iterator = suggestionsList.iterator();
        while (iterator.hasNext()) {
            Suggestions suggestion = iterator.next();
            if (suggestion.getSuggestionID() == whichtodelete && suggestion.getNameofStudent().equals(nameofstudent)) { // check if the suggestions is by the same student who created it and also the same one that the user coose to delete
                if (suggestion.getStatus() == Status.REJECTED || suggestion.getStatus() == Status.APPROVED) { // check if it has already been approved / rejeted
                    System.out.println("Suggestion cannot be Deleted");
                } else {
                    iterator.remove(); // Remove the suggestion from the list
                    System.out.println("Suggestion:" + whichtodelete + " Deleted");
                }
            }
        }
    }
}
