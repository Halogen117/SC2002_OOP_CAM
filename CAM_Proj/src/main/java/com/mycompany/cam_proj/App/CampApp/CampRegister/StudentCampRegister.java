/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp.CampRegister;
import com.mycompany.cam_proj.App.CampApp.CampView.StudentCampView;
import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Student;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.cam_proj.DateFormatter;

/**
 *
 * @author Halogen
 */
public class StudentCampRegister {
    //private Scanner scanObj = new Scanner(System.in);
    public boolean runRegister(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        if(campArray.isEmpty()){
            System.out.println("No camps to register for!");
            return false;
        }else{
            System.out.println("Register as a");
            System.out.println("0. Exit Register Main Menu");
            System.out.println("1. Camp Attendee");
            System.out.println("2. Camp Committee Member");
            int choiceAttend = scanObj.nextInt();
            if(choiceAttend == 0){
                return false;
            }
            System.out.println("Which camp would you like to register?");
            StudentCampView studView = new StudentCampView();
            
            ArrayList<Integer> choice = studView.runViewCampListOut(campArray, cookie);
            int chooseChoice = scanObj.nextInt();
            if(choice == null){
                System.out.print("No Camps exist at the moment!");
                return true;
            }else if(!choice.contains(chooseChoice)){
                System.out.println("Choice outside of input! Exiting Register Main Menu");
                return false;
            }
            System.out.println("Are you sure you want to register for Camp "+campArray.get(chooseChoice-1).getCampName()+"? (Y/N)");
            String yes_no = scanObj.next();
            
            if(yes_no.equals("Y") || yes_no.equals("YES")){
                // Check if student registered for other camps
                if(checkDateClash(choice, campArray,chooseChoice, (Student) cookie)){
                    return false;
                }
                // Check if camp is full
                if(checkCampFull(campArray, chooseChoice)){
                    System.out.println("Camp is already full!");
                    return false;
                }else if(checkAttendeeList(choice, campArray, (Student) cookie, chooseChoice) && choiceAttend == 1){
                    System.out.println("You are already an attendee in the camp!");
                }

                if(choiceAttend == 1){
                    campArray.get(chooseChoice-1).addStudentToList((Student) cookie);
                }else if(choiceAttend == 2){
                    // Check if camp Committee
                    if(checkCampCommittee((Student) cookie)){
                        System.out.println("Students are capped at 1 camp committee member at the max!");
                    }else{
                        if(!checkAttendeeList(choice, campArray, (Student) cookie, chooseChoice)){
                            campArray.get(chooseChoice-1).addStudentToList((Student) cookie);
                        }
                            setCampCommittee((Student) cookie, campArray.get(chooseChoice -1).getCampName());
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
    
    public boolean checkCampCommittee(Student Stud){
        return Stud.getCampCommittee();
    }
    
    public boolean checkCampFull(ArrayList<Camp> campArray, int chooseChoice){
        // Check if the camp is full
        if(campArray.get(chooseChoice-1).getTotalSlot() >= campArray.get(chooseChoice-1).getCampStudentList().size()){
            return false;
        }
        return true;
    }

    public void setCampCommittee(Student Stud, String campName){
        Stud.setCampCommittee(true);
        Stud.setCampCommitteeName(campName);
        System.out.println("Successfully set as Camp Committee Member!");
    }
    
    public boolean checkAttendeeList(ArrayList<Integer> choice, ArrayList<Camp> campArray, Student Stud, int chooseChoice){

            if(campArray.get(choice.indexOf(chooseChoice)).getCampStudentList().contains(Stud)){
                return true;
            
        }
        return false;
    }
    
    public boolean checkDateClash(ArrayList<Integer> choice, ArrayList<Camp> campArray , int chooseChoice, Student Stud){
        // Check for the camps the student is in, if got date clash (Same day)
        DateFormatter formaDat  =new DateFormatter();
        /*
        for(int i =0; i< choice.size(); i++){
            if(formaDat.clashDates(campArray.get(i).getDate(), campArray.get(choice.get(chooseChoice-1)).getDate())){
                return true;
            }
        }
        
        return false;
        
        
        */  
        return false;
    }
}
