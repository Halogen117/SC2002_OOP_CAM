package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;

import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.User;

/**
Represents the Enquiry Staff Application Object and the following assistance methods.
An Enquiry Staff Application object can be called multiple times. 
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-5
*/
public class EnquiryStaffApp {

    /**
     * Runs the Staff Enquiry Application Submenu
     * @param campArray The entire ArrayList of camps that exist in the application
     * @param cookie User cookie that stores the Staff object.
     * @param scanObj Scanner Object used to pass inputs into.
     * @return the boolean value to check if the enquiry staff app ran succcessfully.
     */
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
   