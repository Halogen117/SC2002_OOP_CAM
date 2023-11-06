/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cam_proj;
/**
 *
 * @author Halogen
 */
import com.mycompany.cam_proj.Login.Authenticate;
import java.util.Scanner;
import java.util.ArrayList;
import com.mycompany.cam_proj.Login.*;
import com.mycompany.cam_proj.App.*;
import com.mycompany.cam_proj.compiledLists.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class CAM_Proj {

        
        //Scanner scan_obj = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        // Retrieve xlsx  file
        // Function to take in xlsx file and return the list array

        ReadExcel re_ex = new ReadExcel();
        
        String studentFileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\student list.xlsx";
        re_ex.return_list("Student", studentFileLocation);

        String staffFileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\staff_list.xlsx";
        re_ex.return_list("Staff", staffFileLocation);

        /*
        for(User use : student_list){
            Student stud = (Student) use;
            System.out.println(stud.get_campCommittee());
        }
        */ 
            //Scanner scan_obj = new Scanner(System.in);
        final String fileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\input.txt";
        final Scanner scanObj = new Scanner(new FileReader(fileLocation));
        //final Scanner scanObj = new Scanner(System.in);
        ArrayList<Camp> campArray = new ArrayList<Camp>();
        StaffLogin staffLogger  =new StaffLogin();
        StudentLogin studentLogger  =new StudentLogin();
        boolean run_loop = true;
        while(run_loop){
            System.out.println("==========WELCOME TO THE CAMP MANAGEMENT & APPLICATION SYSTEM==========");
            System.out.println("0. Exit the program!");
            System.out.println("1. Login as a Student");
            System.out.println("2. Login as a Staff");
            
            int take_input = scanObj.nextInt();
            switch(take_input){
                case 1:
                    System.out.println("Running Student!");
                    if(studentLogger.runLogin(studentFileLocation, scanObj)){
                        StudentApp stuApper = new StudentApp();
                        stuApper.runApp(campArray, studentLogger.getUserCookie(), scanObj);
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
