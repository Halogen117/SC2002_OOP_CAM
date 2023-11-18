package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.User;

public class EnquiryStudentApp {
    public boolean runEnquiryStudentApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj) {
       EnquiryList enquiryList = new EnquiryList();
       EnquiryStudentMenuOptions menu = new EnquiryStudentMenuOptions(enquiryList);


        while (true) {
            System.out.println("=== Enquiry UI ===");
            System.out.println("0. Exit");
            System.out.println("1. Submit Enquiry");
            System.out.println("2. View Enquiry");
            System.out.println("3. Delete Enquiry");
            System.out.println("4. Edit Enquiry");
            System.out.print("Enter your choice: ");

            int choice = scanObj.nextInt();
            scanObj.nextLine();  // Consume the newline character

            switch (choice) {
                case 1 -> menu.Addenquiry(campArray,cookie);
                case 2 -> menu.runView(campArray,cookie,scanObj);
                case 3 -> menu.runDelete(campArray,cookie,scanObj);
                case 4 -> menu.runEdit(campArray,cookie,scanObj);
                case 0 -> {
                    System.out.println("Goodbye!");
                    return true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("Press Enter to continue...");
            scanObj.nextLine();
        }
    }
}