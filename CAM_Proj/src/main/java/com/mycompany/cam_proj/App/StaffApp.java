/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App;

import com.mycompany.cam_proj.App.CampApp.StaffCampApp;
import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.DateFormatter;
import com.mycompany.cam_proj.Staff;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Login.Verification;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StaffApp implements App {
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    
    public boolean runApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loopCont = true;
        while(loopCont){
            System.out.println("WELCOME STAFF "+cookie.getUserID()+":");
            System.out.println("1. Camp Subsection");
            // Enquiry
            // Suggestion
            // Generate report
            System.out.println("2. Change Password");
            System.out.println("0. Log out!");
            int what_to_do = scanObj.nextInt();
            switch(what_to_do){
                case 1:
                    StaffCampApp staffCamper = new StaffCampApp();
                    staffCamper.runCampApp(campArray, cookie, scanObj);
                    break;
                case 2:
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
    /*
    public boolean exit_camp(){
        return true;
    }
    
    public boolean signup_camp(){
        return true;
    }
    */
}
