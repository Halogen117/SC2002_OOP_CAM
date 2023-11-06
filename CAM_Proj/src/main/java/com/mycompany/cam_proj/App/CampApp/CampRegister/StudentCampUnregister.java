/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp.CampRegister;

import com.mycompany.cam_proj.App.CampApp.CampView.StudentCampView;
import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.Student;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentCampUnregister {
    private Scanner scanObj = new Scanner(System.in);
    public boolean runUnregister(ArrayList<Camp> campArray, User cookie){
        if(campArray.isEmpty()){
            System.out.println("No camps to register for!");
            return false;
        }else{
            System.out.println("We are sorry to see you go :( .");
            System.out.println("Unregister as a");
            System.out.println("0. Exit Unregister Main Menu");
            System.out.println("1. Camp Attendee");
            System.out.println("2. Camp Committee Member");
            int choiceUnAttend = scanObj.nextInt();
            if(choiceUnAttend == 0){
                return false;
            }
            System.out.println("Which camp would you like to unregister?");
            StudentCampView studView = new StudentCampView();
            
            ArrayList<Integer> choice = studView.runViewCampListOut(campArray, cookie);
            int chooseChoice = this.scanObj.nextInt();
            if(choice == null){
                System.out.print("No Camps exist at the moment!");
                return true;
            }else if(!choice.contains(chooseChoice)){
                System.out.println("Choice outside of input! Exiting Unregister Main Menu!");
                return false;
            }
            System.out.println("Are you sure you want to register for Camp "+campArray.get(chooseChoice-1).getCampName()+"? (Y/N)");
            String yes_no = scanObj.next();
            
            if(yes_no.equals("Y") || yes_no.equals("YES")){
                // Check if student registered for other camps
                // Check if camp is full
                if(checkCampEmpty(campArray, chooseChoice)){
                    System.out.println("Camp is already empty!");
                    return false;
                }else if(checkAttendeeList(campArray, (Student) cookie) && choiceUnAttend == 1){
                    System.out.println("You are not an attendee in the camp!");
                    return false;
                }
                // This should be repurposed to remove the student if the request is successful
                if(choiceUnAttend == 1){
                    campArray.get(chooseChoice-1).removeStudentToList((Student) cookie);
                }else if(choiceUnAttend == 2){
                    // Check if camp Committee
                    if(!checkCampCommitteeRemove((Student) cookie, campArray, chooseChoice)){
                        System.out.println("You are not a camp committee member in this camp!");
                        return false;
                    }else{
                        if(!checkAttendeeList(campArray, (Student) cookie)){
                            campArray.get(chooseChoice-1).addStudentToList((Student) cookie);
                        }
                            removeCampCommittee((Student) cookie);
                            campArray.get(chooseChoice-1).addCampCommitteeMemberToList((Student) cookie); 
                    }
                }

                
            }else if(yes_no.equals("N") || yes_no.equals("NO")){
                System.out.println("Exiting Register option!");
                return false;
            }
            return true;
        }
    }
    
    public boolean checkCampEmpty(ArrayList<Camp> campArray, int chooseChoice){
        // Check if the camp is full
        if(campArray.get(chooseChoice-1).getCampStudentList().size() == 0 && campArray.get(chooseChoice-1).getCampCommitteeSlots().size() == 0){
            return true;
        }
        return false;

    }
    
    public boolean checkAttendeeList(ArrayList<Camp> campArray, Student Stud){
        for(int i=1; i<campArray.size(); i++){
            if(campArray.get(i-1).getCampStudentList().contains(Stud)){
                return false;
            }
        }
        return true;
    }
    
    public void removeCampCommittee(Student Stud){
        Stud.setCampCommittee(false);
        System.out.println("Successfully removed as Camp Committee Member!");
    }
    
    public boolean checkCampCommitteeRemove(Student Stud, ArrayList<Camp> campArray, int chooseChoice){
        // If camp Committee matches name of 
        if(Stud.getCampCommitteeName() == campArray.get(chooseChoice-1).getCampName()){
            return true;
        }
        return false;
        
    }
}
