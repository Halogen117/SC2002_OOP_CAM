/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cam_proj;
/**
 *
 * @author Halogen
 */
import java.util.Scanner;
import java.util.ArrayList;
public class CAM_Proj {

    public static void main(String[] args) {
        // Retrieve xlsx  file
        // Function to take in xlsx file and return the list array
        String file_location = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\student list.xlsx";
        read_excel re_ex = new read_excel();
        Student[] student_list = (Student[]) re_ex.return_list("Student", file_location);
        file_location = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\staff_list.xlsx";
        Staff[] staff_list = (Staff[]) re_ex.return_list("Staff", file_location);
        
        
        Authenticate auth = new Authenticate();
        int what_to_do;
        ArrayList<Camp> camp_array = new ArrayList<Camp>();
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
                    if(!auth.return_authenticate(student_list)){
                        System.out.println("Unverified Student! Try logging in again!");
                        break;
                    }
                    Student student_cookie = (Student) auth.get_user_cookie();
                    System.out.println("WELCOME STUDENT "+student_cookie.get_userID()+":");
                    System.out.println("1. Camp Subsection");
                    System.out.println("2. Change Password");
                    System.out.println("3. Log out!");
                    what_to_do = scan_obj.nextInt();
                    switch(what_to_do){
                        case 1:
                            CampApp camper = new CampApp(camp_array, student_cookie);
                            break;
                        case 2:
                            System.out.println("Please change your password!");
                            String change_password = scan_obj.next();
                            student_cookie.setPassword(change_password);
                            System.out.println("Password has been changed!");
                            break;
                        case 3:
                            if(auth.log_out()){
                                break;
                            }
                            break;
                    }
                    break;
                    
                case 2:
                    System.out.println("Running Staff!");
                    if(!auth.return_authenticate(staff_list)){
                        System.out.println("Unverified Staff! Try logging in again!");
                        break;
                    }
                    Staff staff_cookie = (Staff) auth.get_user_cookie();
                    System.out.println("WELCOME STAFF "+staff_cookie.get_userID()+":");
                    System.out.println("1. Camp Subsection");
                    System.out.println("2. Change Password");
                    System.out.println("3. Log out!");
                    what_to_do = scan_obj.nextInt();
                    
                    switch(what_to_do){
                        case 1:
                            CampApp camper = new CampApp(camp_array, staff_cookie);
                            break;
                        case 2:
                            System.out.println("Please change your password!");
                            String change_password = scan_obj.next();
                            staff_cookie.setPassword(change_password);
                            System.out.println("Password has been changed!");
                            break;
                        case 3:
                            if(auth.log_out()){
                                break;
                            }
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
