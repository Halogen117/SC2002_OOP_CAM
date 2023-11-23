package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.EnquiryList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;
class EnquiryStaffMenuOptions {
    private Verification veri = new Verification();
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
        enquirylist.viewEnquiryStaff();
    }

    public void showEnquirymini (){ 
        enquirylist.viewEnquiryStaff();
        
    }

    public void setStatus(Scanner scanObj){
        
        String choice;
        showEnquirymini();
        System.out.println("Which Enquiry do you want to reply?");
        int thechosenone = veri.verifyScannerNumber(scanObj);
        System.out.println("Do you want to reply?(yes/no)");
        choice = scanObj.next();

        if(Objects.equals(choice, "yes")){
            System.out.println("Enter your reply:");
            String reply = scanObj.nextLine();
            Enquiry enquiry = enquirylist.getEnquirybyID(thechosenone);
            
            if (enquiry != null) {
                enquiry.replyToEnquiry(reply);
                enquirylist.process(thechosenone);
                System.out.println("Enquiry replied and processed successfully");
            } else {
                System.out.println("Enquiry not found");
            }
            
        } else if (Objects.equals(choice, "no")) {
            System.out.println("Enquiry not replied");
        } else {
            System.out.println("Invalid choice. Please try again");
        }
    }

}