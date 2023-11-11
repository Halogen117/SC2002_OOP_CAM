/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentStatusApp{
    public boolean runStudentStatusApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
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

            for(int i=1; i< campArray.size()+1; i++){
                //if((campArray.get(i-1).getFaculty().equals(cookieStud.getFacultyInfo()))&& campArray.get(i-1).getCampStudentList().get(cookieStud)){
                if(campArray.get(i-1).getCampCommitteeList().contains(cookieStud)){
                    
                    System.out.println(i+". "+campArray.get(i-1).getCampName()+" (Committee Member)");
                }else if(campArray.get(i-1).getCampStudentList().contains(cookieStud)){
                    System.out.println(i+". "+campArray.get(i-1).getCampName()+" (Attendee)");
                }
                
            }
        return true;
    }
}
