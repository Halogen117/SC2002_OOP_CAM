package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import java.util.ArrayList;
import java.util.Scanner;

import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.Login.Verification;

/**
 View Enquiry Student Application
 Allow the student to View the enquries.
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-11
 */
public class EnquiryStudentApp {

    /**
     * Runs the Student Enquiry Application.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the Student Object.
     * @param scanObj stores the Scanner Object to pass inputs into.
     * @return
     */
    public boolean runEnquiryStudentApp(ArrayList<Camp> campArray, Student cookie, Scanner scanObj) {
       EnquiryList enquiryList = new EnquiryList();
       EnquiryStudentMenuOptions menu = new EnquiryStudentMenuOptions(enquiryList);
       Verification veri = new Verification();


        while (true) {
            System.out.println("=== Enquiry UI ===");
            System.out.println("0. Exit");
            System.out.println("1. Submit Enquiry");
            System.out.println("2. View Enquiry");
            System.out.println("3. Delete Enquiry");
            System.out.println("4. Edit Enquiry");
            //System.out.print("Enter your choice: ");

            int choice = veri.verifyScannerNumber(scanObj);

            switch (choice) {
                case 1 -> menu.AddEnquiry(campArray,cookie, scanObj);
                case 2 -> menu.runView(campArray,cookie,scanObj);
                case 3 -> menu.runDelete(campArray,cookie,scanObj);
                case 4 -> menu.runEdit(campArray,cookie,scanObj);
                case 0 -> {
                    System.out.println("Goodbye!");
                    return true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}