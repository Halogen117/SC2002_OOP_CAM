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
public class CAM_Proj {

    public static void main(String[] args) {
        // Retrieve xlsx  file
        // Function to take in xlsx file and return the list array
        ReadExcel re_ex = new ReadExcel();
        String studentFileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\student list.xlsx";
        ArrayList<User> studentList = re_ex.return_list("Student", studentFileLocation);

        String staffFileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\staff_list.xlsx";
        ArrayList<User> staffList = re_ex.return_list("Staff", staffFileLocation);
        /*
        for(User use : student_list){
            Student stud = (Student) use;
            System.out.println(stud.get_campCommittee());
        }
        */
        
        Authenticate auth = new Authenticate();
        int what_to_do;
        ArrayList<Camp> campArray = new ArrayList<Camp>();
        StaffLogin staffLogger  =new StaffLogin();
        StudentLogin studentLogger  =new StudentLogin();
        boolean run_loop = true;
        while(run_loop){
            System.out.println("==========WELCOME TO THE CAMP MANAGEMENT & APPLICATION SYSTEM==========");
            System.out.println("1. Login as a Student");
            System.out.println("2. Login as a Staff");
            System.out.println("3. Exit the program!");
            Scanner scan_obj = new Scanner(System.in);
            int take_input = scan_obj.nextInt();
            switch(take_input){
                case 1:
                    System.out.println("Running Student!");
                    if(studentLogger.runLogin(studentFileLocation, studentList)){
                        StudentApp stuApper = new StudentApp();
                        stuApper.runApp(campArray, studentLogger.getUserCookie());
                        studentLogger.studentLogOut();
                    }
                    break;
                    
                    
                case 2:
                    System.out.println("Running Staff!");
                    if(staffLogger.runLogin(staffFileLocation, staffList)){
                        StaffApp staffApper = new StaffApp();
                        staffApper.runApp(campArray, staffLogger.getUserCookie());
                        staffLogger.staffLogOut();
                    }
                    break;

                case 3:
                    run_loop = false;
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
                    
            }
        }

    
            
    }
    
}
