package com.mycompany.anothercam;

import java.util.Iterator;
import java.util.List;

import com.mycompany.anothercam.Login.Verification;

/**
 * The public Enumeration of the visibility status of the camp.
 * PENDING: Enquriries are pending and yet to be replied by staff/student committee
 * PROCESSED: Enquiries are processed and replied by staff/student committee
 */



public class Enquiry {
public enum Status {
    PENDING, PROCESSED;
}
    private Verification verify = new Verification();
    private int campID;
    private List<Camp> campList;
    private int enquiryID; // auto increment the enquiry ID
    private static int nextid = 1;    

    private String description;
    private Status status;
    private String reply;
    private String nameOfStudent;  
    private Camp camp;
    private User student;

    /*
     *Camp Constructor 
     @param CampID - unique campid to identify which camp the enquiries are going to be listed under 
     @param EnquiryID - each user has an unique enquiry id which increases for every new enquiry being made
     @param description - description of the reply from student and student commmittee 
     @param status 
     @param nameOfStudent - name of the student who made the enquiry
     */

    public Enquiry(int campID, String description, Student student, List<Camp> campList) {
        this.campID = campID;
        this.enquiryID = nextid;    
        this.description = description;
        this.status = Status.PENDING; 
        this.nameOfStudent = student.getUserID();
        this.reply = "Enquiry is still pending, Processing reply...";            //base case  NULL??
        this.student = student;
        this.campList = campList;
        nextid++;
    }

    
/*
    public boolean submitEnquiry(User student, Scanner scanner, Camp campInstance) {                   //submitting enquiry  
        System.out.print("Enter Camp ID: ");                           // submitting enquiry for camp, userid is already being stored
        this.campID = verify.verifyScannerNumber(scanner);
        this.enquiryID = nextid;
        System.out.print("Enter Description of Enquiry: ");
        this.description = scanner.nextLine();
        this.status = Status.PENDING;
        this.nameOfStudent = student.getUserID();  
        nextid++;   
        return true;
    }
*/
    /* Gets details of the enquiry.
     * @return the campID, enquiryID, description, status, nameofStudent
    */

    public Enquiry(List<Camp> campList) {
        this.campList = campList;
    }
    public void viewEnquiryDetailsStudent() {              //view enquiry : from userid pov
        System.out.println("Enquiry details:");
        System.out.println("CampID: " + campID);
        System.out.println("Camp Name: " + getCampNameByID(campID,campList));
        System.out.println("EnquiryID: " + getEnquiryID());
        //System.out.println("Name of Student: " + getNameofStudent());
        System.out.println("Description: " + getDescription());
        System.out.println("Status: " + getStatus());
       
        if (getStatus() == Status.PROCESSED) {
            System.out.println("Reply: " + getReply()); // Override only if the status is PROCESSED
        }

    }

    public void viewEnquiryDetailMini() {              //this is for the editing of enquiry - only before it gets deleted or processed
        System.out.println("Enquiry details:");
        System.out.println("Camp Name: " + getCampNameByID(campID,campList));
        System.out.println("EnquiryID: " + getEnquiryID());
        System.out.println("Description: " + getDescription());
        //System.out.println("Status: " + getStatus());
        
    }

    public void viewEnquiryDetailsStaff() {              //view enquiry
        //System.out.println("Enquiry details for the camp you are overseeing:");
        //System.out.println("CampID: " + getCampID());
       System.out.println("EnquiryID: " + getEnquiryID());
        //System.out.println("Camp Name: " + getCampName());
        //System.out.println("Student Name: " + getNameofStudent());
        System.out.println("Description: " + getDescription());             //GET REPLY add it in later
        System.out.println("Status: " + getStatus());
        //System.out.println("Reply: " + getReply());
    }
    public void viewEnquiryDetailsStaffmini() {              //view enquiry for reply
        //System.out.println("Enquiry details for the camp you are overseeing:");
        //System.out.println("CampID: " + getCampID());
        System.out.println("EnquiryID: " + getEnquiryID());
        //System.out.println("Camp Name: " + getCampName());
        //System.out.println("Student Name: " + getNameofStudent());
        System.out.println("Description: " + getDescription());
        //System.out.println("Status: " + getStatus());
        //System.out.println("Reply: " + getReply());
    }
     /**
     * Gets the details of the enquiries.
     * @return the campID, enquiryID , Description ,Status , name of student
     *
     */

    public void updateStatus(Status newStatus){
        this.status = newStatus;
    }

    /** Gets the camp name by ID.
            * @param campID The ID of the camp.
            * @param campList The list of camps.
     * @return The camp name corresponding to the ID.
     */
    private String getCampNameByID(int campID, List<Camp> campList) {
        for (Camp camp : campList) {
            if (camp.getCampID() == campID) {
                return camp.getCampName();
            }
        }
        return "Camp Not Found";
    }

    /*public void editEnquiry(String newDescription) {                //edit enquiry
        this.description = newDescription;
    }*/

    public void replyToEnquiry(String reply) {          //reply to enquiry
        this.reply = reply;
        this.status = Status.PROCESSED;
    }

    public String getCampName() {
        return camp.getCampName();
    }

    public int getCampID(){
        return campID;
    }
    
    public String getUserID() {
        return student.getUserID();
    }

    public int getEnquiryID() {
        return enquiryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReply() {                      //view reply
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getNameofStudent() {
        return nameOfStudent;
    }

      /**
     * Delete the enquiry that the student has created provided that the enquiriy is not processed
     * @param enquiriesList The enquiries list to find out which enquiry to delete from the list
     * @param whichtodelete This to check the enquiry who the camp committee member want to delete matches the student
     * @param nameofstudent This is to check if the student who is deleting the enquiry is the one who created the enquiries
    **/

    public static void deleteEnquiry(List<Enquiry> enquiryList, int whichtodelete, String nameofStudent) {
        Iterator<Enquiry> iterator = enquiryList.iterator();
        while (iterator.hasNext()) {
            Enquiry enquiry = iterator.next();
            if (enquiry.getEnquiryID() == whichtodelete && enquiry.getNameofStudent().equals(nameofStudent)) { // check if the enquiry is by the same student who created it and also the same one that the user chose to delete
                if (enquiry.getStatus() == Status.PROCESSED) { // check if it has already been processed
                    System.out.println("Enquiry cannot be Deleted");
                } else {
                    iterator.remove(); // Remove the enquiry from the list
                    System.out.println("Enquiry " + whichtodelete + " deleted");
                }
            }
        }
    }

}
