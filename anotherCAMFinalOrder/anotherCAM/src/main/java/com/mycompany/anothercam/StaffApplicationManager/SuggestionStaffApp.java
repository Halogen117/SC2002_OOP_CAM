package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.User;

/**
 Represents the SuggestionStaffApp and the following assistance methods.
 A StaffReportApp can be run multiple times depending on staff
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */
public class SuggestionStaffApp {
    /**
     * Runs the Staff suggestion Application.
     *
     * @param campArray the CampArray which the new camp object is stored.
     * @param cookie    the User Object (A Staff) which the requested user creates the Camp
     * @param scanObj   takes in the scanner Object for automated testing.
     */

    public void runSuggestionStaffApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){

        //ArrayList<Suggestions> suggestions = new ArrayList<>(); // create the array for suggestions
        //SuggestionStaffMenuOptions menu = new SuggestionStaffMenuOptions();
        ViewSuggestionStaff view = new ViewSuggestionStaff();
        SetSuggestionStatusStaff setsuggest = new SetSuggestionStatusStaff();
        Verification veri = new Verification();
        while (true) {
            System.out.println("=== Suggestion UI ===");
            System.out.println("1. View Suggestions");
            System.out.println("2. Approve/Reject Suggestions");
            //System.out.println("7. Set to Student privilage");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = veri.verifyScannerNumber(scanObj);
            switch (choice) {//Staff
                case 1 -> view.view();
                case 2 -> setsuggest.setStatus(scanObj);

                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


