/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp;

import com.mycompany.cam_proj.App.CampApp.CampCreate.StaffCampCreate;
import com.mycompany.cam_proj.App.CampApp.CampEdit.StaffCampEdit;
import com.mycompany.cam_proj.App.CampApp.CampView.StaffCampView;
import com.mycompany.cam_proj.App.CampApp.CampDelete.DeleteCamp;
import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.Staff;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StaffCampApp implements CampApp{
    private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    public boolean runCampApp(ArrayList<Camp> campArray, User cookie){
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the camp subsection");
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. Modify Camp");
                System.out.println("2. View Camps");
                System.out.println("3. Remove Camp");
                System.out.println("4. Create Camp");

            int choose_camp = scan_obj.nextInt();
            switch(choose_camp){
                case 0:
                    loop_camp = false;
                    break;

                case 1:
                    StaffCampEdit staffEdit = new StaffCampEdit();
                    staffEdit.runEditCamp(campArray, cookie);
                    break;

                case 2:
                    StaffCampView staffView = new StaffCampView();
                    staffView.runViewCamp(campArray, cookie);
                    break;

                case 3:
                    DeleteCamp delCamp = new DeleteCamp();
                    delCamp.runDeleteCamp(campArray);
                    break;

                case 4:
                    StaffCampCreate staffCreate = new StaffCampCreate();
                    if(staffCreate.runCreateCamp(campArray, cookie)== false){
                        System.out.println("Camp was not successfully created!");
                    };
                    break;
            }
        }
        return false;
    }
}
