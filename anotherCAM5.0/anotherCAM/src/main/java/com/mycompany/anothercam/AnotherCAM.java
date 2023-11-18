/**
Represents the main method where the entirety of the app will be run by.
A AnotherCam is ran dependent on how many users are going to start up the application.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-15
*/
package com.mycompany.anothercam;
import com.mycompany.anothercam.Login.*;
import com.mycompany.anothercam.StudentApplicationManager.StudentApp;
import com.mycompany.anothercam.StaffApplicationManager.StaffApp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnotherCAM {

        /**
    * Runs the main method to run the code
    * @param args which are the arguments that are taken into the application.
    */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // Retrieve xlsx  file
        // Function to take in xlsx file and return the list array

        ReadExcel re_ex = new ReadExcel();
        Verification verifier = new Verification();
        String studentFileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2002 - Object Oriented Des & Prog\\anotherCAM\\src\\main\\resources\\student_list.xlsx";
        re_ex.return_list("Student", studentFileLocation);

        String staffFileLocation = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2002 - Object Oriented Des & Prog\\anotherCAM\\src\\main\\resources\\staff_list.xlsx";
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
