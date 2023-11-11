/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentCampApp{
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    public boolean runStudentCampApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loopCamp = true;
        while(loopCamp){
            if(cookie == null){
                loopCamp = false;
                break;
            }
            System.out.println("Welcome to the camp subsection");
            System.out.println("0. Exit Camp Interface");
            System.out.println("1. View Camps");
            System.out.println("2. Register Camp");
            System.out.println("3. Unregister Camp");

            int chooseCamp = scanObj.nextInt();
            switch(chooseCamp){
                case 0:
                    loopCamp = false;
                    break;

                case 1:
                    StudentCampView studView = new StudentCampView();
                    studView.runStudentViewCamp(campArray, cookie, scanObj);
                    break;
                
                case 2:
                    StudentCampRegister studReg = new StudentCampRegister();
                    studReg.runStudentRegister(campArray, cookie, scanObj);
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
