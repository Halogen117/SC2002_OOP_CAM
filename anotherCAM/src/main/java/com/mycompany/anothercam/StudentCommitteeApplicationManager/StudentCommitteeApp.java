/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.StudentApplicationManager.StudentCampApp;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Staff;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.Student;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentCommitteeApp {
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    
    public boolean runApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
boolean loopCont = true;
        while(loopCont){
            System.out.println("WELCOME STUDENT COMMITTEE MEMBER "+cookie.getUserID()+":");
            System.out.println("1. Camp Subsection");
            // Enquiry
            System.out.println("2. Enquiry Subsection");
            // Suggestion
            System.out.println("3. Suggestion Subsection");
            // Generate report
            System.out.println("4. Report Subsection");
            
            System.out.println("5. Change Password");
            
            System.out.println("0. Log out!");
            int what_to_do = scanObj.nextInt();
            switch(what_to_do){
                case 1:
                    StudentCampApp studentCamper = new StudentCampApp();
                    studentCamper.runStudentCampApp(campArray, cookie, scanObj);
                    break;
                case 2:
                    break;
                    
                case 4:
                    StudentCommitteeReportApp studComRep = new StudentCommitteeReportApp();
                    studComRep.runStaffReportApp(campArray, cookie, scanObj);
                    break;
                    
                case 5:
                    System.out.println("Please change your password!");
                    String change_password = scanObj.next();
                    cookie.setPassword(change_password);
                    System.out.println("Password has been changed!");
                    System.out.println("Logging out due to password change!");
                    loopCont = false;
                    break;
                
                case 6:
                    break;

                case 0:
                    loopCont = false;
                    break;
                }
        }
        return true;
    }
}
