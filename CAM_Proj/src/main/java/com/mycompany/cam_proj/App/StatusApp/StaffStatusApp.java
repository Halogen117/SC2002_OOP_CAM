/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.StatusApp;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Staff;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public class StaffStatusApp implements StatusApp{
    public boolean runStatusApp(ArrayList<Camp> campArray, User cookie){
        Staff cookieStaff = (Staff) cookie;
        System.out.println("Staff Status application");
        System.out.println("Staff UserID: "+cookieStaff.getUserID());
        System.out.println("Staff Email: "+cookieStaff.getEmail());
        System.out.println(cookieStaff.getFacultyInfo()+"Staff Faculty: ");
        System.out.println("Camps created are: ");
        if(campArray.isEmpty()){
            System.out.println("There are no camps created by you!");
        }else{
            for(int i=1; i< campArray.size(); i++){
                System.out.println(i+". "+campArray.get(i-1).getCampName());
            }
        
        }
        return true;
    }
}
