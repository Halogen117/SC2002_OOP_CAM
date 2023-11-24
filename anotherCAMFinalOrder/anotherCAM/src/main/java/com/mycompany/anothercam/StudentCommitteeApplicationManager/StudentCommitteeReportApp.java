/**
Represents the StudentCommitteeReportApp Object and the following assistance methods.
A StudentCommitteeReportApp is run multiple times depending on how many times the user access the application.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-1
*/
package com.mycompany.anothercam.StudentCommitteeApplicationManager;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCommitteeReportApp {
    /**
    * Runs the Staff Report Application to access main menu subsections.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStudentCommitteeReportApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the Report Subsection");
            System.out.println("0. Exit Camp Interface");
            System.out.println("1. Generate Camp Committee Report");
            Verification veri = new Verification();
            int chooseReport = veri.verifyScannerNumber(scanObj);
            switch(chooseReport){
                case 0, -1:
                    loop_camp = false;
                    break;

                case 1:
                    try{
                        CampCommitteeReport campReport = new CampCommitteeReport();
                        campReport.runStudentCommitteeReport(campArray, cookie, scanObj);
                        break;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Input! Please Try again!");
                    break;
            }
        }
        return false;
    } 
}
