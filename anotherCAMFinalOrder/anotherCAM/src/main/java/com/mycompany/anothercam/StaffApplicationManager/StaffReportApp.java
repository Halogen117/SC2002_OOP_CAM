/**
Represents the StaffReportApp Object and the following assistance methods.
A StaffReportApp can be run multiple times depending on the number of reports to be made.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-8
*/
package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;


public class StaffReportApp {
    /**
    * Runs the Staff Report Application to access main menu subsections.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStaffReportApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        Verification verifier = new Verification();
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the report subsection");
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. Generate Report");
                System.out.println("2. Generate Performance Report Camps");

            int chooseReport = verifier.verifyScannerNumber(scanObj);
            switch(chooseReport){
                case 0, -1:
                    loop_camp = false;
                    break;

                case 1:
                    StaffReport staffRepo = new StaffReport();
                    staffRepo.runStaffReportCamp(campArray, cookie, scanObj);
                    break;

                case 2:
                    StaffPerformanceReport staffPerRep = new StaffPerformanceReport();
                    try{
                        staffPerRep.runStaffPerformanceReport(campArray, cookie, scanObj);
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
