/**
Represents the StaffApp Object and the following assistance methods.
A StaffApp is run depending on how many times a student committee member would want to access the app.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-6
*/

package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;

public class StaffApp{
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    
    /**
    * Runs the Staff Application to access main menu subsections.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loopCont = true;
        Verification verifier = new Verification();
        while(loopCont){
            if(cookie == null){
                loopCont = false;
                break;
            }
            System.out.println("WELCOME STAFF "+cookie.getUserID()+":");
            System.out.println("0. Log out!");
            System.out.println("1. Camp Subsection");
            System.out.println("2. Enquiry Subsection");
            // Suggestion
            System.out.println("3. Suggestion Subsection");

            System.out.println("4. Access Status Subsection");
            
            System.out.println("5. Report Subsection");
            
            System.out.println("6. Change Password");
            
            int what_to_do = verifier.verifyScannerNumber(scanObj);
            switch(what_to_do){
                case 1:
                    StaffCampApp staffCamper = new StaffCampApp();
                    staffCamper.runStaffCampApp(campArray, cookie, scanObj);
                    break;
                    
                case 3:
                    System.out.println("Accessing Suggestion Subsection!");
                    SuggestionStaffApp sugstaff = new SuggestionStaffApp();
                    sugstaff.runSuggestionStaffApp(campArray, cookie, scanObj);
                case 4:
                    System.out.println("Accessing Staff Status Subsection!");
                    StaffStatusApp statStaff = new StaffStatusApp();
                    statStaff.runStaffStatusApp(campArray, cookie,scanObj);
                
                case 5:
                    System.out.println("Accessing Report Subsection!");
                    StaffReportApp repoApp = new StaffReportApp();
                    repoApp.runStaffReportApp(campArray, cookie, scanObj);
                    break;
                case 6:
                    System.out.println("Please change your password!");
                    String change_password = scanObj.next();
                    cookie.setPassword(change_password);
                    System.out.println("Password has been changed!");
                    System.out.println("Logging out due to password change!");
                    loopCont = false;
                    break;
                case 0:
                    loopCont = false;
                    break;
                }
        }
        return true;
    }
    /*
    public boolean exit_camp(){
        return true;
    }
    
    public boolean signup_camp(){
        return true;
    }
    */
}
