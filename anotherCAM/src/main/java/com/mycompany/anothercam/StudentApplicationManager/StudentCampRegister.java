/**
Represents the StudentCampRegister Object and the following assistance methods.
A StudentCampRegister is ran dependent on how many users are going to register for the camp.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-27
*/
package com.mycompany.anothercam.StudentApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.DateFormatter;

public class StudentCampRegister {
    /**
    * Runs the Student Register Application.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Student) which the requested user registers the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    
    public boolean runStudentRegister(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        if(campArray.isEmpty()){
            System.out.println("No camps to register for!");
            return false;
        }else{
            System.out.println("Register as a");
            System.out.println("0. Exit Register Main Menu");
            System.out.println("1. Camp Attendee");
            System.out.println("2. Camp Committee Member");
            int choiceAttend = scanObj.nextInt();
            if(choiceAttend == 0){
                return false;
            }
            System.out.println("Which camp would you like to register?");
            StudentCampView studView = new StudentCampView();
            
            ArrayList<Integer> choice = studView.runViewCampListOut(campArray, cookie);
            int chooseChoice = scanObj.nextInt();
            if(choice == null){
                System.out.print("No Camps exist at the moment!");
                return true;
            }else if(!choice.contains(chooseChoice)){
                System.out.println("Choice outside of input! Exiting Register Main Menu");
                return false;
            }
            System.out.println("Are you sure you want to register for Camp "+campArray.get(chooseChoice-1).getCampName()+"? (Y/N)");
            String yes_no = scanObj.next();
            
            if(yes_no.equals("Y") || yes_no.equals("YES")){
                // Check if student registered for other camps
                if(checkDateClash(choice, campArray,chooseChoice, (Student) cookie)){
                    return false;
                }
                // Check if camp is full
                if(checkCampFull(campArray, chooseChoice)){
                    System.out.println("Camp is already full!");
                    return false;
                }else if(checkAttendeeList(choice, campArray, (Student) cookie, chooseChoice) && choiceAttend == 1){
                    System.out.println("You are already an attendee in the camp!");
                }

                if(choiceAttend == 1){
                    campArray.get(chooseChoice-1).addStudentToList((Student) cookie);
                }else if(choiceAttend == 2){
                    // Check if camp Committee
                    if(checkCampCommittee((Student) cookie)){
                        System.out.println("Students are capped at 1 camp committee member at the max!");
                    }else{
                        if(!checkAttendeeList(choice, campArray, (Student) cookie, chooseChoice)){
                            campArray.get(chooseChoice-1).addStudentToList((Student) cookie);
                        }
                            setCampCommittee((Student) cookie, campArray.get(chooseChoice -1).getCampName());
                            campArray.get(chooseChoice-1).addCampCommitteeMemberToList((Student) cookie); 
                    }
                }

                
            }else if(yes_no.equals("N") || yes_no.equals("NO")){
                System.out.println("Exiting Register option!");
                return false;
            }
            return true;
        }
    }
    
    /**
    * Returns if the Student object is a camp committee member.
    * @param Stud takes in the Student Object to check if they are camp committee member
    * @return boolean value if student is part of camp committee or not.
    */
    public boolean checkCampCommittee(Student Stud){
        return Stud.getCampCommittee();
    }
    
    /**
    * Returns to check if the camp student attendee is at full capacity.
    * @param campArray the CampArray which the new camp object is stored.
    * @param chooseChoice takes in the choice of camp to be check if it is full.
    * @return boolean value if the camp is filled. True if it is filled. False if it is not filled.
    */
    public boolean checkCampFull(ArrayList<Camp> campArray, int chooseChoice){
        // Check if the camp is full
        if(campArray.get(chooseChoice-1).getTotalSlot() >= campArray.get(chooseChoice-1).getCampStudentList().size()){
            return false;
        }
        return true;
    }

    /**
    * Sets the student to the new camp committee member of the camp.
    * @param Stud takes in the student object to be a new camp committee member.
    * @param campName takes in the campName to be set for the Camp Committee assigned to the student.
    */
    public void setCampCommittee(Student Stud, String campName){
        Stud.setCampCommittee(true);
        Stud.setCampCommitteeName(campName);
        System.out.println("Successfully set as Camp Committee Member!");
    }
    
    /**
    * Checks if the student is in the camp
    * @param choice takes in the arraylist of integer choices to be used to check attendee list.
    * @param Stud takes in the student object to be checked if they are an attendee.
    * @param campArray the CampArray which the new camp object is stored.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    * @param chooseChoice takes in the choice of camp to be check for the student.
    */
    public boolean checkAttendeeList(ArrayList<Integer> choice, ArrayList<Camp> campArray, Student Stud, int chooseChoice){
            if(campArray.get(choice.indexOf(chooseChoice)).getCampStudentList().contains(Stud)){
                return true;  
        }
        return false;
    }
    
    /**
    * Checks if the dates for the student will clash
    * @param choice takes in the arraylist of integer choices to be used to check for clashed dates.
    * @param Stud takes in the student object to be checked for clashed date.
    * @param campArray the CampArray which the new camp object is stored.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    * @param chooseChoice takes in the choice of camp to be check if the date clash.
    * @return returns true if the dates clash. Dates don't clash is false
    */
    public boolean checkDateClash(ArrayList<Integer> choice, ArrayList<Camp> campArray , int chooseChoice, Student Stud){
        // Check for the camps the student is in, if got date clash (Same day)
        DateFormatter formaDat  =new DateFormatter();
        /*
        for(int i =0; i< choice.size(); i++){
            if(formaDat.clashDates(campArray.get(i).getDate(), campArray.get(choice.get(chooseChoice-1)).getDate())){
                return true;
            }
        }
        
        return false;
        
        
        */  
        return false;
    }
}
