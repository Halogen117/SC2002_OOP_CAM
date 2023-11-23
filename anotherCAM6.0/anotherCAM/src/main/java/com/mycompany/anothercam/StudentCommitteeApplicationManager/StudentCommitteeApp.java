/**
Represents the StudentCommitteeApp Object and the following assistance methods.
A StudentCommitteeApp is ran depending on how many times a student committee member would want to access the app.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-6
*/
package com.mycompany.anothercam.StudentCommitteeApplicationManager;
import com.mycompany.anothercam.StudentApplicationManager.StudentCampApp;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


public class StudentCommitteeApp {

    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convertStringToDatetime(date_format.convertDatetimeToString(LocalDateTime.now()));

    /**
    * Runs the Student Committee Application to access main menu subsections.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Student) which the requested user to access the application.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */    
    public boolean runStudentCommitteeApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj) throws IOException{
        boolean loopCont = true;
        while(loopCont){
            System.out.println("WELCOME STUDENT COMMITTEE MEMBER "+cookie.getUserName()+":");
            System.out.println("1. Camp Subsection");
            // Enquiry
            System.out.println("2. Enquiry Subsection");
            // Suggestion
            System.out.println("3. Suggestion Subsection");
            // Generate report
            System.out.println("4. Report Subsection");
            
            System.out.println("5. Change Password");
            
            System.out.println("0. Log out!");
            int what_to_do = scanObj.nextInt();
            switch(what_to_do){
                case 1:
                    StudentCampApp studentCamper = new StudentCampApp();
                    studentCamper.runStudentCampApp(campArray, cookie, scanObj);
                    break;
                case 2:
                    break;
                    
                case 4:
                    StudentCommitteeReportApp studComRep = new StudentCommitteeReportApp();
                    studComRep.runStudentCommitteeReportApp(campArray, cookie, scanObj);
                    break;
                    
                case 5:
                    System.out.println("Please change your password!");
                    String change_password = scanObj.next();
                    cookie.setPassword(change_password);
                    System.out.println("Password has been changed!");
                    System.out.println("Logging out due to password change!");
                    loopCont = false;
                    break;
                
                case 6:
                    break;

                case 0:
                    loopCont = false;
                    break;
                }
        }
        return true;
    }
}
