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
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentCampView implements ViewCamp{
    private ArrayList<Integer> countKeep = new ArrayList<Integer>();
    private Scanner scanObj = new Scanner(System.in);
    public boolean runViewCamp(ArrayList<Camp> campArray, User cookie){
        // Filtered array based on faculty info
        int getCampChoice = runViewCampListOut(campArray, cookie);
        if(getCampChoice == -1){
            return true;
        }
        else if(getCampChoice == 0){
            System.out.println("Exiting Viewing Camp menu!");
            return true;
        }else if(countKeep.contains(getCampChoice)){
            // Check what is the role of the user!
            System.out.println("The camp name is "+campArray.get(countKeep.indexOf(getCampChoice)).getCampName());
            System.out.println("The date the camp starts is on "+campArray.get(countKeep.indexOf(getCampChoice)).getDateString());
            System.out.println("The registration date the camp ends is on "+campArray.get(countKeep.indexOf(getCampChoice)).getRegClosingDateString());
            System.out.println("The location of the camp is "+campArray.get(countKeep.indexOf(getCampChoice)).getLocation());
            System.out.println("The total slots available in the camp are "+campArray.get(countKeep.indexOf(getCampChoice)).getTotalSlot());
            /*
            if(campArray.get(i-1).getCampCommitteeSlots().isEmpty()){
                System.out.println("There are no camps that exist at the moment.");
            }else{
                System.out.println("The camp committee members so far are ");
                for(Student stud: campArray.get(i-1).getCampCommitteeSlots()){
                    System.out.println(stud.getUserID());
                }
            }
            */
            System.out.println("The Description of the camp is "+campArray.get(countKeep.indexOf(getCampChoice)).getDescription());
            System.out.println("The faculty of the camp it is under is "+campArray.get(countKeep.indexOf(getCampChoice)).getFaculty());
            System.out.println("The staff in charge of the camp is "+campArray.get(countKeep.indexOf(getCampChoice)).getStaffInCharge());
            // Find a way to check if student_list is empty
            /*
            if(campArray.get(i-1).getStudentList().isEmpty()){
                System.out.println("There are no students who signed up for the camp at the moment!");
            }else{
                System.out.println("The students in the camp so far are ");
                for(Student stud: campArray.get(i-1).getStudentList()){
                    System.out.println(stud.getUserID());
                }
            }
            */
        }else{
            System.out.println("That camp choice does not exist!");
            return true;
        }
        
        return true;
    }
    
    public int runViewCampListOut(ArrayList<Camp> campArray, User cookie){
        // Filtered array based on faculty info
        if(!checkCampValid(campArray, cookie)){
            System.out.println("No camps exist at the moment!");
            return -1;
        }else{
            System.out.println("Which camp would you like to view? ");
            //int campChoice = scanObj.nextInt();
                for(int i=1; i< campArray.size()+1; i++){
                    if((campArray.get(i-1).getVisiblility() == true && campArray.get(i-1).getFaculty().matches(cookie.getFacultyInfo()))){
                        countKeep.add(i);
                        System.out.println(countKeep.indexOf(i)+1+". Camp "+campArray.get(countKeep.indexOf(i)).getCampName()+" on display!");
                    }
                    
                }
                System.out.println("0. Exit Camp View");
                int getCampChoice = scanObj.nextInt();
                return getCampChoice;
        }
    }
    
    public boolean checkCampValid(ArrayList<Camp> campArray, User cookie){
        for(int i=1; i< campArray.size()+1; i++){
            if((campArray.get(i-1).getVisiblility() == true && campArray.get(i-1).getFaculty().matches(cookie.getFacultyInfo()))){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
        
}

