/**
Represents the StaffStatusApp Object and the following assistance methods.
A StaffStatusApp can be run multiple times depending on the number of reports to be made.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-10
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Staff;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffStatusApp{
    
    /**
    * Runs the Staff Status Application to access main menu subsections.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStaffStatusApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        Staff cookieStaff = (Staff) cookie;
        System.out.println("Staff Status application");
        System.out.println("Staff UserID: "+cookieStaff.getUserID());
        System.out.println("Staff Email: "+cookieStaff.getEmail());
        System.out.println(cookieStaff.getFacultyInfo()+"Staff Faculty: ");
        System.out.println("Camps that you created are: ");
        for(int i=1; i< campArray.size(); i++){
            if(campArray.get(i-1).getStaffInCharge().equals(cookie.getUserID())){
                System.out.println(i+". "+campArray.get(i-1).getCampName());
            }
        }
        return true;
    }
}
