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

/**
 Allows the student to view the menu of the Enquiries.
 Allow the student to view the enquiries options.
 @author Matthias Lim Xing Ran
 @version 1.0
 @since 2023-11-17
 */
public class EnquiryStudentMenuOptions implements ViewEditDelete {      //create subinterfaces!! enquiry doesnt delete
    private Verification veri = new Verification();

    private EnquiryList enquiryList;
    private int choice;

    /**
     * Sets the Enquiry Student List Object
     * @param enquiryList contains the EnquiryList to be initialized.
     */
    public EnquiryStudentMenuOptions(EnquiryList enquiryList) {
        this.enquiryList= enquiryList;
    }

    /**
     *
     * @param campArray
     * @param cookie
     * @param scanObj
     */
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

    
    /**
     * Shows the Student Enquiries.
     * @param student The Student Object to pass to.
     * @param campList The list of camps required to print out.
    */
    private void showEnquiryForStudent(User student, List<Camp> campList) {
        System.out.println("You selected Show Enquiries:");
        enquiryList.viewEnquiryStudent(student, campList);
    }

    /**
     * Shows the miniturized Enquiry Application.
     * @param student The student Object passed into the function.
     */
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
        System.out.println("You selected Edit Enquiries.");
        String newDescription = null;


        do {
            System.out.println("=== Enquiry EDIT UI ===");
            System.out.println("1. Edit Description");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = veri.verifyScannerNumber(scanObj);
            switch (choice) {
                case 1:
                    showEnquirymini(cookie);
                    System.out.println("=====================================");
                    System.out.println("Which Enquiry do you want to edit?");
                    System.out.println("=====================================");
                    int enquiryID = veri.verifyScannerNumber(scanObj);
                    newDescription = veri.verifyDescription(newDescription, "Enter the new description.", scanObj);
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