/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp.CampDelete;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
public class DeleteCamp {
    private Scanner scanObj = new Scanner(System.in);
    public boolean runDeleteCamp(ArrayList<Camp> campArray, User cookie){
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
                campArray.remove(campArray.get(decision-1));
                System.out.println("Deletion was successful!");
                return true;
            }else{
                System.out.println("Deletion was not successful!");
                return false;
            }
        }
        System.out.println("Deletion was not successful!");
        return false;
    }
}
