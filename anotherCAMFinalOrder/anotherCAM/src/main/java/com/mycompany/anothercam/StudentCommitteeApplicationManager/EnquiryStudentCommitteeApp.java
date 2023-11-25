package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 Runs the Student Committee App function and the following assistance methods.
 Allows the camp committee member to access the student committee application.
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-10
 */
public class EnquiryStudentCommitteeApp {

    /**
     * Runs the Enquiry Application for the Camp Committee Member.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the Student Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return boolean value to check if the app ran successfully. True for success. False for unsuccessful.
     */
    public boolean runEnquiryStudentCommitteeApp(ArrayList<Camp> campArray, Student cookie, Scanner scanObj) {
        EnquiryList enquiryList = new EnquiryList();
        EnquiryStudentCommitteeMenuOptions menu = new EnquiryStudentCommitteeMenuOptions(enquiryList);
        Verification veri = new Verification();


        while (true) {
            System.out.println("=== Enquiry UI ===");
            System.out.println("0. Exit");
            System.out.println("1. View Enquiry");
            System.out.println("2. Reply Enquiry");

            int choice = veri.verifyScannerNumber(scanObj);

            switch (choice) {
                case 1 -> menu.runView(campArray,cookie,scanObj);
                case 2 -> {
                    menu.runReply(scanObj, cookie, campArray);
                    cookie.incrementPoint();

                }
                case 0 -> {
                    System.out.println("Goodbye!");
                    return true;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

