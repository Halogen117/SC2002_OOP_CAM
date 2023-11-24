/**
 Add suggestions and the following assistance methods.
 Allow the user to Add the suggestions
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentCommitteeApplicationManager;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SubmitSuggestionStud {
    private SuggestionList suggestionList;
    private Verification veri = new Verification();


    /**
     * Contructor to constructor for the Student menu
     */


    public SubmitSuggestionStud(SuggestionList suggestionList) {
        this.suggestionList = suggestionList;
    }


    /**
     * Add the suggestions to the suggestion list
     *
     * @param cookie     the User Object
     * @param camp_array the User Object
     */

    public void Addsuggestions(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        System.out.println("You selected Submit suggestions.");
        Student cookStud = (Student) cookie;
        if(cookStud.getCampCommitteeName() == null){
            System.out.println("Not a Committee Member");
            return;
        }
        String description = null;
        description = veri.verifyDescription(description, "Enter Description!", scanObj);
        Suggestions suggestion = new Suggestions(cookie, scanObj,description);
        suggestionList.addSuggestion(suggestion);
        Student student = (Student) cookie;
        student.incrementPoint();
        System.out.println(student.getUserName() + "has " + student.getPoints() + " points");
    }
}



