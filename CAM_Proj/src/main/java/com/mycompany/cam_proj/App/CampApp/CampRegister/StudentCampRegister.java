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
    private Scanner scanObj = new Scanner(System.in);
    public boolean runRegister(ArrayList<Camp> campArray, User cookie){
        if(campArray.isEmpty()){
            System.out.println("No camps to register for!");
            return false;
        }else{
            System.out.println("Register as a");
            System.out.println("0. Exit Application");
            System.out.println("1. Camp Attendee");
            System.out.println("2. Camp Committee Member");
            int choiceAttend = scanObj.nextInt();
            if(choiceAttend == 0){
                return false;
            }
            System.out.println("Which camp would you like to register?");
            StudentCampView studView = new StudentCampView();
            
            int choice = studView.runViewCampListOut(campArray, cookie);
            if(choice < 0 || choice > campArray.size()){
                System.out.println("Choice outside of input! Exiting Registration!");
                return false;
            }
            System.out.println("Are you sure you want to register for Camp "+campArray.get(choice-1).getCampName()+"?");
            String yes_no = scanObj.next();
            
            if(yes_no.equals("Y") || yes_no.equals("YES")){
                // Check if student registered for other camps
                // Check if camp is full
                if(checkCampFull()){
                    System.out.println("Camp is already full!");
                
                }
                

                if(choiceAttend == 1){
                    
                }else if(choiceAttend == 2){
                    // Check if camp Committee
                    if(checkCampCommittee((Student) cookie)){
                        System.out.println("Students are capped at 1 camp committee member at the max!");
                    }else{
                        setCampCommittee((Student) cookie);
                    }
                }

                campArray.get(choice-1).addStudentToList((Student) cookie);
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
    
    public boolean checkCampFull(){
        // Check if the camp is full
        return true;
    }

    public void setCampCommittee(Student Stud){
        Stud.setCampCommittee(true);
        System.out.println("Successfully set as Camp Committee Member!");
    }
}
