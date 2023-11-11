/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Staff;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
public class StaffStatusApp{
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
