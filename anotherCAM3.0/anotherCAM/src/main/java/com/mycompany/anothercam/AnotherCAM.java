/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.anothercam;


import com.mycompany.anothercam.Login.*;
import com.mycompany.anothercam.StudentApplicationManager.StudentApp;
import com.mycompany.anothercam.StaffApplicationManager.StaffApp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

/**
 *
 * @author Halogen
 */
public class AnotherCAM {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        System.out.println("Hello World!");
        // Retrieve xlsx  file
        // Function to take in xlsx file and return the list array

        ReadExcel re_ex = new ReadExcel();
        Verification verifier = new Verification();
        String studentFileLocation = "C:\\Users\\k4oon\\OneDrive\\Pictures\\MH2000\\student_list.xlsx";
        re_ex.return_list("Student", studentFileLocation);

        String staffFileLocation = "C:\\Users\\k4oon\\OneDrive\\Pictures\\MH2000\\\staff_list.xlsx";
        re_ex.return_list("Staff", staffFileLocation);

        /*
        for(User use : student_list){
            Student stud = (Student) use;
            System.out.println(stud.get_campCommittee());
        }
        */ 
            //Scanner scan_obj = new Scanner(System.in);
        final String fileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2002 - Object Oriented Des & Prog\\anotherCAM\\input.txt";
        //final Scanner scanObj = new Scanner(new FileReader(fileLocation));
        final Scanner scanObj = new Scanner(System.in);
        ArrayList<Camp> campArray = new ArrayList<Camp>();
        StaffLogin staffLogger  =new StaffLogin();
        StudentLogin studentLogger  =new StudentLogin();
        boolean run_loop = true;
        while(run_loop){
            System.out.println("==========WELCOME TO THE CAMP MANAGEMENT & APPLICATION SYSTEM==========");
            System.out.println("0. Exit the program!");
            System.out.println("1. Login as a Student");
            System.out.println("2. Login as a Staff");
            
            int takeInput = verifier.verifyScannerNumber(scanObj);
            switch(takeInput){
                case 1:
                    System.out.println("Running Student!");
                    if(studentLogger.runLogin(studentFileLocation, scanObj)){
                        StudentApp stuApper = new StudentApp();
                        stuApper.runStudentApp(campArray, studentLogger.getUserCookie(), scanObj);
                        studentLogger.studentLogOut();
                    }
                    break;

                case 2:
                    System.out.println("Running Staff!");
                    if(staffLogger.runLogin(staffFileLocation, scanObj)){
                        StaffApp staffApper = new StaffApp();
                        staffApper.runApp(campArray, staffLogger.getUserCookie(), scanObj);
                        staffLogger.staffLogOut();
                    }
                    break;

                case 0:
                    run_loop = false;
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
                    
            }
        }
    }
}
