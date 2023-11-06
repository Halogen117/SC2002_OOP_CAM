/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.DateFormatter;
import com.mycompany.cam_proj.Staff;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Login.Verification;
import com.mycompany.cam_proj.Student;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.mycompany.cam_proj.App.CampApp.CampCreate.StaffCampCreate;
/**
 *
 * @author Halogen
 */
public class testFunctionalities {
    public static void main(String[] args) {
        StaffCampCreate create = new StaffCampCreate();
        ArrayList<Camp> campArray = new ArrayList<Camp>();
        Staff cookie = new Staff("Hello", "email@gmail.com", "Singapore");
        create.runCreateCamp(campArray, cookie);
        
    }
}
