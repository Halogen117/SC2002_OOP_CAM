/**
 Represents the suggestion Object and the following mutator methods.
 @author Matthias Lim Xing Ran
 @version 5.0
 @since 2023-11-11
 */

package com.mycompany.anothercam;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;

public class Suggestions {
    private String CampID; //things to do change this to int
    private int SuggestionID; //things to do change this to int , auto increment the Suggestion ID
    private static int nextId = 1;

    private String description;
    private Status status;
    private String nameofStudent;
    private Verification veri = new Verification();


    /**
     * The Camp Constructor.
     * @param CampID The unique campID to identify which Camp the suggestion below to
     * @param nextid The Unique ID of the suggestion which increases after every time a new suggestions is made
     * @param description The description of the suggestion, that is the suggestion details and what not.
     * @param nameofStudent The Name of the student who made the suggestions
     */


    public Suggestions(String CampID, int nextid, String description, String nameofStudent) {
        this.CampID = getCampID();
        this.SuggestionID = nextId;
        this.description = description;
        this.status = Status.PENDING;
        this.nameofStudent = nameofStudent;
        nextId++;
    }

    public Suggestions(User student, Scanner scanObj, String description) {
        //System.out.print("Enter CampID: ");
        Student cookStud = (Student) student;
        this.CampID = cookStud.getCampCommitteeName();    //scanner.nextLine(); //will need to change to cookie.getcamp or something
        this.SuggestionID = nextId;
        String blank = null;
        this.description = description;
        this.status = Status.PENDING;
        this.nameofStudent = student.getUserID();
        nextId++;
    }

    /**
     * Gets the details of the suggestions.
     * @return the campID ,SuggestionID , Description ,Status , name of student
     *
     */

    public void viewSuggestions() {
        System.out.println("Suggestion details:");
        System.out.println("CampID: " + getCampID());
        System.out.println("SuggestionID: " + getSuggestionID());
        System.out.println("Description: " + getDescription());
        System.out.println("Status: " + getStatus());
        System.out.println("Name of Student: " + getNameofStudent());
    }

    /**
     * Gets the smaller details of the suggestions. to make it nicer owo
     * @return the SuggestionID, Description ,Status
     *
     */

    public void viewSuggestionsmini() {
        System.out.println("Suggestion details:");
        //System.out.println("CampID: " + getCampID());
        System.out.println("SuggestionID: " + getSuggestionID());
        System.out.println("Description: " + getDescription());
        System.out.println("Status: " + getStatus());
        //System.out.println("Name of Student: " + getNameofStudent());
    }


    /**
     * Gets the CampID that is associated with the Suggestions
     * @return campID
     *
     */
    public String getCampID() {
        return CampID;
    }


    /**
     * Gets the Unqiue Suggestion ID
     * @return SuggestionID
     *
     */

    public int getSuggestionID() {
        return SuggestionID;
    }



    /**
     * Gets the Description of the suggestions
     * @return  SuggestionID
     *
     */

    public String getDescription() {
        return description;
    }

    /**
     * Change the Description of the Suggestion Object
     * @param description This will become the new description of the suggestion
     *
     */


    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the Status of the suggestions
     * @return  Status
     *
     */

    public Status getStatus() {
        return status;
    }


    /**
     * Change the status of the Suggestion Object
     * @param status This will become the new status of the suggestion
     *
     */


    public void setStatus(Status status) {
        this.status = status;
    }


    /**
     * Gets the name of the student who created the suggestions
     * @return nameofStudent
     *
     */

    public String getNameofStudent() {
        return nameofStudent;
    }


    /**
     * Delete the suggestions that the student has created provided that the suggestiong is on approved / rejected
     * @param suggestionsList The suggestion list to find out which suggestion to delete from the list
     * @param whichtodelete This to check the suggestion who the camp committee member want to delete matches the student
     * @param nameofstudent This is to check if the student who is deleting the suggestion is the one who created the suggestions
     */


    public static boolean deleteSuggestion(List<Suggestions> suggestionsList, int whichtodelete, String nameofstudent) {
        Iterator<Suggestions> iterator = suggestionsList.iterator();
        while (iterator.hasNext()) {
            Suggestions suggestion = iterator.next();
            if (suggestion.getSuggestionID() == whichtodelete && suggestion.getNameofStudent().equals(nameofstudent)) { // check if the suggestions is by the same student who created it and also the same one that the user coose to delete
                if (suggestion.getStatus() == Status.REJECTED || suggestion.getStatus() == Status.APPROVED) { // check if it has already been approved / rejeted
                    System.out.println("Suggestion cannot be Deleted");
                    return false;
                } else {
                    iterator.remove(); // Remove the suggestion from the list
                    System.out.println("Suggestion:" + whichtodelete + " Deleted");
                    return true;
                }
            }
        }
        return false;
    }
}
