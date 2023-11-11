/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.StaffApplicationManager;


import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Staff;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StaffCampApp{
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    public boolean runStaffCampApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the camp subsection");
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. Modify Camp");
                System.out.println("2. View Camps");
                System.out.println("3. Remove Camp");
                System.out.println("4. Create Camp");

            int choose_camp = scanObj.nextInt();
            switch(choose_camp){
                case 0:
                    loop_camp = false;
                    break;

                case 1:
                    StaffCampEdit staffEdit = new StaffCampEdit();
                    staffEdit.runStaffEditCamp(campArray, cookie);
                    break;

                case 2:
                    StaffCampView staffView = new StaffCampView();
                    staffView.runStaffViewCamp(campArray, cookie, scanObj);
                    break;

                case 3:
                    StaffDeleteCamp delCamp = new StaffDeleteCamp();
                    delCamp.runStaffDeleteCamp(campArray, cookie,scanObj);
                    break;

                case 4:
                    StaffCampCreate staffCreate = new StaffCampCreate();
                    if(staffCreate.runStaffCreateCamp(campArray, cookie, scanObj)== false){
                        System.out.println("Camp was not successfully created!");
                    };
                    break;
            }
        }
        return false;
    }
}
