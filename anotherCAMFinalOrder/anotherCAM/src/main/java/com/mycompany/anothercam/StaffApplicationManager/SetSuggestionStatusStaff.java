package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.StudentList;
import com.mycompany.anothercam.SuggestionList;
import com.mycompany.anothercam.Suggestions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;

import static com.mycompany.anothercam.Status.APPROVED;
import static com.mycompany.anothercam.Status.REJECTED;
import static com.mycompany.anothercam.SuggestionList.suggestionsList;
/**
 Represents the Menu that the Staff can use.
 Runs the Staff Menu Application which allow the staff to view ,set the status of the suggestion.
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-11
 */
class SetSuggestionStatusStaff {
    private ArrayList<Suggestions> suggestionList;
    private Verification veri = new Verification();
    SuggestionList suggestionlist = new SuggestionList();
    ViewSuggestionStaff uwu = new ViewSuggestionStaff();

    /**
     * Contructor to constructor for the staff menu
     */

    public SetSuggestionStatusStaff() {
        this.suggestionList = suggestionsList;
    }

    /**
     * choose which suggestion to approve / reject  and also allow the staff to approve and reject
     */

    public String setStatus(Scanner scanObj){
        int thechosenone;
        int choice;
        if (uwu.showsuggestionsmini() == true){
            System.out.println("Which Suggestion do you want to approve/reject");
            thechosenone = veri.verifyScannerNumber(scanObj);
            System.out.println("Do you want to approve/reject");
            System.out.println("Select 1 to approve");
            System.out.println("Select 2 to reject");

            choice = veri.verifyScannerNumber(scanObj);
            if(choice == 1){
                String studentname;
                //studentname = suggestionlist.approve(thechosenone);
                for (Suggestions suggestion : suggestionsList) {
                    if (suggestion.getSuggestionID() == thechosenone && suggestion.getStatus() != APPROVED) { // check that the chosen one is not Approved alraedy
                        suggestion.setStatus(APPROVED);
                        Student student = (Student) StudentList.returnStudentCookie(suggestion.getNameofStudent());
                        assert student != null;
                        student.incrementPoint();
                        System.out.println(student.getUserName()+ " has " + student.getPoints() + " points");
                    }
                }
                System.out.println("Suggestion: Approved");
            }else if(choice == 2){
                //suggestionlist.reject(thechosenone);
                for (Suggestions suggestion : suggestionsList) {
                    if (suggestion.getSuggestionID() == thechosenone) {
                        if(suggestion.getStatus() == APPROVED){
                            suggestion.setStatus(REJECTED);
                            Student student = (Student) StudentList.returnStudentCookie(suggestion.getNameofStudent()); // decrease the point if the suggestion was previously approved
                            assert student != null;
                            student.decrementPoint();
                            System.out.println(student.getUserName()+ " has " + student.getPoints() + " points");
                        }
                        suggestion.setStatus(REJECTED);
                    }
                }
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


