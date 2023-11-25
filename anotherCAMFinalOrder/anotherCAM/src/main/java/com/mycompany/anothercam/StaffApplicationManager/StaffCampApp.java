
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.Staff;
import java.util.ArrayList;
import java.util.Scanner;

/**
Represents the StaffCampApp Object and the following assistance methods.
A StaffCampApp is only run once.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-2
*/
public class StaffCampApp{
    
    /**
    * Runs the Staff Camp Application to access main menu subsections for the different camp functions.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStaffCampApp(ArrayList<Camp> campArray, Staff cookie, Scanner scanObj){
        Verification verifier = new Verification();
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the camp subsection");
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. Modify Camp");
                System.out.println("2. View All Camps");
                System.out.println("3. View Camps that you created.");
                System.out.println("4. Delete Camp");
                System.out.println("5. Create Camp");

            int choose_camp = verifier.verifyScannerNumber(scanObj);
            switch(choose_camp){
                case 0, -1:
                    loop_camp = false;
                    break;

                case 1:
                    StaffCampEdit staffEdit = new StaffCampEdit();
                    staffEdit.runEdit(campArray, cookie, scanObj);
                    break;

                case 2:
                    StaffCampView staffView = new StaffCampView();
                    staffView.runStaffViewCamp(campArray, cookie, scanObj, false);
                    break;

                case 3:
                    StaffCampView staffViewOwnCamp = new StaffCampView();
                    staffViewOwnCamp.runStaffViewCamp(campArray, cookie, scanObj, true);
                    break;
                    
                case 4:
                    StaffDeleteCamp delCamp = new StaffDeleteCamp();
                    delCamp.runDelete(campArray, cookie,scanObj);
                    break;

                case 5:
                    StaffCampCreate staffCreate = new StaffCampCreate();
                    if(staffCreate.runStaffCreateCamp(campArray, cookie, scanObj)== false){
                        System.out.println("Camp was not successfully created!");
                    };
                    break;
                default:
                    System.out.println("Invalid Input! Please Try again!");
                    break;
            }
        }
        return false;
    }
}
