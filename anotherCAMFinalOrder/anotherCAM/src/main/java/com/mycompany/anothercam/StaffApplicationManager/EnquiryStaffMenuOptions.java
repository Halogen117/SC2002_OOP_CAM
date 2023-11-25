package com.mycompany.anothercam.StaffApplicationManager;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Enquiry;
import com.mycompany.anothercam.EnquiryList;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Staff;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.implementActions.View;
import com.mycompany.anothercam.implementActions.Reply;

/**
Represents the Enquiry Staff Menu Option Function and the following assistor methods.
A Enquiry Staff Menu Option Function can be created depending on how many enquiries to be formatted.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-16
*/
public class EnquiryStaffMenuOptions implements View, Reply {
    private Verification veri = new Verification();
    private ArrayList<Enquiry> enquiryList;
    EnquiryList enquirylist = new EnquiryList();

    /**
     * Runs the enquiry Staff application menu options.
     * @param enquiryList passes the EnquiryList Object.
     */
    public EnquiryStaffMenuOptions(EnquiryList enquiryList) {
        this.enquiryList = EnquiryList.enquiryList;
    }

    //@Override

    /**
     * Runs the view application for Enquiry Staff.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return the boolean of the run view application.
     */
    public boolean runView(ArrayList<Camp> campArray, User cookie, Scanner scanObj) {
        showEnquiryForStaff();
        return false;
    }

    /**
     * Runs the show Enquiry for Staff application.
     */
    public void showEnquiryForStaff() {
        System.out.println("You selected Show Enquiry:");
        enquirylist.viewEnquiryStaff(false);
    }

    /**
     * Runs the show Enquiry for Staff Mini function.
     */
    public void showEnquiryForStaffmini (){
        enquirylist.viewEnquiryStaff(true);
        
    }
    //@Override

    /**
     * Function to run Reply.
     * @param campArray the ArrayList of Camps that exist in the application.
     * @param cookie stores the User Object.
     * @param scanObj Scanner Object to take in inputs.
     * @return Returns boolean to check if the function ran successfully. True for success. False for unsuccessful.
     */
    public boolean runReply(Scanner scanObj, User cookie, ArrayList<Camp> campArray){
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
            int campID = -1;
            Enquiry enquiry = enquirylist.getEnquirybyID(thechosenone);   //accessing the specific enquiry object that staff member wants to reply to
            if(cookie instanceof Staff){
                Staff cookStaff = (Staff) cookie;
                for(int i=0; i< campArray.size(); i++){
                    if(campArray.get(i).getStaffInCharge().equals(cookStaff.getUserID())){
                        campID = campArray.get(i).getCampID();
                    }
                }
                if(!(enquiry.getCampID() == campID)){
                    System.out.println("As you are not the staff in charge of the camp, you cannot edit the enquiry");
                    return false;
                }
            }else{
                Student cookStud = (Student) cookie;
                int campIDTry = -1;
                for(int i=0; i< campArray.size(); i++){
                    for(int j=0; j< campArray.get(i).getCampCommitteeList().size(); j++){
                        if(campArray.get(i).getCampCommitteeList().get(j).getUserID().equals(cookStud.getUserID())){
                            campIDTry = campArray.get(i).getCampID();
                        }
                    }

                }
                if(!(enquiry.getCampID() == campIDTry)){
                    System.out.println("As you are not the camp committee member of the camp, you cannot edit the enquiry");
                    return false;
                }
            }
            //if(enquiry.getCampID() == cookie.){
                //System.out.println("You cannot reply to this enquiry as you are not the staff in charge");
                //return false;
            //}
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