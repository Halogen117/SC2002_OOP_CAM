package com.mycompany.anothercam;
import java.util.ArrayList;
import java.util.Objects;


import static com.mycompany.anothercam.Status.*;

public class EnquiryList {
    private static ArrayList<Enquiry> enquiryList = new ArrayList<>();

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
    public void viewEnquiryStudent(User student) {
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
    public void viewEnquiryStaff(int campID) {
        System.out.println("=== Enquiries List ===");
        for (Enquiry enquiry : enquiryList) {
            if (enquiry.getCampID() == campID){
                System.out.println("================================");
                enquiry.viewEnquiryDetailsStaff();
            }
        }
    }

    public void viewEnquiryStudentmini(User student){                 
        System.out.println("=== Enquiries List ===");
        for (Enquiry enquiry : enquiryList) {
            if (enquiry.getNameofStudent().equals(student.getUserID())) {
                if (enquiry.getStatus() == Enquiry.Status.PENDING) {
                    System.out.println("================================");
                    //enquiry.viewEnquiryDetailmini();
                } else { // senquiry.getStatus() == PROCESSED
                    System.out.println("Enquiry: cannot be edited/viewed");
                }
            }
        }
    }

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

    public void deleteEnquiryByID(int enquiryID, User nameofstudent) {
        Enquiry.deleteEnquiry(enquiryList, enquiryID, nameofstudent.getUserID());
    }


    /*public static Enquiry getEnquirybyID(int enquiryID){    //getting enquiry by ID
        for (Enquiry enquiry : enquiriesList){
            if (enquiry.getEnquiryID() == enquiryID){
                return(enquiry);
            }
        }
        return null;                               //enquiry not found 
    }

    public static List<Enquiry> getAllEnquiries(){    //getting all enquiries 
        return new ArrayList<>(enquiriesList);
    }

    public static void printAllEnquiries(){
        for (Enquiry enquiry : enquiriesList){
            System.out.println(enquiry.getEnquiryID() + ":" + enquiry.getDescription());
        }
    }*/
    
}
