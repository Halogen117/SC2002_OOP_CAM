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
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.cam_proj.App.CampApp.CampCreate.StaffCampCreate;
/**
 *
 * @author Halogen
 */
public class testFunctionalities {
    public static void main(String[] args) throws FileNotFoundException {
        //StaffCampCreate create = new StaffCampCreate();
        //ArrayList<Camp> campArray = new ArrayList<Camp>();
        //Staff cookie = new Staff("Hello", "email@gmail.com", "Singapore");
        //create.runCreateCamp(campArray, cookie);
        Scanner inFile = new Scanner(new FileReader("C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\input.txt"));
        double hours;
        double pay;
        
        hours = inFile.nextInt();
        pay = inFile.nextInt();
        double earned = hours * pay;
        
        System.out.println(earned);
    
    }   
}
