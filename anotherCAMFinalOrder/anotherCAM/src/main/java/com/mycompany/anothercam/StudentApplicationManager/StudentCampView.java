/**
* Runs the StudentCampView Object.
* @param campArray the CampArray which the new camp object is stored.
* @param cookie the User Object (A Student) which the requested user creates the Camp
* @param scanObj takes in the scanner Object for automated testing.
* @return the boolean value whether the deletion of camp object was successful.
*/

package com.mycompany.anothercam.StudentApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Camp.visibilityStatus;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentCampView{
     /**
    * Runs the Student View Application..
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Student) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return the boolean value whether the viewing of camp object was successful.
    */
    public boolean runStudentViewCamp(ArrayList<Camp> campArray, Student cookie, Scanner scanObj){
        Verification verifier = new Verification();
        // Filtered array based on faculty info
        ArrayList<Integer> getCampChoice = null;
        if(cookie.getCampCommittee()){
            getCampChoice = runViewCampListOutCampCommittee(campArray, cookie);
        }else{
            getCampChoice = runViewCampListOutAttendee(campArray, cookie);
        }
        if(getCampChoice == null){
            return true;
        }
        int chooseCampChoice = verifier.verifyScannerNumber(scanObj);

        if(chooseCampChoice == 0){
            System.out.println("Exiting Viewing Camp menu!");
            return true;
        }else if((0 < chooseCampChoice)&&(chooseCampChoice < getCampChoice.size()+1)){
            // Check what is the role of the user!
            System.out.println("The camp name is "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getCampName());
            System.out.println("The date the camp starts is on "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getDateString());
            System.out.println("The registration date the camp ends is on "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getRegClosingDateString());
            System.out.println("The location of the camp is "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getLocation());
            System.out.println("The total slots available in the camp are "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getTotalSlot());
            /*
            if(campArray.get(i-1).getCampCommitteeSlots().isEmpty()){
                System.out.println("There are no camps that exist at the moment.");
            }else{
                System.out.println("The camp committee members so far are ");
                for(Student stud: campArray.get(i-1).getCampCommitteeSlots()){
                    System.out.println(stud.getUserID());
                }
            }
            */
            System.out.println("The Description of the camp is "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getDescription());
            System.out.println("The faculty of the camp it is under is "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getFaculty());
            System.out.println("The staff in charge of the camp is "+campArray.get(getCampChoice.get(chooseCampChoice-1)).getStaffInCharge());
            // Find a way to check if student_list is empty
            /*
            if(campArray.get(i-1).getStudentList().isEmpty()){
                System.out.println("There are no students who signed up for the camp at the moment!");
            }else{
                System.out.println("The students in the camp so far are ");
                for(Student stud: campArray.get(i-1).getStudentList()){
                    System.out.println(stud.getUserID());
                }
            }
            */
        }else{
            System.out.println("That camp choice does not exist!");
            return true;
        }
        
        return true;
    }
    
    public ArrayList<Integer> runViewCampListOutAttendee(ArrayList<Camp> campArray, User cookie){
        ArrayList<Integer> countKeep = new ArrayList<Integer>();
        // Filtered array based on faculty info
        if(!checkCampValid(campArray, cookie)){
            System.out.println("No camps exist at the moment!");
            return null;
        }else{
            System.out.println("Which camp would you like to view? ");
                for(int i=1; i< campArray.size()+1; i++){
                    if((campArray.get(i-1).getVisiblility().equals(visibilityStatus.FACULTY)&& campArray.get(i-1).getFaculty().matches(cookie.getFacultyInfo()))|| campArray.get(i-1).getVisiblility().equals(visibilityStatus.ENTIRESCHOOL)){
                        countKeep.add(i-1);
                        int remainigSlot = campArray.get(countKeep.get(countKeep.size()-1)).getTotalSlot() - campArray.get(countKeep.get(countKeep.size()-1)).getCampStudentList().size();
                        System.out.println(countKeep.size()+". Camp "+campArray.get(countKeep.get(countKeep.size()-1)).getCampName()+" on display! (Remaining Attendee Slots: "+remainigSlot+")");
                    }
                }
                System.out.println("0. Exit Camp View");
                return countKeep;
        }
    }
    
    public ArrayList<Integer> runViewCampListOutCampCommittee(ArrayList<Camp> campArray, User cookie){
        ArrayList<Integer> countKeep = new ArrayList<Integer>();
        // Filtered array based on faculty info
        if(!checkCampValid(campArray, cookie)){
            System.out.println("No camps exist at the moment!");
            return null;
        }else{
            System.out.println("Which camp would you like to view? ");
                for(int i=1; i< campArray.size()+1; i++){
                    if((campArray.get(i-1).getVisiblility().equals(visibilityStatus.FACULTY)&& campArray.get(i-1).getFaculty().matches(cookie.getFacultyInfo()))|| campArray.get(i-1).getVisiblility().equals(visibilityStatus.ENTIRESCHOOL)){
                        countKeep.add(i-1);
                        int remainigSlot = campArray.get(countKeep.get(countKeep.size()-1)).getCampCommitteeSlots()- campArray.get(countKeep.get(countKeep.size()-1)).getCampCommitteeList().size();
                        System.out.println(countKeep.size()+". Camp "+campArray.get(countKeep.get(countKeep.size()-1)).getCampName()+" on display! (Remaining Camp Committee Slots: "+remainigSlot+")");
                    }
                }
                System.out.println("0. Exit Camp View");
                return countKeep;
        }
    }
    
    public boolean checkCampValid(ArrayList<Camp> campArray, User cookie){
        for(int i=1; i< campArray.size()+1; i++){

            if((campArray.get(i-1).getVisiblility().equals(visibilityStatus.FACULTY)&& campArray.get(i-1).getFaculty().matches(cookie.getFacultyInfo()))|| campArray.get(i-1).getVisiblility().equals(visibilityStatus.ENTIRESCHOOL)){
                return true;
            }
        }
        return false;
    }
        
}

