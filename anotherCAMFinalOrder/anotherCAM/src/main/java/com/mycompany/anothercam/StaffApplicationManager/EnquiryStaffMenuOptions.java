package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.EnquiryList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.implementActions.ViewReply;

public class EnquiryStaffMenuOptions implements ViewReply {
    private Verification veri = new Verification();
    private ArrayList<Enquiry> enquiryList;
    EnquiryList enquirylist = new EnquiryList();

    public EnquiryStaffMenuOptions(EnquiryList enquiryList) {
        this.enquiryList = EnquiryList.enquiryList;
    }

    //@Override
    public boolean runView(ArrayList<Camp> camp_array, User cookie, Scanner scanObj) {
        showEnquiryForStaff();
        return false;
    }

    public void showEnquiryForStaff() {
        System.out.println("You selected Show Enquiry:");
        enquirylist.viewEnquiryStaff(false);
    }

    public void showEnquiryForStaffmini (){
        enquirylist.viewEnquiryStaff(true);
        
    }
    //@Override
    public boolean runReply(Scanner scanObj){
        
        String choice;
        System.out.println("Which Enquiry do you want to reply?");
        showEnquiryForStaffmini();
        int thechosenone = veri.verifyScannerNumber(scanObj);

        // Consume the newline character
        scanObj.nextLine();

        System.out.println("Do you want to reply?(yes/no)");
        choice = scanObj.nextLine().toLowerCase();

        if(Objects.equals(choice, "yes")){
            System.out.println("Enter your reply:");
            String reply = scanObj.nextLine();
            Enquiry enquiry = enquirylist.getEnquirybyID(thechosenone);   //accessing the specific enquiry object that staff member wants to reply to
            
            if (enquiry != null) {
                enquiry.replyToEnquiry(reply);
                enquirylist.process(thechosenone);
                System.out.println("Enquiry replied and processed successfully");
                return true;
            } else {
                System.out.println("Enquiry not found");
            }
            
        } else if (Objects.equals(choice, "no")) {
            System.out.println("Enquiry not replied");
        } else {
            System.out.println("Invalid choice. Please try again");
        }
        return false;
    }

}