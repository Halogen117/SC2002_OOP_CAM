/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.App.CampApp.CampView.StudentCampView;
import com.mycompany.cam_proj.App.CampApp.CampRegister.StudentCampRegister;
import com.mycompany.cam_proj.App.CampApp.CampRegister.StudentCampUnregister;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentCampApp implements CampApp{
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    public boolean runCampApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the camp subsection");
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. View Camps");
                System.out.println("2. Register Camp");
                System.out.println("3. Unregister Camp");

            int choose_camp = scanObj.nextInt();
            switch(choose_camp){
                case 0:
                    loop_camp = false;
                    break;

                case 1:
                    StudentCampView studView = new StudentCampView();
                    studView.runViewCamp(campArray, cookie, scanObj);
                    break;
                
                case 2:
                    StudentCampRegister studReg = new StudentCampRegister();
                    studReg.runRegister(campArray, cookie);
                    break;

                case 3:
                    StudentCampUnregister studUnReg = new StudentCampUnregister();
                    studUnReg.runUnregister(campArray, cookie, scanObj);
                    break;
            }
        }
        return true;
    }
}
