/**
 Delete suggestions and the following assistance methods.
 Allow the user to Delete the suggestions
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.*;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.implementActions.Delete;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteSuggestionStud implements Delete{
    private SuggestionList suggestionList;
    private Verification veri = new Verification();


    /**
     * Contructor to constructor for the Student menu
     */


    public DeleteSuggestionStud(SuggestionList suggestionList) {
        this.suggestionList = suggestionList;
    }


    public boolean runDelete (ArrayList < Camp > camp_array, User cookie, Scanner scanObj){
        int thechosenone;
        if(ViewSuggestionStud.showsuggestionsmini(cookie) == false){
            return false;
        }
        System.out.println("You selected Delete Suggestions:");
        System.out.println("Which Suggestion do you want to delete");
        thechosenone = veri.verifyScannerNumber(scanObj);
        suggestionList.deleteSuggestionByID(thechosenone, cookie);
        return false;
    }
}



