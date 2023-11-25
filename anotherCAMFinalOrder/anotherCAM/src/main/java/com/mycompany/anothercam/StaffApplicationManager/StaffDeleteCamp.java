package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Staff;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.implementActions.Delete;

import java.util.ArrayList;
import java.util.Scanner;

/**
Represents the StaffDeleteCamp Object and the following assistor methods.
A StaffDeleteCamp can be called multiple times depending on how many camps to be deleted.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
public class StaffDeleteCamp implements Delete {
    /**
    * Runs the Staff Delete Application.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return the boolean value whether the deletion of camp object was successful.
    */
    @Override
    public boolean runDelete(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        // Print all camps
        Verification veri = new Verification();

        if(campArray.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            System.out.println("These are the camps that exist that you are authorized to delete!");
            ArrayList<Integer> authorizedDelete = printDeletedCampList(campArray, (Staff)cookie);
            System.out.println("0. Exit decision to remove camp!");
            System.out.println("Which camp do you want to remove? ");
            int decision = veri.verifyScannerNumber(scanObj);
            if(decision == 0){
                return false;
            }else if(decision > authorizedDelete.size()){
                System.out.println("This camp does not exist!");
            }else if(!campArray.get(authorizedDelete.get(decision-1)).getStaffInCharge().equals(cookie.getUserID())){
                System.out.println("You do not have the authority to delete the camp!");
                return false;
            }else if((0 < decision)&&(decision <= campArray.size()+1)){
                System.out.println("Are you sure you want to delete the camp?");
                
                System.out.println("Deleting Camp "+ campArray.get(authorizedDelete.get(decision-1)).getCampName());
                // Check if the camp any student registered/ campcommittee
                if(campArray.get(authorizedDelete.get(decision-1)).getCampStudentList().size() >0 || campArray.get(authorizedDelete.get(decision-1)).getCampCommitteeList().size()>0)
                {
                    System.out.println("Deletion was not successful as there are still students in the camp!");
                    return false;
                }else{
                    campArray.remove(campArray.get(authorizedDelete.get(decision-1)));
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
    
    /**
     * This will print the camp that is deleted.
     * @param campArray ArrayList of camps that exist in the application
     * @param cookie Staff Cookie that is used to find the camp he is in charge of deleting.
     * @return an integer value which is the campID to delete.
     */
    public ArrayList<Integer> printDeletedCampList(ArrayList<Camp> campArray, Staff cookie){
        ArrayList<Integer> integerThis = new ArrayList<Integer>();
        for(int i=0; i<campArray.size(); i++){
            if(campArray.get(i).getStaffInCharge().equals(cookie.getUserID())){
                integerThis.add(i);
                System.out.println(integerThis.size()+". Camp "+campArray.get(integerThis.get(integerThis.size()-1)).getCampName());
                    }
            }
        return integerThis;
        }
}

