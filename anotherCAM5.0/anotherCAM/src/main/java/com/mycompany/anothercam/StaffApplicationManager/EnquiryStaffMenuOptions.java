package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.EnquiryList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class EnquiryStaffMenuOptions {
    private ArrayList<Enquiry> enquiryList;
    EnquiryList enquirylist = new EnquiryList();

    //public EnquiryStaffMenuOptions(EnquiryList enquiryList) {
        //this.enquiryList = EnquiryList.enquiryList;
    //}

    public void view() {
        showEnquiryForStaff();
    }

    private void showEnquiryForStaff() {
        System.out.println("You selected Show Enquiry:");
        //enquirylist.viewEnquiryStaff();
    }

    public void showEnquirymini (){ 
        //enquirylist.viewEnquiryStaff();
        
    }

    public void setStatus( ){
        int thechosenone;
        String choice;
        Scanner scanner = new Scanner(System.in);
        showEnquirymini();
        System.out.println("Which Enquiry do you want to reply?");
        thechosenone = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.println("Do you want to reply?(yes/no)");
        choice = scanner.next();

        if(Objects.equals(choice, "yes")){
            System.out.println("Enter your reply:");
            String reply = scanner.nextLine();
            //Enquiry enquiry = enquirylist.getEnquiryByID(thechosenone);
            /*
            if (enquiry != null) {
                enquiry.replyToEnquiry(reply);
                enquirylist.process(thechosenone);
                System.out.println("Enquiry replied and processed successfully");
            } else {
                System.out.println("Enquiry not found");
            }
            */
        } else if (Objects.equals(choice, "no")) {
            System.out.println("Enquiry not replied");
        } else {
            System.out.println("Invalid choice. Please try again");
        }
    }

}