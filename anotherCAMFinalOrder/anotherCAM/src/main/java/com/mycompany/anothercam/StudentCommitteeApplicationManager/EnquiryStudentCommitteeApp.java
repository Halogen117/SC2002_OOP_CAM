package com.mycompany.anothercam.StudentCommitteeApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.StudentApplicationManager.EnquiryStudentMenuOptions;
import java.util.ArrayList;
import java.util.Scanner;

public class EnquiryStudentCommitteeApp {

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
                    menu.runReply(scanObj);
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

