/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
public class StaffDeleteCamp {
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
