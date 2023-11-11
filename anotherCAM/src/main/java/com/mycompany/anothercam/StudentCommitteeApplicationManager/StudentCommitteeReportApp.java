/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentCommitteeReportApp {
public boolean runStaffReportApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the Report Subsection");
            System.out.println("0. Exit Camp Interface");
            System.out.println("1. Generate Camp Committee Report");

            int chooseReport = scanObj.nextInt();
            switch(chooseReport){
                case 0:
                    loop_camp = false;
                    break;

                case 1:
                    CampCommitteeReport campReport = new CampCommitteeReport();
                    campReport.runStudentCommitteeReport(campArray, cookie, scanObj);
                    break;
            }
        }
        return false;
    } 
}
