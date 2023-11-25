package com.mycompany.anothercam;

import java.util.ArrayList;
import java.util.Objects;

/**
 SuggestionsList will store all the suggestion that are created
 contain many functions to allow  edit view delete submit and approve / reject of suggestions
 @author Matthias Lim Xing Ran
 @version 5.0
 @since 2023-11-11
 */
public class SuggestionList {

    /**
     * Static ArrayList of Suggestions to be accessed for the whole program.
     */
    public static ArrayList<Suggestions> suggestionsList = new ArrayList<>();

    /**
     * Add suggestion into the Array
     * @param suggestion is the Suggestion to be deleted
     *
     */

    public void addSuggestion(Suggestions suggestion) {
        Objects.requireNonNull(suggestionsList, "suggestionsList must be initialized");
        suggestionsList.add(suggestion);

    }

    /**
     * Deleted function to moved to Individual Suggestions to de-couple it from the main Suggestion List
     * @param suggestionID is the Suggestion to be deleted
     * @param nameofstudent is name of the student that will be checked
     *
     */

    public void deleteSuggestionByID(int suggestionID, User nameofstudent) {

        if(Suggestions.deleteSuggestion(suggestionsList, suggestionID, nameofstudent.getUserID()) == true){ // if manage to delete sussfully
            Student student = (Student) nameofstudent;
            student.decrementPoint();
            System.out.println(nameofstudent.getUserName() + "has" + student.getPoints() + " points");
        }
    }
}
