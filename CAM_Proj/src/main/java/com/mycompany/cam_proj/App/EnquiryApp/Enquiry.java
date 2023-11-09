package com.mycompany.cam_proj.App.EnquiryApp;
import java.util.Scanner;

//Enquiry App class : main class that contains main method that handles overall flow
//Status Enumeration : rep status of enquiries
//EnquiriesInterface interface : define methods for viewing, editing,deleting enquiries 
//EnquiriesMenuOptions : displaying menu items, getting user input 
//EnquiriesListClass : class to manage the list of enquiries - add, remove enquiries 
//Enquiry class : to represent an individual enquiry 

// ID OR NAME??

enum Status {
    APPROVED, PENDING, REJECTED;
}

public class Enquiry {
    private String camp_name;   //campID or campname
    private int campID;
    private int userID;
    private int enquiryID; // auto increment the Suggestion ID
    private static int nextid = 001;    

    private String description;
    private Status status;
    private String reply;
    private String nameofStudent;  //do we need name or just userID?
    //private Date timestamp - need?

    public Enquiry(String camp_name, int campID,int userID, String description, Status status, String reply, String nameofStudent) {
        this.camp_name = camp_name;
        this.campID = campID;
        this.userID = userID;
        this.enquiryID = nextid;    
        this.description = description;
        this.status = status;  //Status.PENDING?
        this.reply = reply;
        this.nameofStudent = nameofStudent;
        nextid++;
    }

    public Enquiry(Scanner scanner) {                   //submitting enquiry
        System.out.print("Enter your name: ");       // ID or name?
        this.nameofStudent= scanner.nextLine();
        this.enquiryID = getNextID();
        System.out.print("Enter Camp Name: ");
        this.camp_name = scanner.nextLine();
        System.out.print("Enter Description of Enquiry: ");
        this.description = scanner.nextLine();
        this.status = Status.PENDING;
        //this.timestamp = new Date();

    }

    public void viewEnquiryDetails() {              //view enquiry
        System.out.println("Enquiry details:");
        System.out.println("CampID: " + getCampID());
        System.out.println("Camp Name: " + getCampName());
        System.out.println("EnquiryID: " + getEnquiryID());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Enquiry: " + getDescription());
        System.out.println("Status: " + getStatus());
    }

    public void updateStatus(Status newStatus){
        this.status = newStatus;
    }

    public void approveEnquiry() {
        this.status = Status.APPROVED;      //approve means will reply
    }

    public void rejectEnquiry() {
        this.status = Status.REJECTED;
    }

    public void editEnquiry(String newDescription) {                //edit enquiry
        this.description = newDescription;
    }

    public void deleteEnquiry(){                            //delete enquiry
        //remove from enquiry list?
        this.status = Status.DELETED;
        //EnquiriesList.removeEnquiry(this);
    
    }
    public void replyToEnquiry(String reply) {          //reply to enquiry
        this.reply = reply;
        this.status = Status.APPROVED;
    }

    public String getCampName() {
        return camp_name;
    }

    public void setCampName(String campName) {
        this.camp_name = campName;
    }

    public int getCampID(){
        return campID;
    }

    public void setCampID(int campID){
        this.campID = campID;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getStudentName() {
        return nameofStudent;
    }

    public void setStudentName(String nameofStudent) {
        this.nameofStudent = nameofStudent;
    }

   // public Date getTimestamp() {
       // return timestamp;
    //}

    

}
