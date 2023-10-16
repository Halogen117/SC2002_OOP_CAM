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
public class CAM_Proj {

    public static void main(String[] args) {
        // Retrieve xlsx  file
        // Function to take in xlsx file and return the list array
        //
        String file_location = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\student list.xlsx";
        read_excel re_ex = new read_excel();
        Student[] student_list = (Student[]) re_ex.return_list("Student", file_location);
        file_location = "C:\\Users\\Halogen\\Desktop\\Year 2\\Semester 1\\SC2006 - Software Engineering\\CAM_Proj\\src\\main\\resources\\staff_list.xlsx";
        Staff[] staff_list = (Staff[]) re_ex.return_list("Staff", file_location);
        
        
        Authenticate auth = new Authenticate();

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
                    }
                    break;
                case 2:
                    System.out.println("Running Staff!");
                    if(!auth.return_authenticate(staff_list)){
                        System.out.println("Unverified Staff! Try logging in again!");
                    }
                    break;
                case 3:
                    run_loop = false;
                    break;
                default:
                    run_loop = false;
                    break;
                    
            }
        }


            
    }
    
}
