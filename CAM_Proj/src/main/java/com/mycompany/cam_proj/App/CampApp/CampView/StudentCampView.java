/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp.CampView;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.Staff;
import com.mycompany.cam_proj.Student;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public class StudentCampView implements ViewCamp{
    public boolean runViewCamp(ArrayList<Camp> campArray, User cookie){
        if(campArray.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            for(int i=1; i< campArray.size()+1; i++){
                if((campArray.get(i-1).getVisiblility() == true && campArray.get(i-1).getFaculty() == cookie.getFacultyInfo())){
                    System.out.println("Camp Number "+i+" on display!");
                    // Check what is the role of the user!
                    System.out.println("The camp name is "+campArray.get(i-1).getCampName());
                    System.out.println("The date the camp starts is on "+campArray.get(i-1).getDateString());
                    System.out.println("The registration date the camp ends is on "+campArray.get(i-1).getRegClosingDateString());
                    System.out.println("The location of the camp is "+campArray.get(i-1).getLocation());
                    System.out.println("The total slots available in the camp are "+campArray.get(i-1).getTotalSlot());
                    System.out.println("The total camp committee slots available in the camp are "+campArray.get(i-1).getCampCommitteeSlots());
                    System.out.println("The Description of the camp is "+campArray.get(i-1).getDescription());
                    System.out.println("The faculty of the camp it is under is "+campArray.get(i-1).getFaculty());
                    System.out.println("The staff in charge of the camp is "+campArray.get(i-1).getStaffInCharge());
                    // Find a way to check if student_list is empty
                    if(campArray.get(i-1).getStudentList().isEmpty()){
                        System.out.println("There are no students who signed up for the camp at the moment!");
                    }else{
                        System.out.println("The students in the camp so far are ");
                        for(Student stud: campArray.get(i-1).getStudentList()){
                            System.out.println(stud.getUserID());
                        }
                    }
                }
            }
        }
        return true;
    }
}