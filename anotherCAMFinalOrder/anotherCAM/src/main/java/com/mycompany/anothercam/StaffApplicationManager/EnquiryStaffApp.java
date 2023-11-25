package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;

import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.User;

public class EnquiryStaffApp {
    public boolean runEnquiryStaffApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        Verification veri = new Verification();
        //ArrayList<Enquiry> enquiry = new ArrayList<>(); // create the array for enquiry
        EnquiryList enquiryList = new EnquiryList();
        EnquiryStaffMenuOptions menu = new EnquiryStaffMenuOptions(enquiryList);


        while (true) {
            System.out.println("=== Enquiry UI ===");
            System.out.println("1. View Enquiry");
            System.out.println("2. Reply to Enquiry");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = veri.verifyScannerNumber(scanObj);
            switch (choice) {//Staff
                case 1 -> menu.runView(campArray,cookie,scanObj);
                case 2 -> menu.runReply(scanObj, cookie, campArray);
                case 0 -> {
                    System.out.println("Goodbye!");
                    return true;

                }
                    
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
   