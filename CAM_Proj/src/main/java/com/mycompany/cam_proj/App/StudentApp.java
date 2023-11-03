/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.DateFormatter;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Login.Verification;
import com.mycompany.cam_proj.App.CampApp.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentApp implements App {
    private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    
    public boolean runApp(ArrayList<Camp> campArray, User cookie){
        boolean loopCont = true;
        while(loopCont){
            System.out.println("WELCOME STUDENT "+cookie.getUserID()+":");
            System.out.println("1. Camp Subsection");
            // Enquiry
            // Suggestion
            // Generate report
            System.out.println("2. Change Password");
            System.out.println("0. Log out!");
            int what_to_do = scan_obj.nextInt();
            switch(what_to_do){
                case 1:
                    StudentCampApp studentCamper = new StudentCampApp();
                    studentCamper.runCampApp(campArray, cookie);
                    break;
                case 2:
                    System.out.println("Please change your password!");
                    String change_password = scan_obj.next();
                    cookie.setPassword(change_password);
                    System.out.println("Password has been changed!");
                    break;
                case 0:
                    loopCont = false;
                    break;
                }
        }
        return true;
    }
}
