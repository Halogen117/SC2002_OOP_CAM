/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StaffApplicationManager;


import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Staff;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Login.Verification;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Halogen
 */
public class StaffApp{
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    
    public boolean runApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj) throws IOException{
        boolean loopCont = true;
        while(loopCont){
            if(cookie == null){
                loopCont = false;
                break;
            }
            System.out.println("WELCOME STAFF "+cookie.getUserID()+":");
            System.out.println("1. Camp Subsection");
            System.out.println("2. Enquiry Subsection");
            // Suggestion
            System.out.println("3. Suggestion Subsection");

            System.out.println("4. Access Status Subsection");
            
            System.out.println("5. Report Subsection");
            
            System.out.println("6. Change Password");
            System.out.println("0. Log out!");
            int what_to_do = scanObj.nextInt();
            switch(what_to_do){
                case 1:
                    StaffCampApp staffCamper = new StaffCampApp();
                    staffCamper.runStaffCampApp(campArray, cookie, scanObj);
                    break;
                    
                case 4:
                    System.out.println("Accessing Student Status Subsection!");
                    StaffStatusApp statStaff = new StaffStatusApp();
                    statStaff.runStaffStatusApp(campArray, cookie,scanObj);
                
                case 5:
                    System.out.println("Accessing Report Subsection!");
                    StaffReportApp repoApp = new StaffReportApp();
                    repoApp.runStaffReportApp(campArray, cookie, scanObj);
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
    /*
    public boolean exit_camp(){
        return true;
    }
    
    public boolean signup_camp(){
        return true;
    }
    */
}
