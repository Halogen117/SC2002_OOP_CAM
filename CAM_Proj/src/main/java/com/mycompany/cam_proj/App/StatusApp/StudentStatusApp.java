/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.StatusApp;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Student;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public class StudentStatusApp implements StatusApp{
    public boolean runStatusApp(ArrayList<Camp> campArray, User cookie){
        Student cookieStud = (Student) cookie;

        System.out.println("Student Status application");
        System.out.println("Student UserID: "+cookieStud.getUserID());
        System.out.println("Student Email: "+cookieStud.getEmail());
        System.out.println("Student Faculty: "+cookieStud.getFacultyInfo());
        if(cookieStud.getCampCommittee()){
            System.out.println("Camp Committee Member: YES YOU ARE");
        }else{
            System.out.println("Camp Committee Member: NIL");
        }
        
        System.out.println("Camps registered are: ");
        if(campArray.isEmpty()){
            System.out.println("There are no camps created by you!");
        }else{
            for(int i=1; i< campArray.size(); i++){
                if(campArray.get(i-1).getFaculty() == cookieStud.getFacultyInfo()){
                    System.out.println(i+". "+campArray.get(i-1).getCampName());
                }
                
            }
        
        }
        return true;
    }
}
