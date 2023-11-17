/**
Represents the StaffCampApp Object and the following assistance methods.
A StaffCampApp is only run once.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-2
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffCampApp{
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    
    /**
    * Runs the Staff Camp Application to access main menu subsections for the different camp functions.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStaffCampApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        Verification verifier = new Verification();
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the camp subsection");
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. Modify Camp");
                System.out.println("2. View Camps");
                System.out.println("3. Remove Camp");
                System.out.println("4. Create Camp");

            int choose_camp = verifier.verifyScannerNumber(scanObj);
            switch(choose_camp){
                case 0:
                    loop_camp = false;
                    break;

                case 1:
                    StaffCampEdit staffEdit = new StaffCampEdit();
                    staffEdit.runStaffEditCamp(campArray, cookie, scanObj);
                    break;

                case 2:
                    StaffCampView staffView = new StaffCampView();
                    staffView.runStaffViewCamp(campArray, cookie, scanObj);
                    break;

                case 3:
                    StaffDeleteCamp delCamp = new StaffDeleteCamp();
                    delCamp.runStaffDeleteCamp(campArray, cookie,scanObj);
                    break;

                case 4:
                    StaffCampCreate staffCreate = new StaffCampCreate();
                    if(staffCreate.runStaffCreateCamp(campArray, cookie, scanObj)== false){
                        System.out.println("Camp was not successfully created!");
                    };
                    break;
            }
        }
        return false;
    }
}
