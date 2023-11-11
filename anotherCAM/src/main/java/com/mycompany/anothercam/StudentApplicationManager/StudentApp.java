/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.StudentCommitteeApplicationManager.StudentCommitteeApp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentApp{
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    
    public boolean runStudentApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loopCont = true;
        while(loopCont){
            if(cookie == null){
                loopCont = false;
                break;
            }
            System.out.println("WELCOME STUDENT "+cookie.getUserID()+":");
            System.out.println("1. Camp Subsection");
            // Enquiry
            System.out.println("2. Enquiry Subsection");
            // Suggestion
            System.out.println("3. Suggestion Subsection");

            System.out.println("4. Access Status Subsection");
            
            System.out.println("5. Access Student Committee Menu Sublist");
            
            System.out.println("6. Change Password");
            System.out.println("0. Log out!");
            int what_to_do = scanObj.nextInt();
            switch(what_to_do){
                case 1:
                    StudentCampApp studentCamper = new StudentCampApp();
                    studentCamper.runStudentCampApp(campArray, cookie, scanObj);
                    break;
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    System.out.println("Accessing Student Status Subsection!");
                    StudentStatusApp statStud = new StudentStatusApp();
                    statStud.runStudentStatusApp(campArray, cookie,scanObj);
                    break;
                    
                case 5:
                    System.out.println("Attempting to access Student Committee Main Menu");
                    if(checkCommitteeMember((Student) cookie)){
                        StudentCommitteeApp commiApp = new StudentCommitteeApp();
                        commiApp.runApp(campArray, cookie, scanObj);
                    }else{
                        System.out.println("You are not a Student Committee Member!");
                    }
                    break;

                case 6:
                    System.out.println("Please change your password!");
                    String change_password = scanObj.next();
                    cookie.setPassword(change_password);
                    System.out.println("Password has been changed!");
                    System.out.println("Logging out due to password change!");
                    loopCont = false;
                    break;
                case 0:
                    loopCont = false;
                    break;
                }
        }
        return true;
    }
    
    public boolean checkCommitteeMember(Student stud){
        return stud.getCampCommittee();
    }
}
