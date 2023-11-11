/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Halogen
 */
public class StaffReportApp {
    public boolean runStaffReportApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj) throws IOException{
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the report subsection");
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. Generate Report");
                System.out.println("2. Generate Performance Report Camps");
                System.out.println("3. Remove Camp");
                System.out.println("4. Create Camp");

            int chooseReport = scanObj.nextInt();
            switch(chooseReport){
                case 0:
                    loop_camp = false;
                    break;

                case 1:
                    StaffReport staffRepo = new StaffReport();
                    staffRepo.runStaffReportCamp(campArray, cookie, scanObj);
                    break;

                case 2:
                    StaffPerformanceReport staffPerRep = new StaffPerformanceReport();
                    
                    staffPerRep.runStaffPerformanceReport(campArray, cookie, scanObj);
                    //staffView.runStaffViewCamp(campArray, cookie, scanObj);
                    break;

                case 3:
                    //StaffDeleteCamp delCamp = new StaffDeleteCamp();
                    //delCamp.runStaffDeleteCamp(campArray, cookie);
                    break;

                case 4:
                    //StaffCampCreate staffCreate = new StaffCampCreate();
                    //if(staffCreate.runStaffCreateCamp(campArray, cookie, scanObj)== false){
                        //System.out.println("Camp was not successfully created!");
                    //};
                    break;
            }
        }
        return false;
    }
}
