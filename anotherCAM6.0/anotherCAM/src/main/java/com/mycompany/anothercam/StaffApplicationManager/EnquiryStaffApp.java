package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.User;

public class EnquiryStaffApp {
    public boolean runEnquiryStaffApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){

        //ArrayList<Enquiry> enquiry = new ArrayList<>(); // create the array for enquiry
        
        EnquiryStaffMenuOptions menu = new EnquiryStaffMenuOptions();
   

        while (true) {
            System.out.println("=== Fancy Text-Based UI ===");
            System.out.println("1. View Enquiry");
            System.out.println("2. Reply to Enquiry");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanObj.nextInt();
            scanObj.nextLine();  // Consume the newline character

            switch (choice) {//Staff
                case 1 -> menu.view();
                case 2 -> menu.setStatus(scanObj);
                case 8 -> {
                    System.out.println("Goodbye!");
                    return true;
                }
                    
                default -> System.out.println("Invalid choice. Please try again.");
            }
            //Staff
            System.out.print("Press Enter to continue...");
        }
    }
}
   