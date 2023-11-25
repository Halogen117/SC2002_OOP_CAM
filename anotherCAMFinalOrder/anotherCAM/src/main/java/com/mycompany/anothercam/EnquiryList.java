package com.mycompany.anothercam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
Represents the Enquiry List Object and the following assistor methods.
A Enquiry List object can be created depending on how many enquiries to be formatted.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-16
*/
public class EnquiryList {

    /**
     * Static ArrayList of enquiry variables.
     */
    public static ArrayList<Enquiry> enquiryList = new ArrayList<>();

    /**
     * add enquiry into the array
     * @param enquiry is the enquiry to be deleted
     *
     */

    public void addEnquiry(Enquiry enquiry){      //submit enquiry
        Objects.requireNonNull(enquiryList, "EnquiryList must be initialized");
        enquiryList.add(enquiry);    
    }

    //STUDENT 

    /**
     * Runs the function to view the enquiry of the student.
     * @param student Student Object that is passed.
     * @param campList CampList of the camps present in the camp.
     */
    public void viewEnquiryStudent(User student, List<Camp> campList) {
        System.out.println("=== Enquiries List ===");
        boolean foundEnquiry = false;

        for (Enquiry enquiry : enquiryList) {
            if (enquiry.getNameofStudent().equals(student.getUserID())){       //enquiry.getUserID() == student.getUserID()
                System.out.println("================================");
                enquiry.viewEnquiryDetailsStudent();
                foundEnquiry = true;
            }
        }
        if (!foundEnquiry){
            System.out.println("No such enquiry submitted by User");

        }
    }

    //STAFF

    /**
     * Runs the view Enquiry Staff function.
     * @param useMiniDetails The boolean variable of the mini details.
     */
    public void viewEnquiryStaff(boolean useMiniDetails) {
        System.out.println("=== Enquiries List ===");
        System.out.println("Enquiry details for the camp you are overseeing:");
        for (Enquiry enquiry : enquiryList) {
            System.out.println("================================");
            if (useMiniDetails) {
                enquiry.viewEnquiryDetailsStaffmini();
            } else {
                enquiry.viewEnquiryDetailsStaff();
            }
        }
    }

    /**
     * Runs the function to view Enquiry for the student in terms of the mini output.
     * @param student The student object that is passed.
     */
    public void viewEnquiryStudentmini(User student){                 
        System.out.println("=== Enquiries List ===");
        for (Enquiry enquiry : enquiryList) {
            if (enquiry.getNameofStudent().equals(student.getUserID())) {
                if (enquiry.getStatus() == Enquiry.Status.PENDING) {
                    System.out.println("================================");
                    enquiry.viewEnquiryDetailMini();
                } else { // enquiry.getStatus() == PROCESSED
                    System.out.println("Enquiry "+ enquiry.getEnquiryID() + " cannot be edited/viewed");
                }
            }
        }
    }

    /**
     * Runs the function to edit the enquiry description.
     * @param enquiryID the enquiryID that is edited
     * @param newNameOfStudent the new name of the student that submitted the enquiry.
     * @param newDescription the new description of the enquiry.
     */
    public void editEnquiryDescription(int enquiryID, String newNameOfStudent, String newDescription) {
        for (Enquiry enquiry : enquiryList) {
            if (enquiry.getEnquiryID() == enquiryID) {
                if (enquiry.getStatus() == Enquiry.Status.PROCESSED) {
                    System.out.println("Enquiry cannot be edited because it has been processed");
                    return;
                } else {
                    if (enquiry.getNameofStudent().equals(newNameOfStudent)) {
                        enquiry.setDescription(newDescription);
                        System.out.println("Enquiry updated successfully");
                        return;
                    } else {
                        System.out.println("You can only edit your own enquiries");
                        return;
                    }
                }
            }
        }
        System.out.println("Enquiry not found, please try again");
    }

     /**
     * Find the specific enquiry to be PROCESSED
     * @param chosenone is the enquiry to be changed to PROCESSED
     *
     */
    
    public void process(int chosenone) {
        for (Enquiry enquiry : enquiryList){
            if (enquiry.getEnquiryID() == chosenone){
                enquiry.updateStatus(Enquiry.Status.PROCESSED);
            }
        }
    }

    /**
     * Runs the function to delete the enquiry.
     * @param enquiryID gets the enquiryID of the enquiry to be deleted.
     * @param nameofstudent gets the student Object passed.
     */
    public void deleteEnquiryByID(int enquiryID, User nameofstudent) {
        Enquiry.deleteEnquiry(enquiryList, enquiryID, nameofstudent.getUserID());
    }

    /**
     * Runs the function to get the Ennquiry by ID.
     * @param enquiryID gets the enquiryID of the enquiry to be deleted.
     * @return the Enquiry object that is to be returned.
     */
    public static Enquiry getEnquirybyID(int enquiryID){    //getting enquiry by ID
        for (Enquiry enquiry : enquiryList){
            if (enquiry.getEnquiryID() == enquiryID){
                return(enquiry);
            }
        }
        return null;                               //enquiry not found 
    }
    /*
    public static List<Enquiry> getAllEnquiries(){    //getting all enquiries 
        return new ArrayList<>(enquiriesList);
    }

    public static void printAllEnquiries(){
        for (Enquiry enquiry : enquiriesList){
            System.out.println(enquiry.getEnquiryID() + ":" + enquiry.getDescription());
        }
    }*/
    
}
