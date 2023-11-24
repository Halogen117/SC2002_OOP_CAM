/**
 Delete suggestions and the following assistance methods.
 Allow the user to Delete the suggestions
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */

package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteSuggestionStud {
    private SuggestionList suggestionList;


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
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Delete Suggestions:");
        System.out.println("Which Suggestion do you want to delete");
        thechosenone = scanner.nextInt();
        suggestionList.deleteSuggestionByID(thechosenone, cookie);
        return false;
    }
}



