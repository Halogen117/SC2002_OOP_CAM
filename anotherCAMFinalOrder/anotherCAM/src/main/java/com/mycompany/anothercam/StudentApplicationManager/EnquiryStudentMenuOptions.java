package com.mycompany.anothercam.StudentApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.EnquiryList;
import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.implementActions.ViewEditDelete;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnquiryStudentMenuOptions implements ViewEditDelete {      //create subinterfaces!! enquiry doesnt delete
    private Verification veri = new Verification();

    private EnquiryList enquiryList;
    private int choice;

    public EnquiryStudentMenuOptions(EnquiryList enquiryList) {
        this.enquiryList= enquiryList;
    }

    public void AddEnquiry(ArrayList<Camp> campArray, Student cookie, Scanner scanObj) {
        System.out.println("You selected Submit enquiry.");

        //Display available camps
        System.out.println("Available Camps:");
        for(int i=1; i< campArray.size()+1; i++){
            // Visibility to entire camp or only to faculty
            // Staff make it private but student can see
            // Solution is to only see faculty and everyone
                System.out.println(i+". "+campArray.get(i-1).getCampName());
        }
        //Prompt user to select camp
        System.out.println("Select a camp for your inquiry: ");
        int chooseChoice = veri.verifyScannerNumber(scanObj);

        //Validate the user's choice
        if (chooseChoice < 0 || chooseChoice > campArray.size()){
            System.out.println("Invalid choice. Exiting Submit Enquiry");
            return;
        }else if (chooseChoice == 0){
            System.out.println("Exiting Submit Enquiry.");
            return;
        }
        // Consume the newline character
        scanObj.nextLine();

        System.out.println("Enter your description:");
        String description =  scanObj.nextLine();

        // Create and add enquiry to the list
        Enquiry enquiry = new Enquiry(campArray.get(chooseChoice-1).getCampID(), description, cookie,campArray);
        enquiryList.addEnquiry(enquiry);

        System.out.println("Enquiry submitted successfully");
    }

    private void showEnquiryForStudent(User student, List<Camp> campList) {
        System.out.println("You selected Show Enquiries:");
        enquiryList.viewEnquiryStudent(student, campList);
    }

    public void showEnquirymini(User student) {
        System.out.println("You selected Show your Enquiries:");
        enquiryList.viewEnquiryStudentmini(student);
    }

    //@Override
    public boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        showEnquiryForStudent(cookie,camp_array);
        return false;
    }

    //@Override
    public boolean runEdit(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You selected Edit Enquiries.");



        do {
            System.out.println("=== Enquiry EDIT UI ===");
            System.out.println("1. Edit Description");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");


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
                    showEnquirymini(cookie);
                    System.out.println("=====================================");
                    System.out.println("Which Enquiry do you want to edit?");
                    System.out.println("=====================================");
                    int enquiryID = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    System.out.println("Enter the new description:");
                    String newDescription = scanner.nextLine();
                    enquiryList.editEnquiryDescription(enquiryID, cookie.getUserID(),newDescription);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice !=0);

        return false;
    }



    @Override
    public boolean runDelete(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        int thechosenone;
        showEnquirymini(cookie);
        System.out.println("You selected Delete Enquiry:");
        System.out.println("Which Enquiry do you want to delete?");
        thechosenone = veri.verifyScannerNumber(scanObj);
        enquiryList.deleteEnquiryByID(thechosenone, cookie);
        return false;
    }
}