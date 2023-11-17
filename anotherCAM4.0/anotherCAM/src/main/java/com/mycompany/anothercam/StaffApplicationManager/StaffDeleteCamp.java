/**
Represents the StaffDeleteCamp Object and the following assistor methods.
A StaffDeleteCamp can be called multiple times depending on how many camps to be deleted.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffDeleteCamp {
    /**
    * Runs the Staff Delete Application.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return the boolean value whether the deletion of camp object was successful.
    */
    public boolean runStaffDeleteCamp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
// Print all camps
        if(campArray.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            System.out.println("These are the camps that exist!");
            for(int i=1; i< campArray.size()+1; i++){
                if(campArray.get(i-1).getStaffInCharge().equals(cookie.getUserID()))
                System.out.println(i+". "+campArray.get(i-1).getCampName());
            }
            System.out.println("0. Exit decision to remove camp!");
            System.out.println("Which camp do you want to remove? ");
            int decision = scanObj.nextInt();
            if(decision == 0){
                return false;
            }else if(decision > campArray.size()+1){
                System.out.println("This camp does not exist!");
            }else if((0 < decision)&&(decision <= campArray.size()+1)){
                System.out.println("Deleting Camp "+ campArray.get(decision-1).getCampName());
                // Check if the camp any student registered/ campcommittee
                if(campArray.get(decision-1).getCampStudentList().size() >0 || campArray.get(decision-1).getCampCommitteeList().size()>0)
                {

                    System.out.println("Deletion was not successful as there are still students in the camp!");
                    return false;
                }else{
                    campArray.remove(campArray.get(decision-1));
                    System.out.println("Deletion was successful!");
                    return true;
                }

            }else{
                System.out.println("Deletion was not successful!");
                return false;
            }
        }
        System.out.println("Deletion was not successful!");
        return false;
    }
}
