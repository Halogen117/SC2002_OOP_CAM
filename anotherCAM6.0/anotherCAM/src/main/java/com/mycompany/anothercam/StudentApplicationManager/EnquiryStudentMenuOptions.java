package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.implementActions.ViewEditDelete;
//import com.mycompany.cam_proj.App.EnquiryApp.EnquiryList;
import com.mycompany.anothercam.StudentApplicationManager.StudentCampView;

import java.util.ArrayList;
import java.util.Scanner;

public class EnquiryStudentMenuOptions implements ViewEditDelete {
    private Verification veri = new Verification();
    private EnquiryList enquiryList;

    public EnquiryStudentMenuOptions(EnquiryList enquiryList) {
        this.enquiryList= enquiryList;
    }

    public void Addenquiry(ArrayList<Camp> campArray, Student cookie, Scanner scanObj) {
        System.out.println("You selected Submit enquiry.");

        for(int i=1; i< campArray.size()+1; i++){
            // Visibility to entire camp or only to faculty
                System.out.println(i+1+". "+campArray.get(i-1).getCampName());      
        }
        System.out.println("0. Exit Edit Camp Main Menu");
        int chooseChoice = veri.verifyScannerNumber(scanObj);
        System.out.println("Please add your description");
        String description =  scanObj.nextLine();
        Enquiry enquiry = new Enquiry(campArray.get(chooseChoice-1).getCampID(), description, cookie);
        enquiryList.addEnquiry(enquiry);
    }

    private void showEnquiryForStudent(User student) {
        System.out.println("You selected Show Enquiries:");
        enquiryList.viewEnquiryStudent(student);
    }

    public void showEnquirymini(User student) {
        System.out.println("You selected Show Enquiries:");
        enquiryList.viewEnquiryStudentmini(student);
    }

    //EDITING NOW 

    @Override
    public boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        showEnquiryForStudent(cookie);
        return false;
    }

    public boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Edit Enquiries.");

        boolean exitRequested = false;

        do {
            System.out.println("=== Enquiry EDIT UI ===");
            System.out.println("1. Edit Description");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Consume the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    int enquiryID;
                    //showEnquirysmini(cookie);
                    System.out.println("=====================================");
                    System.out.println("Which Enquiry do you want to edit");
                    System.out.println("=====================================");
                    enquiryID = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    //enquiryList.editEnquiryDescription(enquiryID, cookie.getUserID());
                    exitRequested = true;  // Set the flag to exit the loop
                    break;
                case 8:
                    exitRequested = true;  // Set the flag to exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!exitRequested);

        return false;
    }



    @Override
    public boolean runDelete(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        int thechosenone;
        //showEnquirysmini(cookie);
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Delete Enquiry:");
        System.out.println("Which Enquiry do you want to delete");
        thechosenone = scanner.nextInt();
        enquiryList.deleteEnquiryByID(thechosenone, cookie);
        return false;
    }
}